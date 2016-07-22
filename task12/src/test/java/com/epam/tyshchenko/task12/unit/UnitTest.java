package com.epam.tyshchenko.task12.unit;

import com.epam.tyshchenko.task12.plain.Math;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

import static org.junit.Assert.assertEquals;

/**
 * Created by Olena_Tyshchenko on 18.07.2016.
 */
@Resource.Classpath("properties/test.properties")
public class UnitTest {

    public UnitTest(){
        PropertyLoader.populate(this);
    }

    @Property("a")
    private int a;

    @Property("b")
    private int b;

    private Math math;

    @Before
    public void setUp(){
       math = new Math();
    }

    @Test
    public void testSum(){
        assertEquals(a+b, math.sum(a,b));
    }

    @Test
    public void testSub(){
        assertEquals(a-b, math.sub(a,b));
    }

    @Test
    public void testMul(){
        assertEquals(a*b, math.mul(a,b));
    }

    @Test
    public void testDiv(){
        assertEquals(a/b, math.div(a,b));
    }

    @Test
    public void testDivNegative(){
        try {
            math.div(a,0);
        } catch (ArithmeticException e){
            assertEquals("/ by zero", e.getMessage());
        }
    }

}
