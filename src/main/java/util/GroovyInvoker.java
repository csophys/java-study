package util;

import groovy.util.Eval;

/**
 * Created by csophys on 2018/7/29.
 */
public class GroovyInvoker {
    public static void main(String[] args) {
        Object me = Eval.me("println 'hello groovy' \n int x \n x=1+3 \nreturn x");
        System.out.println(me);
    }
}
