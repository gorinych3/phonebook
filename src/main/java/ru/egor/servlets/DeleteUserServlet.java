package ru.egor.servlets;

import ru.egor.DAO.UserHibDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/deleteUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        //list
//        UserImplDao DAO = UserImplDao.getINSTANCE();
//        DAO.delete(id);

        //JDBC
//        UserDao userDao = new UserDao();
//        userDao.delete(id);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        userHibDAO.deleteUser(id);

        req.setAttribute("id", req.getParameter("id"));
        doGet(req, resp);
    }
}
