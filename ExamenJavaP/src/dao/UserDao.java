package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {
    private Connection connection;
    private PreparedStatement addUser;
    private PreparedStatement getUserByUsername;


    public UserDao(Connection connection) {
        this.connection = connection;
        try {
            addUser = connection.prepareStatement("INSERT INTO user VALUES(null,?,?)");
            getUserByUsername = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addUser(User user){
        try {
            addUser.setString(1,user.getUsername());
            addUser.setString(2,user.getPassword());
            return addUser.executeUpdate()!=0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<User> getUserByUsername(String username){
        try {
            getUserByUsername.setString(1,username);
            ResultSet resultSet = getUserByUsername.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id,name,password);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
