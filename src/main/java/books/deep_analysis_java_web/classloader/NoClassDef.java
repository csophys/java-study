package books.deep_analysis_java_web.classloader;


/**
 * Created by csophys on 16/5/8.
 */
public class NoClassDef {

    NoClassDef(){
    }

    public static void main(String[] args)throws Exception{
        //显示加载一个类，forName,loadClass,findSystemClass,找不到会抛出 ClassNotFound错误
        Class.forName("books.deep_analysis_java_web.classloader.Test");

        //隐身加载一个类：new,属性引用，继承，参数引用,抛出NoClassDefFoundError
        new Test();

        System.out.println("hello");
    }

}
