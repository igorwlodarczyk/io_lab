package org.example;

import java.time.LocalTime;

public class Kurs {

    private int id;
    private LocalTime czasStartowy;
    private Kierowca kierowca;
    private Przystanek ostatnioOdwiedzonyPrzystanek;
    private Linia linia;
    private Autobus autobus;

    /**
     * @param id
     * @param kierowca
     * @param linia
     * @param autobus
     * @param czasStartowy
     */

    public Kurs(int id, Kierowca kierowca, Linia linia, Autobus autobus, LocalTime czasStartowy) {
        this.id = id;
        this.kierowca = kierowca;
        this.linia = linia;
        this.autobus = autobus;
        this.czasStartowy = czasStartowy;
        this.kierowca.setDostepny(false);
        this.autobus.setDostepny(false);

    }

    public Przystanek meldujPrzyjazd() {
        // TODO - implement Kurs.meldujPrzyjazd
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement Kurs.toString
        throw new UnsupportedOperationException();
    }

    public int getNumerKursu() {
        return id;
    }

    public Linia getLinia() {
        return linia;
    }

}