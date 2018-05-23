package com.gmail.grind3x.controller;

import com.gmail.grind3x.model.Apartments;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteSevlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Apartments apartments = (Apartments) req.getSession().getAttribute("apartments");
            apartments.removeApartment(req.getParameter("address"));
            HttpSession session = req.getSession();
            session.setAttribute("message","Apartment successfully deleted!");
            resp.sendRedirect("/success.jsp");
        } catch (Exception e) {
            resp.sendRedirect("/error.jsp");
        }    }
}
