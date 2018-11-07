package ru.egor.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.egor.connection.SessionFactoryMyImpl;
import ru.egor.model.PetAnimal;
import ru.egor.model.User;
import org.hibernate.query.Query;
import ru.egor.model.UsersPet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserHibDAO implements DAO {

    private final SessionFactory sessionFactory = SessionFactoryMyImpl.getInstance();

    public UserHibDAO(){
    }

    @Override
    public void add(User user) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();

            System.out.println("add user");
            session.close();
        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }



    public void add(int id, PetAnimal petAnimal) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            //поиск юзера по id и добавление в него животных
            User user = session.get(User.class,id);
            Set<UsersPet> usersPets = user.getUsersPets();
            UsersPet up = new UsersPet();
            up.setUser(user);
            up.setPetAnimal(petAnimal);
            usersPets.add(up);
            user.setUsersPets(usersPets);
            session.update(user);

            transaction.commit();

            System.out.println("add user");
            session.close();
        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }



    @Override
    public List<?> list() {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            List<User> users = (List<User>) session.createQuery("from User").list();

            transaction.commit();

            System.out.println("get all users");
            session.close();
            return users;
        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }

    @Override
    public void update(User user) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            session.update(user);

            transaction.commit();

            System.out.println("update user for id");
            session.close();

        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }

    public void update( int user_id, int pet_id, PetAnimal petAnimal) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            //поиск юзера по id и update у него животного по pet_id

            User user = session.get(User.class,user_id);
            Set<UsersPet> usersPets = user.getUsersPets();

            Iterator<UsersPet> userIterator = usersPets.iterator();
            while(userIterator.hasNext()) {
                UsersPet nextUserPet = userIterator.next();
                if (nextUserPet.getPetAnimal().getPet_id()==pet_id) {
                    nextUserPet.getPetAnimal().setPetName(petAnimal.getPetName());
                    nextUserPet.getPetAnimal().setPetType(petAnimal.getPetType());
                }
            }

            user.setUsersPets(usersPets);
            session.update(user);

            transaction.commit();

            System.out.println("update pets");
            session.close();

        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class,id);
            session.delete(user);

            transaction.commit();

            System.out.println("delete user");
            session.close();
        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }

    public User getUserById(int id) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class,id);

            transaction.commit();

            System.out.println("get by id");
            session.close();
            return user;
        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }

    public User getUserMobilePhone(String m_phone) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query<User> query = session.createQuery("FROM User where m_phone = :paramName");
            query.setParameter("paramName",m_phone);
            User user = query.getSingleResult();

            transaction.commit();

            System.out.println("get by m_phone");
            session.close();
            return user;
        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }

    public List<User> searchByFirstName(String first_name){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query<User> query = session.createQuery("FROM User where f_name = :paramName");
            query.setParameter("paramName",first_name);
            List<User> users =query.list();

            for(User us : users) {
                System.out.println(us.toString());
            }

            transaction.commit();

            System.out.println("by first name");
            session.close();
            return users;
        }finally {
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }
}
