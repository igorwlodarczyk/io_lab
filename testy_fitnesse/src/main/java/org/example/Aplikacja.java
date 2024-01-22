package org.example;

import java.time.LocalTime;
import java.util.*;

public class Aplikacja {

    private ArrayList<Kierowca> kierowcy;
    private ArrayList<Kurs> kursy;
    private ArrayList<Autobus> autobusy;
    private ArrayList<Przystanek> przystanki;
    private ArrayList<Linia> linie;

    public Aplikacja() {

    }

    public void utworzKurs(int id, Kierowca kierowca,
                           Linia linia, Autobus autobus, LocalTime czasStartowy) {
        Kurs kurs = new Kurs(id, kierowca, linia, autobus, czasStartowy);
        if (szukajKursu(kurs) == null) {
            kursy.add(kurs);
        }
    }

    public Aplikacja(ArrayList<Kierowca> kierowcy, ArrayList<Kurs> kursy,
                     ArrayList<Autobus> autobusy, ArrayList<Przystanek> przystanki,
                     ArrayList<Linia> linie) {
        this.kierowcy = kierowcy;
        this.kursy = kursy;
        this.autobusy = autobusy;
        this.przystanki = przystanki;
        this.linie = linie;
    }

    /**
     * @param przystanek: Przystanek autobusowy
     */
    public List<Kurs> pobierzNajblizszeAutobusy(Przystanek przystanek) {
        // TODO - implement Aplikacja.pobierzNajblizszeAutobusy
        throw new UnsupportedOperationException();
    }

    public ArrayList<Przystanek> getPrzystanki() {
        return przystanki;
    }

    /**
     * @param przystanek: Przystanek autobusowy
     */
    public void setPrzystanek(Przystanek przystanek) {
        // TODO - implement Aplikacja.setPrzystanek
        throw new UnsupportedOperationException();
    }

    public ArrayList<Kierowca> getKierowcy() {
        return kierowcy;
    }

    /**
     * @param kierowca: Kierowca autobusu
     */
    public void setKierowca(Kierowca kierowca) {
        // TODO - implement Aplikacja.setKierowca
        throw new UnsupportedOperationException();
    }

    public List<Linia> getLinie() {
        // TODO - implement Aplikacja.getLinie
        throw new UnsupportedOperationException();
    }

    /**
     * @param linia: Linia autobusowa
     */
    public void setLinia(Linia linia) {
        // TODO - implement Aplikacja.setLinia
        throw new UnsupportedOperationException();
    }

    public List<Autobus> getAutobusy() {
        // TODO - implement Aplikacja.getAutobusy
        throw new UnsupportedOperationException();
    }

    /**
     * @param autobus: Autobus
     */
    public void setAutobus(Autobus autobus) {
        // TODO - implement Aplikacja.setAutobus
        throw new UnsupportedOperationException();
    }

    public ArrayList<Kurs> getKursy() {
        return kursy;
    }

    /**
     * @param kurs: Kurs autobusowy
     */
    public void setKurs(Kurs kurs) {
        // TODO - implement Aplikacja.setKurs
        throw new UnsupportedOperationException();
    }

    /**
     * @param przystanek: przystanek autobusowy
     */
    public List<Map<Linia, LocalTime>> wygenerujRozklad(Przystanek przystanek) {
        // TODO - implement Aplikacja.wygenerujRozklad
        throw new UnsupportedOperationException();
    }

    /**
     * @param numer: numer
     */
    public LocalTime wyznaczCzasWzgledemRozkladu(int numer) {
        // TODO - implement Aplikacja.wyznaczCzasWzgledemRozkladu
        throw new UnsupportedOperationException();
    }

    /**
     * @param numer: numer
     */
    public boolean meldujPrzyjazd(int numer) {
        // TODO - implement Aplikacja.meldujPrzyjazd
        throw new UnsupportedOperationException();
    }

    /**
     * @param numer: numer
     */
    public boolean meldujAwarie(int numer) {
        int id;
        Kierowca kierowca;
        Linia linia = null;
        Autobus autobus;
        LocalTime czasStartowy;
        for (Kurs kurs : kursy) {
            int numerKursu = kurs.getNumerKursu();
            if (numer == numerKursu) {
                linia = kurs.getLinia();
                kursy.remove(kurs);
                kierowca = wyszukajDostepnegoKierowce();
                autobus = wyszukajDostepnyAutobus();
                utworzKurs(autobusy.size() + 1, kierowca, linia, autobus, LocalTime.now());
                return true;
            }
        }
        return false;
    }

    public Kierowca wyszukajDostepnegoKierowce() {
        for (Kierowca kierowca : kierowcy) {
            if (kierowca.getDostepny()) {
                return kierowca;
            }
        }
        return null;
    }

    public Autobus wyszukajDostepnyAutobus() {
        for (Autobus autobus : autobusy) {
            if (autobus.getDostepny()) {
                return autobus;
            }
        }
        return null;
    }

    public boolean anulujKurs() {
        // TODO - implement Aplikacja.anulujKurs
        throw new UnsupportedOperationException();
    }

    public Kurs szukajKursu(Kurs kurs) {
        if (kursy.contains(kurs)) {
            return kurs;
        } else return null;
    }

    public void main(String[] args) {
        ArrayList<Przystanek> przystanki = new ArrayList<>();
        przystanki.add(new Przystanek("Komandorska", 1, 2));
        przystanki.add(new Przystanek("Przystankowa", 2, 3));
        przystanki.add(new Przystanek("Pasaz Grunwaldzki", 3, 3));
        Kierowca kierowca = new Kierowca(1, "Igor", "Wlodarczyk", true);
        Autobus autobus = new Autobus(1, "Rietze 70231", true);
        Linia linia = new Linia(1, przystanki, przystanki.get(przystanki.size() - 1));

	    utworzKurs(1, kierowca, linia, autobus, LocalTime.now());

        meldujAwarie(1);
    }
}