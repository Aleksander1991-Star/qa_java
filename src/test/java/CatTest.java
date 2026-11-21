import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnsMeowTest() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodToPredatorTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
        Mockito.verify(felineMock, Mockito.times(1)).eatMeat();
    }


}
