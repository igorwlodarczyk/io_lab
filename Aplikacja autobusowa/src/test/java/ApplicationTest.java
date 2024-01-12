import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalTime;
import java.util.*;


public class ApplicationTest {
    
    private ArrayList<Kierowca> kierowcy = new ArrayList<>();
    private ArrayList<Kurs> kursy = new ArrayList<>();
    private ArrayList<Autobus> autobusy = new ArrayList<>();
    private ArrayList<Przystanek> przystanki = new ArrayList<>();
    private ArrayList<Linia> linie = new ArrayList<>();
    Kurs kurs;
    Aplikacja aplikacja;
    
    @BeforeEach
    public void setUpApp(){
        kierowcy.add(new Kierowca(1, "Igor", "Wlodarczyk", true));
        przystanki.add(new Przystanek("Komandorska", 1, 2));
        przystanki.add(new Przystanek("Przystankowa", 2, 3));
        przystanki.add(new Przystanek("Pasaz Grunwaldzki", 3, 3));
        autobusy.add(new Autobus(1, "Rietze 70231", true));
        linie.add(new Linia(1, przystanki, przystanki.get(przystanki.size() - 1)));

        kurs = new Kurs(1, kierowcy.get(0), linie.get(0), autobusy.get(0), LocalTime.now());
        kursy.add(kurs);

        aplikacja = new Aplikacja(kierowcy, kursy, autobusy, przystanki, linie);
    }

    @Tag("Setup")
    @Test
    public void testSetUpApp(){
        Assertions.assertEquals(1, kierowcy.size());
        Assertions.assertEquals(3, przystanki.size());
        Assertions.assertEquals(1, autobusy.size());
        Assertions.assertEquals(1, linie.size());
        Assertions.assertEquals(1, kursy.size());
    }

    @Tag("Przystanek")
    @ParameterizedTest
    @CsvSource({"Komandorska,0.21,15.3", "Przystankowa,2,-3", "Pasaz Grunwaldzki,0,0"})
    public void testPrzystanek(String nazwa, double x, double y) {
        Przystanek przystanek = new Przystanek(nazwa, x, y);
    }

    @Tag("Aplikacja")
    @Test
    public void testWyszukajDostepnegoKierowce(){
        Kierowca kierowca = aplikacja.wyszukajDostepnegoKierowce();
        Assertions.assertTrue(kierowca == null);
    }

    @Tag("Aplikacja")
    @Test
    public void testSzukajKursu(){
        Kurs func_return;
        func_return = aplikacja.szukajKursu(kurs);
        Assertions.assertTrue(func_return != null);
    }

    @Tag("Aplikacja")
    @Test
    public void testWyszukajDostepnyAutobus(){
        Autobus autobus = aplikacja.wyszukajDostepnyAutobus();
        Assertions.assertTrue(autobus == null);
    }




}
