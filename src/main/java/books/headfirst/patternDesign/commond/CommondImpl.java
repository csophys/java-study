package books.headfirst.patternDesign.commond;

/**
 * Created by csophys on 16/7/3.
 */
public class CommondImpl implements ICommond {
    Receiver receiver;

    public CommondImpl(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doExecute();
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException();
    }
}
