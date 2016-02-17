package base.annotation;

import org.junit.Test;

public class AnnotationDemoTest {

    @Test
    public void testAnnotation() throws Exception{
        Class<?> name = Class.forName("base.annotation.AnnotationDemo");

        System.out.println(name.getFields().length);
    }

}