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



public class Test_punkt2 implements TestExecutionExceptionHandler{
    
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


    @ExtendWith(Test_punkt2.class)
    @Tag("Aplikacja")
    @ParameterizedTest
    @MethodSource("TestDataGenerator#provideIntegersInRange")
    public void testUtworzKurs(int id){
        Kierowca kierowca = kierowcy.get(kierowcy.size() - 1);
        Linia linia = linie.get(0);
        Autobus autobus = autobusy.get(autobusy.size() - 1);
        LocalTime time = LocalTime.now();
        aplikacja.utworzKurs(id, kierowca, linia, autobus, time);
        Assertions.assertEquals(aplikacja.getKursy().size(), 2);
    }

    @Tag("Aplikacja")
    @Test
    public void testSzukajKursu(){
        Kurs func_return;
        func_return = aplikacja.szukajKursu(kurs);
        Assertions.assertNotNull(func_return);
        Assertions.assertInstanceOf(Kurs.class, func_return);

    }

    @Tag("Przystanek")
    @ParameterizedTest
    @CsvSource({"Komandorska,0.21,15.3", "Przystankowa,2,-3", "Pasaz Grunwaldzki,0,0"})
    public void testPrzystanek(String nazwa, double x, double y) {
        Przystanek przystanek = new Przystanek(nazwa, x, y);
        Assertions.assertInstanceOf(Przystanek.class, przystanek);
        Assertions.assertEquals(przystanek.getNazwa(), nazwa);
        Assertions.assertEquals(przystanek.getWspolrzedneX(), x);
        Assertions.assertEquals(przystanek.getWspolrzedneY(), y);
    }

}
