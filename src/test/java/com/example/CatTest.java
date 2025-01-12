package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    @Test
    public void testGetSound() {
        Feline feline = Mockito.mock(Feline.class); // Мокаем Feline
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class); // Мокаем Feline
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));

        Cat cat = new Cat(feline);
        assertEquals(List.of("Мясо"), cat.getFood());
    }
}


