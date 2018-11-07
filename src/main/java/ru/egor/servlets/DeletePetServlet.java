package ru.egor.servlets;

import ru.egor.DAO.UserHibDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/deletePet.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int pet_id = Integer.parseInt(req.getParameter("pet_id"));

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        userHibDAO.deletePet(user_id, pet_id);

        req.setAttribute("pet_id", req.getParameter("pet_id"));
        doGet(req, resp);
    }
}
