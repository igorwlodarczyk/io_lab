import org.junit.platform.suite.api.*;
import org.junit.platform.suite.api.ExcludeTags;

@Suite
@IncludeTags({"AplikacjaMeldujAwarie", "AplikacjaObslugaKursu", "AplikacjaObslugaAutobusow", "AplikacjaObslugaKierowcy"})
@SelectClasses({ApplicationTest.class, Test_punkt2.class, Test_punkt3.class, Test_punkt4.class})
public class Test_punkt5ApplicationSuite {
}


