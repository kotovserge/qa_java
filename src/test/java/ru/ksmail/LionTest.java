package ru.ksmail;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String sex = "Самка";
    private Lion lion;

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion(feline, sex);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        lion = new Lion(feline, sex);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }


    @Test
    public void lionConstructorExceptionTest() {
        try {
            lion = new Lion(feline, "неопределен");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка"
                    , e.getMessage());
        }
    }

}
