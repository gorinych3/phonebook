package ru.egor.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        UserImplDao DAO = UserImplDao.getINSTANCE();
////        List<String> names = DAO.list();
////        req.setAttribute("userNames", names);
//
//
//         UserDao userDao = new UserDao();
//        List<User> users = userDao.list();
//
//        req.setAttribute("user", users);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
