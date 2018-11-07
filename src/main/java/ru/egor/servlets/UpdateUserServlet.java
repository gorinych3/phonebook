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

public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/updateUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String f_name = req.getParameter("f_name");
        String l_name = req.getParameter("l_name");
        String address = req.getParameter("address");
        String home_phone = req.getParameter("home_phone");
        String m_phone = req.getParameter("m_phone");
        String profession = req.getParameter("profession");
        String moderCar = req.getParameter("moderCar");
        String typeCar = req.getParameter("typeCar");
        String colorCar = req.getParameter("colorCar");
        String petType = req.getParameter("petType");
        String petName = req.getParameter("petName");

        User user = new User();
        user.setId(id);
        user.setF_name(f_name);
        user.setL_name(l_name);
        user.setAddress(address);
        user.setHome_phone(home_phone);
        user.setM_phone(m_phone);
        user.setProfession(profession);
        Car car = new Car();
        car.setModerCar(moderCar);
        car.setTypeCar(typeCar);
        car.setColorCar(colorCar);
        user.setCar(car);
//**********************************************
//        //инициализация питомца
//        List<PetAnimal> petAnimals = new ArrayList<>();
//        PetAnimal petAnimal = new PetAnimal();
//        petAnimal.setPetType(petType);
//        petAnimal.setPetName(petName);
//        petAnimals.add(petAnimal);
////***********************************************
//        Set<UsersPet> usersPets = new HashSet<>();
//        UsersPet usersPet = new UsersPet();
//        usersPet.setUp_id(id);
//        usersPet.setPetAnimal(petAnimal);
//        usersPet.setUser(user);
//
////************************************************
//        user.setUsersPets(usersPets);

        //List
//        UserImplDao DAO = UserImplDao.getINSTANCE();
//        DAO.update(user);

        //JDBC
//        UserDao userDao = new UserDao();
//        userDao.update(user);

        //hibernate
        UserHibDAO userHibDAO = new UserHibDAO();
        userHibDAO.update(user);

        req.setAttribute("userName", req.getParameter("f_name"));
        doGet(req, resp);
    }
}
