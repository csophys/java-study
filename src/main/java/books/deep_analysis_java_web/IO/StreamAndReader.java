package books.deep_analysis_java_web.IO;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by csophys on 16/4/11.
 */
public class StreamAndReader {

/*
    1.new File()  相对路径问题
    2.StringBuffer 的equals 问题，和String 不一致
*/

    @Test
    public void testGetWithStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/java/books/deep_analysis_java_web/IO/character");
        StringBuffer binaryString = new StringBuffer();
        for (; ; ) {
            int read = fileInputStream.read();
            if (read == -1) {
                break;
            }
            binaryString.append(Integer.toBinaryString(read));
        }

        Assert.assertTrue(binaryString.toString().equals("1110011010001000100100011110011010011000101011111110010010111000100000001110010010111000101010101110011010011001101011101110100110000000100110101100110110100111011001100101"));
        StringBuffer hexString = new StringBuffer();
        fileInputStream = new FileInputStream("src/main/java/books/deep_analysis_java_web/IO/character");
        for (; ; ) {
            int read = fileInputStream.read();
            if (read == -1) {
                break;
            }
            hexString.append(Integer.toHexString(read).toUpperCase());
        }
        Assert.assertTrue(hexString.toString().equals("E68891E698AFE4B880E4B8AAE699AEE9809A66696C65"));
    }


    @Test
    public void testGetWithReader() throws IOException {
        FileReader fileReader = new FileReader("src/main/java/books/deep_analysis_java_web/IO/character");
        char[] x = new char[10];
        fileReader.read(x, 0, 10);
        Assert.assertTrue(new String(x).equals("我是一个普通file"));
    }
}
