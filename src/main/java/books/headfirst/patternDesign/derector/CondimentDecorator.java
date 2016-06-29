package books.headfirst.patternDesign.derector;

/**
 * Created by csophys on 16/6/29.
 */

/**
 * 这个类特别要注意,它是所有装饰对象的父类,装饰对象与被装饰对象必须是一样的类型,这边继承于beverage 只是为了类型匹配
 */
public abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;

    public void getDescription() {
        System.out.println("I am a 装饰父类");
    }
}
