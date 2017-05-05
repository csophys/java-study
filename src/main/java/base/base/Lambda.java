package base.base;

import java.util.Arrays;

/**
 * Created by csophys on 17/4/30.
 */
public class Lambda {

    public static void main(String[] args) {
        int a[]={1,3,3,2,5};
        Arrays.sort(a);
        System.out.println(a);
        GenericClass<String> stringGenericClass = new GenericClass("good");
        System.out.println(stringGenericClass.getA());



    }

    static class GenericClass<Tta extends Comparable<Tta>>{
        private Tta a;

        public GenericClass(Tta a) {
            this.a = a;
        }


        public Tta getA() {
            return a;
        }


        public static <T> T getMethod(T t){
            return t;
        }
    }
}
