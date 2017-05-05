
package base.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by csophys on 17/4/27.
 */
@Annotation.csophys("csp")
public class Annotation {

    @csophys("good")
    public void test(){

    }

    public static void main(String[] args) throws Exception{
        //Annotation annotation = new Annotation();
        //获取类的注解信息的方式
        System.out.println(Annotation.class.getDeclaredMethod("test").getAnnotation(csophys.class).value());
        System.out.println(Annotation.class.getAnnotation(csophys.class).value());
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE,ElementType.METHOD})
    public @interface csophys{
        String value();
    }
}
