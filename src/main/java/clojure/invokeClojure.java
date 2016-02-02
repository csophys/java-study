package clojure;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.RT;

/**
 * Created by csophys on 16/1/11.
 */
public class invokeClojure {

    public static void main(String[] args) {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("org.csophys.demo"));
        System.out.println(RT.var("org.csophys.demo", "good?").invoke(1));
    }
}
