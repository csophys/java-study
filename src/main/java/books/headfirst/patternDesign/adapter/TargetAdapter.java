package books.headfirst.patternDesign.adapter;

/**
 * Created by csophys on 16/7/9.
 */
public class TargetAdapter implements Target {

    Adaptee adaptee;

    public TargetAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void execute(int param1, int param2) {
        adaptee.action(param1,String.valueOf(param2));
    }
}
