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
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;


@TestMethodOrder(OrderAnnotation.class)
public class Test_punkt3 implements TestExecutionExceptionHandler{
    
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


    @ExtendWith(Test_punkt3.class)
    @ParameterizedTest
    @MethodSource("TestDataGenerator#provideIntegersInRange")
    @Order(1)
    public void testKurs_1(int id){
        Kierowca kierowca = aplikacja.wyszukajDostepnegoKierowce();
        Linia linia = linie.get(0);
        Autobus autobus = aplikacja.wyszukajDostepnyAutobus();
        LocalTime time = LocalTime.now();
        Kurs kurs = new Kurs(id, kierowca, linia, autobus, time);

        Assertions.assertEquals(id, kurs.getNumerKursu());
    }

    @ExtendWith(Test_punkt3.class)
    @ParameterizedTest
    @MethodSource("TestDataGenerator#provideIntegersInRange")
    @Order(2)
    public void testKurs_2(int id){
        Kierowca kierowca = aplikacja.wyszukajDostepnegoKierowce();
        Linia linia = linie.get(0);
        Autobus autobus = aplikacja.wyszukajDostepnyAutobus();
        LocalTime time = LocalTime.now();
        Kurs kurs = new Kurs(id, kierowca, linia, autobus, time);

        Assertions.assertEquals(linia, kurs.getLinia());
    }

}
