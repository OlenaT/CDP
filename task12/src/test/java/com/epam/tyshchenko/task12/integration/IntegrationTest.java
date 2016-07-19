package com.epam.tyshchenko.task12.integration;

import com.epam.tyshchenko.task12.Math;
import com.epam.tyshchenko.task12.Text;
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
public class IntegrationTest {

    public IntegrationTest(){
        PropertyLoader.populate(this);
    }

    @Property("a")
    private int a;

    @Property("b")
    private int b;

    private Math math;
    private Text text;

    @Before
    public void setUp(){
        math = new Math();
        text = new Text();
    }

    @Test
    public void parseTest(){
        String expected = Integer.toString(a+b);
        String actual = text.toString(math.sum(a,b));
        assertEquals(expected, actual);
    }

}
