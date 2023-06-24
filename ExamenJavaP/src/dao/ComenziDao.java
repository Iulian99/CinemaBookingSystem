package dao;

import model.Comenzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ComenziDao {
    private Connection connection;
    private PreparedStatement adaugareRezervare;
    private PreparedStatement afisareRezervari;
    private PreparedStatement stergereRezervare;


    public ComenziDao(Connection connection) {
        this.connection = connection;
        try {
            adaugareRezervare = connection.prepareStatement("INSERT INTO rezervari VALUES(null,?,?,?)");
            afisareRezervari = connection.prepareStatement("SELECT * FROM rezervari");
            stergereRezervare = connection.prepareStatement("DELETE FROM rezervari WHERE id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adaugareRezervare(Comenzi comenzi) {
        try {
            adaugareRezervare.setString(1, comenzi.getNumeFilm());
            adaugareRezervare.setString(2, comenzi.getNumeUser());
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String date = comenzi.getLocalDate();
            LocalDate localDate1 = LocalDate.parse(date, formatter);
            if(localDate1.isAfter(localDate)){
                adaugareRezervare.setString(3,comenzi.getLocalDate());
                System.out.println("rezervarea a fost adaugata");
            }else{
                return false;
            }
            return  adaugareRezervare.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Comenzi> afisareRezervari() {
        List<Comenzi> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = afisareRezervari.executeQuery();
            while (rs.next()) {
                list.add(new Comenzi(rs.getInt("id"),
                        rs.getString("film"),
                        rs.getString("numePersoana"),
                        rs.getString("data")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean stergereRezervare(int id){
        try {
            stergereRezervare.setInt(1,id);
            return stergereRezervare.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
