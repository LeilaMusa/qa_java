package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    @Parameterized.Parameters(name = "Test case: {index} | Input: {0} | Expected: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {5, 5},
                {10, 10},
                {0, 0}
        };
    }

    private final int inputKittensCount;
    private final int expectedKittens;

    public FelineParameterizedTest(int inputKittensCount, int expectedKittens) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Test
    public void testGetKittensWithParameterizedValues() {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(inputKittensCount));
    }
}

