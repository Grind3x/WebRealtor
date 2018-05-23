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

@WebServlet(urlPatterns = "/recost")
public class RecostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Apartments apartments = (Apartments) req.getSession().getAttribute("apartments");
            Apartment apartment = apartments.getApartmentByAddress(req.getParameter("address"));
            apartment.setCost(Double.valueOf(req.getParameter("cost")));
            HttpSession session = req.getSession();
            session.setAttribute("message","Price successfully changed!");
            resp.sendRedirect("/success.jsp");
        } catch (Exception e) {
            resp.sendRedirect("/error.jsp");
        }

    }
}
