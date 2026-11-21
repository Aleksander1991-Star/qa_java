import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParametrized {

    private final String sex; // Пол
    private final boolean expectedHasMane;

    public LionTestParametrized(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        // Создаем экземпляр класса Lion с заданным полом
        Lion lion = new Lion(sex, new Feline());

        // Проверяем соответствует ли результат ожиданиям
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}
