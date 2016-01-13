import clojure.java.api.Clojure;
import clojure.lang.IFn;

import java.util.*;

/**
 * Created by csophys on 16/1/11.
 */
public class invokeClojure {

    public static void main(String[] args) {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("org.csophys.demo"));
        IFn iFn = Clojure.var("org.csophys.demo", "hello");
        System.out.println(iFn.invoke("csophys ,now java can invoke clojure perfectly"));
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        System.out.println(iFn.invoke(list));

        Set<String> hashSet= new HashSet<String>();
        hashSet.add("csophys");
        hashSet.add("fefei");
        hashSet.add("good");
        System.out.println(iFn.invoke(hashSet));
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"hello");
        map.put(3,"csophys");
        map.put(5,"sex");
        System.out.println(iFn.invoke(map));
    }
}
