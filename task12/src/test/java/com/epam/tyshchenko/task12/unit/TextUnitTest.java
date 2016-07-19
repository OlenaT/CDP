package com.epam.tyshchenko.task12.unit;

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
public class TextUnitTest {

    public TextUnitTest(){
        PropertyLoader.populate(this);
    }

    @Property("a")
    private int a;

    private Text text;

    @Before
    public void setUp(){
        text = new Text();
    }

    @Test
    public void testText(){
        assertEquals(Integer.toString(a), text.toString(a));
    }
}
