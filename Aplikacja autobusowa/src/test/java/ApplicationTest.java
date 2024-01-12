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
    
    @BeforeEach
    public void setUpApp(){
        kierowcy.add(new Kierowca(1, "Igor", "Wlodarczyk", true));
        przystanki.add(new Przystanek("Komandorska", 1, 2));
        przystanki.add(new Przystanek("Przystankowa", 2, 3));
        przystanki.add(new Przystanek("Pasaz Grunwaldzki", 3, 3));
        autobusy.add(new Autobus(1, "Rietze 70231", true));
        linie.add(new Linia(1, przystanki, przystanki.get(przystanki.size() - 1)));
        kursy.add(new Kurs(1, kierowcy.get(0), linie.get(0), autobusy.get(0), LocalTime.now()));
    }


    @Tag("Przystanek")
    @ParameterizedTest
    @CsvSource({"Komandorska,0.21,15.3", "Przystankowa,2,-3", "Pasaz Grunwaldzki,0,0"})
    public void testPrzystanek(String nazwa, double x, double y) {
        Przystanek przystanek = new Przystanek(nazwa, x, y);
    }




}
