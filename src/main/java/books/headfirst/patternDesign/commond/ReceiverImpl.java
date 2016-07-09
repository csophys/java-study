package books.headfirst.patternDesign.commond;

/**
 * Created by csophys on 16/7/9.
 */
public class ReceiverImpl implements Receiver {
    @Override
    public void doExecute() {
        System.out.println("I am a concrete Receiver");
    }
}
