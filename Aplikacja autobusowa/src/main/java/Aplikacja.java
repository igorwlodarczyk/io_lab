import java.time.LocalTime;
import java.util.*;

public class Aplikacja {

    private ArrayList<Kierowca> kierowcy;
    private ArrayList<Kurs> kursy;
    private ArrayList<Autobus> autobusy;
    private ArrayList<Przystanek> przystanki;
    private ArrayList<Linia> linie;

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

    public List<Przystanek> getPrzystanki() {
        // TODO - implement Aplikacja.getPrzystanki
        throw new UnsupportedOperationException();
    }

    /**
     * @param przystanek: Przystanek autobusowy
     */
    public void setPrzystanek(Przystanek przystanek) {
        // TODO - implement Aplikacja.setPrzystanek
        throw new UnsupportedOperationException();
    }

    public List<Kierowca> getKierowcy() {
        // TODO - implement Aplikacja.getKierowcy
        throw new UnsupportedOperationException();
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

    public List<Kurs> getKursy() {
        // TODO - implement Aplikacja.getKursy
        throw new UnsupportedOperationException();
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
                break;
            }
        }
        return true;
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

    public static void main(String[] args){
	    // some code here in the main() method
        System.out.println("Hello, World!"); 
    }
}