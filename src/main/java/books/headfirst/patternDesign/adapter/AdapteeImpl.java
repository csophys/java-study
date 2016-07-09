package books.headfirst.patternDesign.adapter;

/**
 * Created by csophys on 16/7/9.
 */
public class AdapteeImpl implements Adaptee {
    @Override
    public void action(int param1, String param2) {
        System.out.println("I am Adaptee");
    }
}
