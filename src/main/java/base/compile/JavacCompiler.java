import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class JavacCompiler {

    public static void main(String args[]) throws IOException {
        //创建java编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        //源代码
        String code = "public class HelloWorld {\n" +
                "  public static void main(String args[]) {\n" +
                "    System.out.println(\"execute in java with String code java\");\n" +
                "  }\n" +
                "}";

        JavaFileObject file = new JavaSourceFromString("HelloWorld", code);

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);

        //构造编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, null, null, null, null, compilationUnits);

        //执行编译任务
        boolean success = task.call();

        //获取编译结果
        System.out.println("Success: " + success);


        if (success) {

            try {
                //获得一个classloader实例
                URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new File("").toURI().toURL() });

                //使用classloader去加载一个class类，并且执行方法调用
                Class.forName("HelloWorld", true, classLoader).getDeclaredMethod("main", new Class[] { String[].class }).invoke(null, new Object[] { null });

            } catch (ClassNotFoundException e) {

                System.err.println("Class not found: " + e);

            } catch (NoSuchMethodException e) {

                System.err.println("No such method: " + e);

            } catch (IllegalAccessException e) {

                System.err.println("Illegal access: " + e);

            } catch (InvocationTargetException e) {

                System.err.println("Invocation target: " + e);

            }

        }

    }

}

class JavaSourceFromString extends SimpleJavaFileObject {

    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {

        return code;
    }

}