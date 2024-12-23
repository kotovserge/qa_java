package ru.ksmail;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private String sex;
    private Boolean hasMane;
    private Lion lion;
    Feline feline;

    @Before
    public void init()  throws Exception {
        lion = new Lion(feline, sex);
    }

    public LionParameterizedTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setParams() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Test
    public void doesHaveManTest() throws Exception {
        assertEquals(hasMane, lion.doesHaveMane());
    }

}
