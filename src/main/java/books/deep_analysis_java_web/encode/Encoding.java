package books.deep_analysis_java_web.encode;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by csophys on 16/4/22.
 */
public class Encoding {


    // 1. why encoding?,bytes to char

    // 2. encoding ASCII ISO-8859-1 GB2312 GBK GB18030  UTF-16 UTF-8

    // 3. UTF-8 边长字节详解

    // 4. java string 内存中的存储统一为Unicode UTF-16

    @Test
    public void memoryStringEncode() throws UnsupportedEncodingException {

        //demo1
        //String str = "abc我是中文";
        String str = "我我我我我我a";
        System.out.println(str.getBytes("UTF-8").length);
        System.out.println(str.getBytes("UTF-16").length);
        System.out.println(str.getBytes("GBK").length);



    }

}
