import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class LionTest {

    private Predator predatorMock;

    @Before
    public void setUp() {
        predatorMock = mock(Predator.class);
    }

    @Test
    public void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", predatorMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", predatorMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        new Lion("Invalid", predatorMock);
    }

    @Test
    public void testGetFood() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самец", predatorMock);
        List<String> food = lion.getFood();
        assertEquals(List.of("Мясо"), food);
        verify(predatorMock, times(1)).eatMeat();
    }
}