package testyfitnessfixture;
import fit.ColumnFixture;
import org.example.*;
public class TestWyszukaniaKierowcy extends ColumnFixture {
    public boolean wyszukajKierowce() {
        Kierowca kierowca = SetUp.aplikacja.wyszukajDostepnegoKierowce();
        return kierowca != null;
    }
}
