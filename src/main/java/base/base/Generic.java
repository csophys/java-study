package base.base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by csophys on 17/4/27.
 */
public class Generic {

    public static void main(String[] args) {
        A stringA = new A("nihaojn");
        System.out.println(stringA.sout());

        A StringB = new A(new Integer(34));
        System.out.println(StringB.sout());


        A a1 = new A("", "nihaojn");
        System.out.println(a1.soutB());
        A a2 = new A("",new Integer(34));
        System.out.println(a2.soutB());


        List<Integer> json = new Gson().fromJson("[1,3]", new TypeToken<List<Integer>>() {
        }.getType());
    }

    //泛型类
    static class  A<T>{
        T a;
        Object b;
        A(T a){
            this.a=a;
        }

        A(T a,Object b){
            this.b = b;
        }
        <T> T sout(){
            System.out.println(a.getClass());
            return (T) a;
        }

        Object soutB(){
            System.out.println(b.getClass());
            return b;
        }
    }
}


