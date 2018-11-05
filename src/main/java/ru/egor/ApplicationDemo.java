package ru.egor;

import ru.egor.DAO.UserHibDAO;
import ru.egor.model.PetAnimal;
import ru.egor.model.User;
import ru.egor.model.UsersPet;

import java.util.List;
import java.util.Set;

public class ApplicationDemo {
    public static void main(String[] args) {

        UserHibDAO userHibDAO = new UserHibDAO();
        //User user = new User();

        //add user
//        User user = new User();
//        user.setF_name("Pirogova");
//        user.setL_name("July");
//        user.setAddress("Tyumen Fabrichnaya 1/143");
//        user.setHome_phone("unknown");
//        user.setM_phone("+555555555");
//        user.setProfession("teacher");
//        userHibDAO.add(user);


        //get user by id
//        User user = userHibDAO.getUserById(8);
//        System.out.println(user.toString());
//        Set<UsersPet> usersPets =  user.getUsersPets();

        //get all users

        //List<User> users = (List<User>) userHibDAO.list();
//        for(User us : users){
//            System.out.println(us.toString());
//        }


        //update user
        /*
        User user = new User();
        user.setId(2);
        user.setF_name("Pirogov");
        user.setL_name("Egor");
        user.setAddress("Tyumen Fabrichaya 1/143");
        user.setHome_phone("unknown");
        user.setM_phone("+7999999999");
        user.setProfession("programmist");
        userHibDAO.update(user);
        */

        //delete user
        //userHibDAO.delete(7);

        //get list by name
//        List<User> users = userHibDAO.searchByFirstName("Ganzya");
//        for(User us : users){
//            System.out.println(us.toString());
//        }
    }
}
