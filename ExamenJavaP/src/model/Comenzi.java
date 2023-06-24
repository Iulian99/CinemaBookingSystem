package model;

import java.time.LocalDate;

public class Comenzi {
    private int id;
    private String numeFilm;
    private String numeUser;
    private String localDate;

    public Comenzi(int id, String numeFilm, String numeUser, String localDate) {
        this.id = id;
        this.numeFilm = numeFilm;
        this.numeUser = numeUser;
        this.localDate = localDate;
    }

    public Comenzi(String numeFilm, String numeUser, String localDate) {
        this.numeFilm = numeFilm;
        this.numeUser = numeUser;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeFilm() {
        return numeFilm;
    }

    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }

    public String getNumeUser() {
        return numeUser;
    }

    public void setNumeUser(String numeUser) {
        this.numeUser = numeUser;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Comenzi{" +
                "id=" + id +
                ", numeFilm='" + numeFilm + '\'' +
                ", numeUser='" + numeUser + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
