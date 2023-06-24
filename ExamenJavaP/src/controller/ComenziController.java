package controller;

import dao.ComenziDao;
import model.Comenzi;

import java.util.List;

public class ComenziController {
    private ComenziDao comenziDao = new ComenziDao(ConnectionController.getInstance().getConnection());

    public ComenziController() {
    }

    private static final class SingletonHolder {
        private static final ComenziController instance = new ComenziController();
    }

    public static ComenziController getInstance() {
        return SingletonHolder.instance;
    }

    public boolean addRezervare(Comenzi comenzi) {
        return comenziDao.adaugareRezervare(comenzi);
    }

    public List<Comenzi> getAllRezervari() {
        return comenziDao.afisareRezervari();
    }

    public boolean deleteRezervare(int id) {
        return comenziDao.stergereRezervare(id);
    }
}
