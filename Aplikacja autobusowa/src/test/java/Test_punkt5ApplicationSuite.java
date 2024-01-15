import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;


@Suite
@IncludeTags({"AplikacjaMeldujAwarie", "AplikacjaObslugaKursu", "AplikacjaObslugaAutobusow", "AplikacjaObslugaKierowcy"})
@SelectClasses({ApplicationTest.class, Test_punkt2.class, Test_punkt3.class, Test_punkt4.class})
public class Test_punkt5ApplicationSuite {
}


