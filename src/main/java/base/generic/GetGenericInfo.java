package base.generic;

import java.lang.reflect.Type;


public class GetGenericInfo extends Hello<String,Integer> {

    public static void main(String[] args) {

        Type genericSuperclass = GetGenericInfo.class.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }
}


class Hello<T,S> {

}



