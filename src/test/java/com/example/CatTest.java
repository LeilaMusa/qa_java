import com.example.Cat;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    private Predator predatorMock;
    private Cat cat;

    @Before
    public void setUp() {
        predatorMock = mock(Predator.class);
        cat = new Cat(predatorMock);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(List.of("Мясо"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Мясо"), food);
        verify(predatorMock, times(1)).eatMeat();
    }
}

