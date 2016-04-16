package books.deep_analysis_java_web.IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by csophys on 16/4/16.
 */
public class AdapterDesignPattern {

    //reader 转换为 stream
    @Test
    public void outputStreamAdapterToWriter() throws IOException {
        File ioAdapter = new File("IOAdapter");
        FileOutputStream fileOutputStream = new FileOutputStream(ioAdapter);
        ioAdapter.createNewFile();
        fileOutputStream.write('A');
        byte[] bytes = new byte[2];
        bytes[0] = 97;
        bytes[1] = 49;
        fileOutputStream.write(bytes);

        //输出字节流适配成 输出的字符流
        OutputStreamWriter outputStreamWriterDefault = new OutputStreamWriter(fileOutputStream);
        //要写入的字符数组的位移和长度
        outputStreamWriterDefault.write("--write包含了中文部分", 2, 10);
        outputStreamWriterDefault.flush();

        //输出字节流适配成 输出的字符流,适配过程需要指定编码格式
        OutputStreamWriter outputStreamWriterEncode = new OutputStreamWriter(fileOutputStream, "GBK");
        outputStreamWriterEncode.write("我也是中文");
        outputStreamWriterEncode.flush();
    }
}
