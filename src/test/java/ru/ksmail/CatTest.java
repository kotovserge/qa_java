package ru.ksmail;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    private Feline feline;

    @Before
    public void init()  throws Exception {
        cat = new Cat(feline);
    }

    @Test
    public  void getSound() {
        Assert.assertEquals( "Мяу", cat.getSound());
    }

    @Test
    public void  getFood() throws  Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
