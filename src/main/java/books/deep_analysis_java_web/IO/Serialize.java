package books.deep_analysis_java_web.IO;

import org.junit.Assert;

import java.io.*;

/**
 * Created by csophys on 16/4/16.
 */
public class Serialize implements Serializable {

    public String field = "field";

    public String getField(){
        return field;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serialize serialize = new Serialize();

        File file = new File("Serialize");

        if(file.exists()){
            file.delete();
        }
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //增强stream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(serialize);

        System.out.println("成功写入本对象");

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Serialize o = (Serialize) objectInputStream.readObject();

        Assert.assertEquals(o.getField(),"field");
        System.out.println("成功反序列化");
    }
}
