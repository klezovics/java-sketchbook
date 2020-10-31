package com.klezovich.demo.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("JUnit5 sketchbook")
class JUnit5Test {

    @Test
    @DisplayName("Easy test for JUnit5")
    public void easyTest() {
        assertTrue(true);
    }

    @Test
    @DisplayName("A test for group assertions")
    public void testGroupAssertions() {
        var user = new User();
        user.name = "AK";
        user.age = 30;
        assertAll(
            "Check user properties",
            () -> assertEquals("AK", user.name),
            () -> assertThat(user.age, greaterThan(18))
        );
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "RUN_CONDITIONAL_TEST", matches = "YES")
    @DisplayName("Testing conditional test execution")
    public void testConditionalExecution() {
        assertTrue(true);
    }

    @DisplayName("Repeated test")
    @RepeatedTest(value = 2)
    public void testRepeatedly() {
        assertTrue(true);
    }

    @ParameterizedTest(name = "Test fruit \"{0}\" with rank {1}")
    @CsvSource({
        "apple,         1",
        "banana,        2",
        "'lemon, lime', 3"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    Map<String, String> testMap = new HashMap<String, String>() {{
        put("Palindrome 3 letters", "mom");
        put("Palindrome 5 letters", "radar");
        put("Palindrome 6 letters", "redder");
    }};

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return testMap.keySet().stream()
            .map(key -> dynamicTest(key, () -> {
                String word = testMap.get(key);
                assertTrue(isPalindrome(word));
            }));
    }

    private boolean isPalindrome(String word) {
        return true;
    }

    @Nested
    @DisplayName("Some nested tests")
    class testNestedAnnotation {

        @Test
        void nestedOne() {
        }

        @Test
        void nestedTwo() {

        }
    }

    static class User {

        String name;
        int age;
    }
}
