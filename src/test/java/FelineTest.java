import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    private final Feline feline = new Feline();
    @Test
    public void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }
    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoArgumentTest() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgumentTest() {
        assertEquals(4, feline.getKittens(4));
    }

}
