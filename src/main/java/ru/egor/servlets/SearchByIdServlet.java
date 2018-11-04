package ru.egor.servlets;

import ru.egor.DAO.UserHibDAO;
import ru.egor.model.User;
import ru.egor.DAO.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/searchById.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        //JDBC
//        UserDao userDao = new UserDao();
//        User user1 = userDao.getUserById(id);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        User user1 = userHibDAO.getUserById(id);

        req.setAttribute("user", user1);
        doGet(req, resp);
    }
}
