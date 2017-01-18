package base.base;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by csophys on 16/10/18.
 */
public class ClassParam {

    @Test
    public void testWithStringClassParam(){
        Assert.assertTrue(stringClassParam(String.class).equals(String.class.getCanonicalName()));
    }

    @Test
    public void testWithGenericClassParam(){
        List<? extends String> strList;
        List<? super String> strings;
    }


    public static <T> T genericClassParam(Class<T> clazz)  {
        T b = null;
        return b;
    }


    private String stringClassParam(Class<String> stringClass) {
        return stringClass.getCanonicalName();
    }

}
