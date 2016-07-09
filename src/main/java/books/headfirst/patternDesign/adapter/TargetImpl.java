package books.headfirst.patternDesign.adapter;

/**
 * Created by csophys on 16/7/9.
 */
public class TargetImpl implements Target {
    @Override
    public void execute(int param1, int param2) {
        System.out.println("I am a impl");
    }
}
