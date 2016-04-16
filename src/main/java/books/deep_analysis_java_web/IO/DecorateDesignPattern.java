package books.deep_analysis_java_web.IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by csophys on 16/4/16.
 */
public class DecorateDesignPattern {

    @Test
    public void testDecorateInputStream() throws FileNotFoundException {
        File ioDecorate = new File("IODecorate");
        FileInputStream fileInputStream = new FileInputStream(ioDecorate);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
    }

    @Test
    public void testDecorateReaderAndWrite() throws IOException {
        File ioDecorate = new File("IODecorate");
        FileReader fileReader = new FileReader(ioDecorate);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //字符流可以读取一行
        bufferedReader.readLine();

        FileWriter fileWriter = new FileWriter(ioDecorate);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("");
    }

}
