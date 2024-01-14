import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.*;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(ApplicationTest.class)
public class Test_punkt4 implements TestExecutionExceptionHandler{

    private ArrayList<Kierowca> kierowcy = new ArrayList<>();
    private ArrayList<Kurs> kursy = new ArrayList<>();
    private ArrayList<Autobus> autobusy = new ArrayList<>();
    private ArrayList<Przystanek> przystanki = new ArrayList<>();
    private ArrayList<Linia> linie = new ArrayList<>();
    Kurs kurs;
    Aplikacja aplikacja;

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (!(throwable instanceof UnsupportedOperationException)) {
            throw throwable;
        }
    }

    @BeforeEach
    public void setUpApp(){
        kierowcy.add(new Kierowca(1, "Igor", "Wlodarczyk", true));
        kierowcy.add(new Kierowca(2, "Maciej", "Wojtkowiak", true));
        przystanki.add(new Przystanek("Komandorska", 1, 2));
        przystanki.add(new Przystanek("Przystankowa", 2, 3));
        przystanki.add(new Przystanek("Pasaz Grunwaldzki", 3, 3));
        autobusy.add(new Autobus(1, "Rietze 70231", true));
        autobusy.add(new Autobus(2, "Rietze 70231", true));
        linie.add(new Linia(1, przystanki, przystanki.get(przystanki.size() - 1)));

        kurs = new Kurs(1, kierowcy.get(0), linie.get(0), autobusy.get(0), LocalTime.now());
        kursy.add(kurs);

        aplikacja = new Aplikacja(kierowcy, kursy, autobusy, przystanki, linie);
    }

    @Tag("Setup")
    @Test
    public void testSetUpApp(){
        Assertions.assertEquals(2, kierowcy.size());
        Assertions.assertEquals(3, przystanki.size());
        Assertions.assertEquals(2, autobusy.size());
        Assertions.assertEquals(1, linie.size());
        Assertions.assertEquals(1, kursy.size());
    }

    @Tag("Aplikacja")
    @Test
    public void testMeldujAwarie(){
        int iloscKursow  = aplikacja.getKursy().size();
        aplikacja.meldujAwarie(1);
        Assertions.assertEquals(iloscKursow, aplikacja.getKursy().size());
        Assertions.assertTrue(aplikacja.meldujAwarie(2));
        Assertions.assertFalse(kierowcy.get(0).getDostepny());
    }

    @Tag("Aplikacja")
    @Test
    public void testMeldujAwarieNieistniajecegoNumeru() {
        Assertions.assertFalse(aplikacja.meldujAwarie(999));
        Assertions.assertEquals(1, aplikacja.getKursy().size());
    }

    @Tag("Aplikacja")
    @ParameterizedTest
    @MethodSource("TestDataGenerator#provideIntegersInRange")
    public void testUtworzKurs(int id){
        Kierowca kierowca = kierowcy.get(kierowcy.size() - 1);
        Linia linia = linie.get(0);
        Autobus autobus = autobusy.get(autobusy.size() - 1);
        LocalTime time = LocalTime.now();

        int ilosc_kursow = aplikacja.getKursy().size();
        aplikacja.utworzKurs(id, kierowca, linia, autobus, time);
        Assertions.assertEquals(ilosc_kursow+1,aplikacja.getKursy().size() );
    }

    @Tag("Aplikacja")
    @Test
    public void testWyszukajDostepnyAutobus(){
        Autobus autobus = aplikacja.wyszukajDostepnyAutobus();
        Assertions.assertNotNull(autobus);
        Assertions.assertInstanceOf(Autobus.class, autobus);
        Assertions.assertTrue(autobus.getDostepny());
        Assertions.assertEquals(autobus.getModel(), "Rietze 70231");
    }

    @Tag("Aplikacja")
    @ParameterizedTest
    @MethodSource("TestDataGenerator#provideIntegersInRange")
    void testWyszukajDostepnyAutobusBezDostepnego() {
        autobusy.get(0).setDostepny(false);
        autobusy.get(1).setDostepny(false);
        Autobus dostepnyAutobus = aplikacja.wyszukajDostepnyAutobus();
        Assertions.assertNull(dostepnyAutobus);
    }

    @Tag("Aplikacja")
    @Test
    public void testWyszukajDostepnegoKierowce(){
        Kierowca kierowca = aplikacja.wyszukajDostepnegoKierowce();
        Assertions.assertNotNull(kierowca);
        Assertions.assertTrue(kierowca.getDostepny());
    }

    @Tag("Aplikacja")
    @Test
    public void testSzukajKursu(){
        Kurs func_return;
        func_return = aplikacja.szukajKursu(kurs);
        Assertions.assertNotNull(func_return);
    }

}
