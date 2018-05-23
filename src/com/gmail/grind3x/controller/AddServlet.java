package com.gmail.grind3x.controller;

import com.gmail.grind3x.model.Apartment;
import com.gmail.grind3x.model.Apartments;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numberOfRooms = Integer.valueOf(req.getParameter("numberofrooms"));
        String address;
        int floor;
        int cost;
        HttpSession session = req.getSession(true);
        Apartments apartments = (Apartments) session.getAttribute("apartments");
        try {
            address = req.getParameter("address");
            floor = Integer.valueOf(req.getParameter("floor"));
            cost = Integer.valueOf(req.getParameter("cost"));

            if (apartments != null) {
                apartments.addApartment(new Apartment(numberOfRooms, address, floor, cost));
            } else {
                apartments = new Apartments();
                apartments.addApartment(new Apartment(numberOfRooms, address, floor, cost));
            }

            session.setAttribute("apartments", apartments);
            session.setAttribute("message","The apartment was successfully added to the database!");
            resp.sendRedirect("/success.jsp");
        }catch (NumberFormatException e) {
            resp.sendRedirect("/error.jsp");
        }
    }
}
