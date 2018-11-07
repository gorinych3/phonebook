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

public class UpdatePetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/updatePet.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        int pet_id = Integer.parseInt(req.getParameter("pet_id"));
        String petType = req.getParameter("petType");
        String petName = req.getParameter("petName");


//**********************************************
        //инициализация питомцаList<PetAnimal> petAnimals = new ArrayList<>();
        PetAnimal petAnimal = new PetAnimal();
        petAnimal.setPetType(petType);
        petAnimal.setPetName(petName);

        //List
//        UserImplDao DAO = UserImplDao.getINSTANCE();
//        DAO.update(user);

        //JDBC
//        UserDao userDao = new UserDao();
//        userDao.update(user);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        userHibDAO.update(id, pet_id, petAnimal);

        req.setAttribute("userName", req.getParameter("petName"));
        doGet(req, resp);
    }
}
