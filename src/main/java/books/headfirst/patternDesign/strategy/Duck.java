package books.headfirst.patternDesign.strategy;

/**
 * Created by csophys on 16/6/26.
 */
public abstract class Duck {

    //飞行行为
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void swim(){
        System.out.println("swin");
    }


    public void display(){
        System.out.println("display");
    }

    public boolean performFly(){
        return flyBehavior.fly();
    }

    public boolean performQuack(){
        return quackBehavior.quack();
    }

}
