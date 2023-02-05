import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyKeyTest {

    @Test
    void setValue() {
        MyKey<Double, Integer> key = new MyKey<>(60, 0);
        key.setValue(1);
        MyKey<Double, Integer> test = new MyKey<>(60, 1);

        assertEquals(test.toString(), key.toString());
    }
}
