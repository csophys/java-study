package books.headfirst.patternDesign.template;

/**
 * Created by csophys on 16/7/9.
 */
public abstract class AbstractStepList {

    public void step(){
        // 清理现场
        clean();

        first();

        second();

        hook();

        finish();

    }

    private void finish() {
        System.out.println("finish list");
    }

    protected void hook() {

    }

    protected abstract void second();

    protected abstract void first();


    private void clean() {
        System.out.println("clean you environment");
    }
}
