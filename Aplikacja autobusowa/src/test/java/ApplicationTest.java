import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalTime;
import java.util.*;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;



@ExtendWith(ApplicationTest.class)
public class ApplicationTest implements TestExecutionExceptionHandler{
    
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

    @Tag("Przystanek")
    @ParameterizedTest
    @CsvSource({"Komandorska,0.21,15.3", "Przystankowa,2,-3", "Pasaz Grunwaldzki,0,0"})
    public void testPrzystanek(String nazwa, double x, double y) {
        Przystanek przystanek = new Przystanek(nazwa, x, y);
        Assertions.assertInstanceOf(Przystanek.class, przystanek);
        Assertions.assertEquals(przystanek.getWspolrzedneX(), x);
        Assertions.assertEquals(przystanek.getWspolrzedneY(), y);
        Assertions.assertEquals(przystanek.getNazwa(), nazwa);
    }

    @Tag("Aplikacja")
    @Test
    public void testWyszukajDostepnegoKierowce(){
        Kierowca kierowca = aplikacja.wyszukajDostepnegoKierowce();
        Assertions.assertNotNull(kierowca);
    }

    @Tag("Aplikacja")
    @Test
    public void testSzukajKursu(){
        Kurs func_return;
        func_return = aplikacja.szukajKursu(kurs);
        Assertions.assertNotNull(func_return);
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

    @Tag("Kierowca")
    @Test
    public void testKierowcaToString(){
        Kierowca kierowca = kierowcy.get(0);
        String string_kierowca = kierowca.toString();
        Assertions.assertEquals("Igor",string_kierowca);
    }

    @Tag("Aplikacja")
    @ParameterizedTest
    @MethodSource("TestDataGenerator#provideIntegersInRange")
    public void testUtworzKurs(int id){
        Kierowca kierowca = kierowcy.get(kierowcy.size() - 1);
        Linia linia = linie.get(0);
        Autobus autobus = autobusy.get(autobusy.size() - 1);
        LocalTime time = LocalTime.now();

        aplikacja.utworzKurs(id, kierowca, linia, autobus, time);
    }






}
