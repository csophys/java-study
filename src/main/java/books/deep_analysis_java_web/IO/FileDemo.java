package books.deep_analysis_java_web.IO;

import java.io.File;
import java.io.IOException;

/**
 * Created by csophys on 16/5/19.
 */
public class FileDemo {

    public static void main(String[] args) {

        File hello = new File("src","hello");
        try {
            hello.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
