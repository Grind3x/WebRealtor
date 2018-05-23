package com.gmail.grind3x.controller;

import com.gmail.grind3x.model.Apartments;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/work")
public class LoadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Apartments apartments = null;

        int loaded = -1;
        try {
            apartments = Apartments.fromXML(items.get(0).getString());
            loaded = apartments.getApartments().size();
        } catch (Exception e) {
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("apartments", apartments);
        session.setAttribute("loaded", loaded);
        PrintWriter pw = resp.getWriter();
        pw.println(apartments);

        resp.sendRedirect("/load.jsp");
    }
}
