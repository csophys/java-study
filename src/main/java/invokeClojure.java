import clojure.java.api.Clojure;
import clojure.lang.IFn;

/**
 * Created by csophys on 16/1/11.
 */
public class invokeClojure {

    public static void main(String[] args) {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("org.csophys.demo"));
        IFn plus1 = Clojure.var("org.csophys.demo", "hello");
        System.out.println(plus1.invoke("csophys ,now java can invoke clojure perfectly"));

    }
}
