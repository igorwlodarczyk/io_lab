import java.util.stream.IntStream;

public class TestDataGenerator {

    static IntStream provideIntegersInRange() {
        return IntStream.rangeClosed(3, 10);
    }
}