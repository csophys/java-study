package base.base;

/**
 * Created by csophys on 17/4/23.
 */
public class Finalizer {

    public void finalize(){
        System.out.println("now enter in the finalize method. instance:"+this.toString());
    }

    public static void main(String[] args) throws InterruptedException {

        Finalizer finalizer = new Finalizer();
        Finalizer finalizer1 = new Finalizer();
        Finalizer finalizer2 = new Finalizer();
        System.out.println(finalizer);
        System.out.println(finalizer1);
        System.out.println(finalizer2);
        finalizer=null;
        finalizer1=null;
        System.gc();

    }

}
