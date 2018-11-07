package ru.egor.servlets;

import ru.egor.DAO.UserHibDAO;
import ru.egor.model.Car;
import ru.egor.model.PetAnimal;
import ru.egor.model.User;
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

public class AddPetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/addPet.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id_user = Integer.parseInt(req.getParameter("id"));
        String petType = req.getParameter("petType");
        String petName = req.getParameter("petName");

//*******************************************

        //инициализация питомца
        List<PetAnimal> petAnimals = new ArrayList<>();
        PetAnimal petAnimal = new PetAnimal();
        petAnimal.setPetType(petType);
        petAnimal.setPetName(petName);
        petAnimals.add(petAnimal);
//***********************************************
//        Set<UsersPet> usersPets = new HashSet<>();
//        UsersPet usersPet = new UsersPet();
//        usersPet.setUp_id(id);
//        usersPet.setPetAnimal(petAnimal);
//        usersPet.setUser(user);

//************************************************
        //user.setUsersPets(usersPets);

        //List
//        UserImplDao DAO = UserImplDao.getINSTANCE();
//        DAO.add(user);

        //JDBC
//        UserDao userDao = new UserDao();
//        userDao.add(user);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        userHibDAO.add(id_user, petAnimal);

        req.setAttribute("userName", req.getParameter("petName"));
        doGet(req, resp);
    }
}
