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
import java.util.List;

public class SearchByFirstNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/searchByFirstName.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String f_name = req.getParameter("f_name");

        //JDBC
//        UserDao userDao = new UserDao();
//        List<User> users = userDao.searchByFirstName(f_name);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        List<User> users = userHibDAO.searchByFirstName(f_name);

        req.setAttribute("users", users);
        doGet(req, resp);
    }
}
