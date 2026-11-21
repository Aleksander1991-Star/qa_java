import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    private Lion lion;

    @Test
    public void constructorInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Неизвестно", felineMock));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", felineMock);

        assertEquals(2, lion.getKittens());
        Mockito.verify(felineMock, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodToFelineWithPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expected);

        Lion lion = new Lion("Самка", felineMock);

        assertEquals(expected, lion.getFood());
        Mockito.verify(felineMock,  Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void doesHaveManeMaleReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemaleReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

}
