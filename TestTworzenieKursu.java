import fit.ColumnFixture;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class TestTworzenieKursu extends ColumnFixture{
    private ArrayList<Kierowca> kierowcy = new ArrayList<>();
    private ArrayList<Kurs> kursy = new ArrayList<>();
    private ArrayList<Autobus> autobusy = new ArrayList<>();
    private ArrayList<Przystanek> przystanki = new ArrayList<>();
    private ArrayList<Linia> linie = new ArrayList<>();


    public boolean dodajProdukt() throws IllegalFormatCodePointException {
        kierowcy.add(new Kierowca(1, "Igor", "Wlodarczyk", true));
        kierowcy.add(new Kierowca(2, "Maciej", "Wojtkowiak", true));
        przystanki.add(new Przystanek("Komandorska", 1, 2));
        przystanki.add(new Przystanek("Przystankowa", 2, 3));
        przystanki.add(new Przystanek("Pasaz Grunwaldzki", 3, 3));
        autobusy.add(new Autobus(1, "Rietze 70231", true));
        autobusy.add(new Autobus(2, "Rietze 70231", true));
        linie.add(new Linia(1, przystanki, przystanki.get(przystanki.size() - 1)));

        int s1=liczbaKursow();
        try{
            Kierowca kierowca = kierowcy.get(kierowcy.size() - 1);
            Linia linia = linie.get(0);
            Autobus autobus = autobusy.get(autobusy.size() - 1);
            LocalTime time = LocalTime.now();

            SetUp.aplikacja.utworzKurs(0, kierowca, linia, autobus, time);
            int s2=liczbaKursow();
            return s1!=s2;
        } catch(IllegalFormatCodePointException e) {
        }
        return false;
    }

    public int liczbaKursow() {
        return SetUp.aplikacja.getKursy().size();
    }
}