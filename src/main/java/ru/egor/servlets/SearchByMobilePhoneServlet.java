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

public class SearchByMobilePhoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/searchByMobilePhone.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String m_phone = req.getParameter("m_phone");

        //JDBC
//        UserDao userDao = new UserDao();
//        User user1 = userDao.getUserMobilePhone(m_phone);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        User user1 = userHibDAO.getUserMobilePhone(m_phone);

        req.setAttribute("user", user1);
        doGet(req, resp);
    }
}
