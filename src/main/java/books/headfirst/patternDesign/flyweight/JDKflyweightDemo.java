package books.headfirst.patternDesign.flyweight;

/**
 * Created by csophys on 2018/5/7.
 */
public class JDKflyweightDemo {

    public static void main(String[] args) {

        Integer integer = new Integer(3);
        Integer integer1 = new Integer(3);
        Integer integer2 = new Integer(3);
        Integer i1 = Integer.valueOf(4);
        Integer i2 = Integer.valueOf(4);
        Integer i3 = Integer.valueOf(5);
        Integer i4 = Integer.valueOf(6);

        Integer integer3 = Integer.valueOf(129);
        Integer integer4 = Integer.valueOf(129);
        Integer integer5 = new Integer(129);

    }
}
