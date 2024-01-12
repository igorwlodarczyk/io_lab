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
    
    private Collection<Kierowca> kierowcy = new ArrayList<>();
    private Collection<Kurs> kursy = new ArrayList<>();
    private Collection<Autobus> autobusy = new ArrayList<>();
    private Collection<Przystanek> przystanki = new ArrayList<>();
    private Collection<Linia> linie = new ArrayList<>();
    


    @Tag("Przystanek")
    @ParameterizedTest
    @CsvSource({"Komandorska,0.21,15.3", "Przystankowa,2,-3", "Pasaz Grunwaldzki,0,0"})
    public void testPrzystanek(String nazwa, double x, double y) {
        Przystanek przystanek = new Przystanek(nazwa, x, y);
    }




}
