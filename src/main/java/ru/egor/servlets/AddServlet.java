package ru.egor.servlets;

import ru.egor.DAO.UserHibDAO;
import ru.egor.model.Car;
import ru.egor.model.PetAnimal;
import ru.egor.model.User;
import ru.egor.DAO.UserDao;
import ru.egor.model.UsersPet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AddServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();
    final AtomicInteger ids1 = new AtomicInteger();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }
}
