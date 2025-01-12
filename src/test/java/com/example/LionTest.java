package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {

    @Test
    public void testDoesHaveManeMale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeFemale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        new Lion(feline, "Другой");
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(2);

        Lion lion = new Lion(feline, "Самец");
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        Lion lion = new Lion(feline, "Самец");
        assertEquals(List.of("Мясо"), lion.getFood());
    }
}
