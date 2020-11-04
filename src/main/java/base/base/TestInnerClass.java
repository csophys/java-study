package base.base;

import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestInnerClass {
    @Data
    static class Node {
        String name;
        int time;
        AtomicBoolean flag = new AtomicBoolean();
    }

    public static void main(String[] args) {
        final StringBuffer test = new StringBuffer("abc");
        final Node node = new Node();
        node.name="123";
        System.out.println("1-"+test.hashCode());
        System.out.println("11-"+node.hashCode());
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("2-"+test.hashCode());
                System.out.println("22-"+node.hashCode());
            }
        }).start();
        System.out.println("3-"+test.hashCode());
    }
}
