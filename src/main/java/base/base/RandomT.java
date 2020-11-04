package base.base;

import java.util.Random;

public class RandomT {

    public static void main(String[] args) {
        Random r1 = new Random(1);

        Random r2 = new Random(1);
        Random r3 = new Random(1);
        Random r4 = new Random(1);
        Random r5 = new Random(1);

        for (int i = 0; i < 4; i++) {

            System.out.println(r1.nextInt(5));
        }
        System.out.println("++++++++++++++++++++++");
        for (int i = 0; i < 4; i++) {

            System.out.println(r2.nextInt(5));
        }
        System.out.println(r3.nextInt(5));
        System.out.println(r4.nextInt(5));
        System.out.println(r5.nextInt(5));
    }
}
