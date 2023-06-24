package view;

import controller.ComenziController;
import model.Comenzi;
import model.User;

import java.util.List;
import java.util.Scanner;

public class ComenziOperation {
    private static ComenziController comenziController= ComenziController.getInstance();

    public ComenziOperation() {
    }

    public static void comenziView(){
        System.out.println("You can chose:");
        System.out.println("rezervare - add a reservation");
        System.out.println("afisareRezervari - show all reservations");
        System.out.println("stergeRezervare - delete a reservation");
        Scanner scanner = new Scanner(System.in);
        OUT: while (true) {
            String line = scanner.nextLine();
            switch (line) {
                case "rezervare":
                    String film = scanner.nextLine();
                    String numePersoana = scanner.nextLine();
                    String localDate = scanner.nextLine();
                    Comenzi comenzi = new Comenzi(film, numePersoana, localDate);
                    comenziController.addRezervare(comenzi);
                    break;
                case "afisareRezervari":
                    List<Comenzi> list = comenziController.getAllRezervari();
                    list.forEach(System.out::println);
                    break;
                case "stergeRezervare":
                    String id = scanner.nextLine();
                    if(comenziController.deleteRezervare(Integer.valueOf(id))==true){
                        System.out.println("Rezervarea a fost stearsa!");
                    }else{
                        System.out.println("Rezervarea nu a fost stearsa");
                    }

                    break;
                case "LogOut":
                    UserOperation.userview();
                    break OUT;
            }
        }
    }
}
