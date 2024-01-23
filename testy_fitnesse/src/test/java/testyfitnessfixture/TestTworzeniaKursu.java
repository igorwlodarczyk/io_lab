package testyfitnessfixture;

import fit.ColumnFixture;
import org.example.*;
import java.time.LocalTime;
import java.util.ArrayList;
public class TestTworzeniaKursu extends ColumnFixture {
    String dane;
    public boolean utworzKurs() {
        String[] daneArray = dane.split(",");
        int id = Integer.parseInt(daneArray[0]);
        String imie_kierowcy = daneArray[1];
        String nazwisko_kierowcy = daneArray[2];
        String nazwa_przystanku = daneArray[3];
        String model_autobusu = daneArray[4];
        Kierowca kierowca = new Kierowca(1, imie_kierowcy, nazwisko_kierowcy, true);
        ArrayList<Przystanek> przystanki = new ArrayList<>();
        przystanki.add(new Przystanek(nazwa_przystanku, 1, 2));
        Autobus autobus = new Autobus(1, model_autobusu, true);
        Linia linia = new Linia(1, przystanki, przystanki.get(przystanki.size() - 1));
        SetUp.aplikacja.utworzKurs(id, kierowca, linia, autobus, LocalTime.now());
        return true;
    }
}
