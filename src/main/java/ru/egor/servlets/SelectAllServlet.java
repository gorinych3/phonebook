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

public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //List
//        UserImplDao DAO = UserImplDao.getINSTANCE();
//        List<String> names = DAO.list();
//        req.setAttribute("userNames", names);

        //JDBC
//        UserDao userDao = new UserDao();
//        List<User> users = userDao.list();

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        List<User> users = (List<User>) userHibDAO.list();

        req.setAttribute("user", users);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selectAll.jsp");
        requestDispatcher.forward(req, resp);
    }

}
