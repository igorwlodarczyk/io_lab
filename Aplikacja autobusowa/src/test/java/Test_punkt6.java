import mockit.Expectations;
import mockit.Mocked;
import mockit.VerificationsInOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Test_punkt6 {

    @Mocked
    private Kierowca kierowca1;
    @Mocked
    private Kierowca kierowca2;
    @Mocked
    private Autobus autobus1;
    @Mocked
    private Autobus autobus2;
    @Mocked
    private Linia linia1;
    @Mocked
    private Linia linia2;
    @Mocked
    private Przystanek przystanek1;
    @Mocked
    private Przystanek przystanek2;
    @Mocked
    private Kurs kurs1;
    @Mocked
    private Kurs kurs2;

    private Aplikacja aplikacja;

    @BeforeEach
    public void setUpApp(){
        ArrayList<Kierowca> kierowcy = new ArrayList<>(Arrays.asList(kierowca1, kierowca2));
        ArrayList<Kurs> kursy = new ArrayList<>(Arrays.asList(kurs1, kurs2));
        ArrayList<Autobus> autobusy = new ArrayList<>(Arrays.asList(autobus1, autobus2));
        ArrayList<Linia> linie = new ArrayList<>(Arrays.asList(linia1, linia2));
        ArrayList<Przystanek> przystanki = new ArrayList<>(Arrays.asList(przystanek1, przystanek2));

        aplikacja = new Aplikacja(kierowcy, kursy, autobusy, przystanki, linie);
    }

    @Test
    public void testWyszukajDostepnegoKierowce() {
        new Expectations() {{
            kierowca1.getDostepny(); result = false;
            kierowca2.getDostepny(); result = true;
        }};
        Kierowca wynik = aplikacja.wyszukajDostepnegoKierowce();
        assertSame(kierowca2, wynik);
    }

    @Test
    public void testWyszukajDostepnegoKierowceBrak() {
        new Expectations() {{
            kierowca1.getDostepny(); result = false;
            kierowca2.getDostepny(); result = false;
        }};
        Kierowca wynik = aplikacja.wyszukajDostepnegoKierowce();
        assertSame(null, wynik);
    }

    @Test
    public void testWyszukajDostepnyAutobus() {
        new Expectations() {{
            autobus1.getDostepny(); result = false;
            autobus2.getDostepny(); result = true;
        }};
        Autobus wynik = aplikacja.wyszukajDostepnyAutobus();
        assertSame(autobus2, wynik);
    }

    @Test
    public void testWyszukajDostepnyAutobusBrak() {
        new Expectations() {{
            autobus1.getDostepny(); result = false;
            autobus2.getDostepny(); result = false;
        }};
        Autobus wynik = aplikacja.wyszukajDostepnyAutobus();
        assertSame(null, wynik);
    }

    @Test
    public void testMeldujAwarie() {
        new Expectations() {{
            kurs1.getNumerKursu(); result = 1;
            kierowca1.getDostepny(); result = true;
            autobus1.getDostepny(); result = true;
        }};

        boolean wynik = aplikacja.meldujAwarie(1);
        assertTrue(wynik);
    }

    @Test
    public void testMeldujAwarieBledna() {
        new Expectations() {{
            kurs1.getNumerKursu(); result = 999;
        }};

        boolean wynik = aplikacja.meldujAwarie(1);
        assertFalse(wynik);
    }

    @Test
    public void testMeldujAwarieOrder() {

        new Expectations() {{
            kurs1.getNumerKursu(); result = 1;
            kierowca1.getDostepny(); result = true;
            autobus1.getDostepny(); result = true;
        }};

        boolean wynik = aplikacja.meldujAwarie(1);
        assertTrue(wynik);

        new VerificationsInOrder() {{
            kurs1.getNumerKursu(); times = 1;
            kierowca1.getDostepny(); times = 1;
            autobus1.getDostepny(); times = 1;
        }};
    }

}


