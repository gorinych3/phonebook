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
import java.util.concurrent.atomic.AtomicInteger;

public class AddServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = this.ids.incrementAndGet();
        //int id = Integer.parseInt(req.getParameter("id"));
        String f_name = req.getParameter("f_name");
        String l_name = req.getParameter("l_name");
        String address = req.getParameter("address");
        String home_phone = req.getParameter("home_phone");
        String m_phone = req.getParameter("m_phone");
        String profession = req.getParameter("profession");
        User user = new User(id, f_name, l_name, address, home_phone, m_phone, profession);

        //List
//        UserImplDao DAO = UserImplDao.getINSTANCE();
//        DAO.add(user);

        //JDBC
//        UserDao userDao = new UserDao();
//        userDao.add(user);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        userHibDAO.add(user);

        req.setAttribute("userName", req.getParameter("f_name"));
        doGet(req, resp);
    }
}
