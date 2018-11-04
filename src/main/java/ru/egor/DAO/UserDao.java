package ru.egor.DAO;

import ru.egor.connection.ConnectionManager;
import ru.egor.connection.ConnectionManagerJDBCImpl;
import ru.egor.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DAO {

    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();


    @Override
    public void add(User user) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO users (f_name, l_name, address, home_phone, m_phone, profession) " +
                            "VALUES (?, ?, ?, ?, ?, ?)\n");
            statement.setString(1, user.getF_name());
            statement.setString(2, user.getL_name());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getHome_phone());
            statement.setString(5, user.getM_phone());
            statement.setString(6, user.getProfession());
            statement.execute();
            connection.close();
            System.out.println("add user to DB");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM users");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                User user = new User(Integer.parseInt(rs.getString("user_id")), rs.getString("f_name"),rs.getString("l_name"),
                        rs.getString("address"),rs.getString("home_phone"), rs.getString("m_phone"),
                        rs.getString("profession"));
                users.add(user);

            }
            return users;
        }catch (SQLException e){
            System.out.println("SQLException");
        }
        return null;
    }

    @Override
    public void update(User user) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "UPDATE users SET f_name=?, l_name=?, address=?, home_phone=?, m_phone=?, profession=? where user_id=?");
            System.out.println(user.getId());
            statement.setString(1, user.getF_name());
            statement.setString(2, user.getL_name());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getHome_phone());
            statement.setString(5, user.getM_phone());
            statement.setString(6, user.getProfession());
            statement.setInt(7,user.getId());
            statement.executeUpdate();
            connection.close();
            System.out.println("update user to DB");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "DELETE  FROM users WHERE user_id =?");
            statement.setInt(1, id);
            statement.execute();
            connection.close();
            System.out.println("deleted user from DB");

        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public User getUserById(int id) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE user_id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            User user = getUser(connection, set);
            if (user != null) return user;
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return null;
    }

    public User getUserMobilePhone(String m_phone) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE m_phone = ?");
            statement.setString(1, m_phone);
            ResultSet set = statement.executeQuery();
            User user = getUser(connection, set);
            if (user != null) return user;
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return null;
    }

    private User getUser(Connection connection, ResultSet set) throws SQLException {
        while (set.next()) {
            User user = new User(set.getInt("user_id"), set.getString("f_name"),
                    set.getString("l_name"),set.getString("address"),
                    set.getString("home_phone"), set.getString("m_phone"), set.getString("profession"));
            connection.close();
            return user;
        }
        return null;
    }

    public List<User> searchByFirstName(String first_name) {
        List<User> users1 = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE f_name = ?");
            statement.setString(1, first_name);
            ResultSet rs = statement.executeQuery();


            while (rs.next()) {

                User user = new User(Integer.parseInt(rs.getString("user_id")), rs.getString("f_name"),rs.getString("l_name"),
                        rs.getString("address"),rs.getString("home_phone"), rs.getString("m_phone"),
                        rs.getString("profession"));
                users1.add(user);

            }
            return users1;
        }catch (SQLException e){
            System.out.println("SQLException");
        }
        return null;
    }

}
