package view;

import controller.ConnectionController;
import controller.UserController;
import model.User;

import java.util.Scanner;

public class UserOperation {
    private static UserController userController = UserController.getInstance();

    public UserOperation() {
    }

    public static void userview(){
        System.out.println("Please logIn");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        switch (line){
            case "signIn":
                String username = scanner.nextLine();
                String password = scanner.nextLine();
                User user = new User(username,password);
                userController.addUser(user);
                break;
            case "logIn":
                String username1 = scanner.nextLine();
                String password1 = scanner.nextLine();
                System.out.println(username1 + " " + password1);
                boolean verificare = userController.logIn(username1,password1);
                if(verificare==true){
                    ComenziOperation.comenziView();
                }else{
                    System.out.println("Username sau parola gresita!");
                }
                break;
        }
    }
}
