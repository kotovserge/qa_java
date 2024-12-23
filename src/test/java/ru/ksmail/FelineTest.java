package ru.ksmail;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatPredator() throws Exception {
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        assertEquals(list, feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getKittensTest5() {
        assertEquals( 5, feline.getKittens(5));
    }

    @Test
    public void getKittensTest1() {
        assertEquals( 1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}
