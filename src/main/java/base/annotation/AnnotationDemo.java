package base.annotation;

import lombok.Data;

/**
 * Created by csophys on 16/2/11.
 */
@Annotation(age = 14)
@Data
public class AnnotationDemo {
    @Annotation("name")
    public String name;

    public String sex;
}
