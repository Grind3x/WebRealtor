package com.gmail.grind3x.controller;

import com.gmail.grind3x.model.Apartments;
import com.gmail.grind3x.model.Filter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Apartments apartments = (Apartments) session.getAttribute("apartments");
        int numberOfRooms = 0;
        String address = "";
        int floor = 0;
        int low = 0;
        int high = 0;

        address = req.getParameter("address");
        try {
            floor = Integer.valueOf(req.getParameter("floor"));
        } catch (NumberFormatException e) {
        }
        try {
            low = Integer.valueOf(req.getParameter("from"));
        } catch (NumberFormatException e) {
        }
        try {
            high = Integer.valueOf(req.getParameter("to"));
        } catch (NumberFormatException e) {
        }
        try {
            numberOfRooms = Integer.valueOf(req.getParameter("rooms"));
        } catch (NumberFormatException e){
        }

        req.setAttribute("apartments",Filter.getApartmentsByAllParameters(numberOfRooms, address, floor, low, high, apartments.getApartments()));
        System.out.println(req.getAttribute("apartments"));
        getServletContext().getRequestDispatcher("/result.jsp").forward(req,resp);

    }
}
