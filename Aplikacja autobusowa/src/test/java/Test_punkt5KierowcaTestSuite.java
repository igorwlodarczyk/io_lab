import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ApplicationTest.class, Test_punkt2.class, Test_punkt3.class, Test_punkt4.class})
@ExcludeTags({"AplikacjaMeldujAwarie", "AplikacjaObslugaKursu", "AplikacjaObslugaAutobusow", "AplikacjaObslugaKierowcy", "Aplikacja"})
public class Test_punkt5KierowcaTestSuite {
}


