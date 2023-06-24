package controller;

import dao.UserDao;
import model.User;

import java.util.List;
import java.util.Optional;

public class UserController {
    private UserDao userDao= new UserDao(ConnectionController.getInstance().getConnection());

    private UserController() {
    }

    private static final class SingletonHolder{
        private static final UserController instance  = new UserController();
    }

    public static UserController getInstance(){
        return SingletonHolder.instance;
    }

    public boolean addUser(User user){
        return userDao.addUser(user);
    }

    public Optional<User> getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }

    public boolean logIn(String userName, String password){
        Optional<User> op = getUserByUsername(userName);
        boolean res = false;
        if(op.isPresent()){
            User user = op.get();
            res = user.getPassword().equals(password);
        }
        return res;
    }


}
