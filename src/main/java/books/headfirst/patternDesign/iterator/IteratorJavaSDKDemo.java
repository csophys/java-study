package books.headfirst.patternDesign.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by csophys on 2018/5/2.
 */
public class IteratorJavaSDKDemo {

    public static void main(String[] args) {

        //customer iterator
        CustomerCollection customerCollection = new CustomerCollection();
        while (customerCollection.hasNext()) {
            System.out.println(customerCollection.next());
        }
        // list iterator
        List<String> list = new ArrayList();
        list.add("csophys");
        list.add("chensheng");
        list.add("sheng.chen");
        for (String s : list) {
            System.out.println(s);
        }
        //array iterator
        String[] array = new String[3];
        array[0] = "csophys";
        array[1] = "chensheng";
        array[2] = "sheng.chen";
        for (String s : array) {
            System.out.println(s);
        }
        //延伸  for each 语法原理
        //java 编译器处理
        //com.sun.tools.javac.comp.Lower
        /**
         public void visitForeachLoop(JCEnhancedForLoop var1) {
         if(this.types.elemtype(var1.expr.type) == null) {
         this.visitIterableForeachLoop(var1);
         } else {
         this.visitArrayForeachLoop(var1);
         }

         }

         */
        //list 迭代器原理,字节码反编译后的效果。
        /**
         *
         Iterator i$ = list.iterator();
         while(i$.hasNext()) {
         String s = (String)i$.next();
         System.out.println(s);
         }
         */
        //数组迭代器原理，字节码反编译后的效果。
        /**
         for(int i$ = 0; i$ < len$; ++i$) {
         String s = arr$[i$];
         System.out.println(s);
         }
         */


    }
}


class CustomerCollection implements Iterator {
    int length = 5;
    int[] demoArray = new int[length];
    {
        demoArray[0]=0;
        demoArray[1]=10;
        demoArray[2]=20;
        demoArray[3]=30;
        demoArray[4]=40;
    }
    int index = 0;

    @Override
    public boolean hasNext() {
        return index < length;
    }

    @Override
    public Object next() {
        return demoArray[index++];
    }

    @Override
    public void remove() {

    }


}