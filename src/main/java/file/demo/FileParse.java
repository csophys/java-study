package file.demo;

import java.io.File;

/**
 * Created by csophys on 16/1/27.
 */
public class FileParse {
    public static void main(String[] args) {
        File file = new File("/Users");
        for (File file1 : file.listFiles()) {
            System.out.println(file1.getName());
        }
    }
}
