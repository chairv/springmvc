package junit;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName("nested test for hashMap")
public class Junit5Test {
    Map<String, Object> map;
    private final String environment = "DEV";

    @BeforeEach
    public void create() {
        System.out.println("beforeEach");
        map = new HashMap();
    }

    @Test
    @DisplayName("is empty")
    public void isEmpty() {
        System.out.println("isEmpty");
        assertTrue(map.isEmpty());
    }

    @Test
    @DisplayName("test lambda")
    public void testlambda() {
        assertAll("Match", () -> assertEquals(2, 1 + 2), () -> assertTrue(1 > 0));
    }

    @Test
    @DisplayName("throws exception")
    public void exceptionTest() {
        assertThrows(ArithmeticException.class, () -> System.out.println(1 / 0));
    }


    @Test
    @DisplayName("assume then do")
    public void assumeThenDo() {
        assumingThat(Objects.equals(this.environment, "DEV"), () -> System.out.println("IN DEV"));
    }


    @Nested
    @DisplayName("内部嵌套测试")
    public class AfterAdd {
        String key = "key";
        Object value = "value";

        @BeforeEach
        public void add() {
            map.put(key, value);
        }

        @Test
        @DisplayName("is not empty")
        public void isNotEmpty() {
            assertFalse(map.isEmpty());
        }
    }


    @Test
    @DisplayName("test info")
    public void testInfo(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }


    @TestFactory
    public Stream<DynamicTest> simpleDynamicTest() {
        return null;
    }

}
