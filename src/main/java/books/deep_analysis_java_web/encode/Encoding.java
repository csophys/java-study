package books.deep_analysis_java_web.encode;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by csophys on 16/4/22.
 */
public class Encoding {

    // 1. why encoding?,bytes to char

    // 2. encoding ASCII ISO-8859-1 GB2312 GBK GB18030  UTF-16 UTF-8

    // 3. UTF-8 边长字节详解 & demo

    // 4. java string 内存中的存储统一为Unicode UTF-16

    // 5. byte to char,char to byte encode and decode

    // 6. IO,SocketIO,memory

    @Test
    public void memoryStringEncode() throws UnsupportedEncodingException {

        //demo1 encoding
        String str = "abc我是中文"; //java内存中是 unicode 编码形式
        System.out.println(str.getBytes("UTF-8").length);
        //书中有创建时序图，【截图】
        System.out.println(str.getBytes("UTF-16").length);
        System.out.println(str.getBytes("GBK").length);

        //demo2 decoding
        byte[] bytes = str.getBytes("UTF-8");
        System.out.println(new String(bytes, "UTF-8"));
    }


    @Test
    public void fileAndSocketIO() {
        //见IO 一节
    }

    // 7. 乱码分析

    @Test
    public void mixCode() throws UnsupportedEncodingException {
        String str = "hello，我包含中文";

        //先用UTF-8 encode
        System.out.println("------用utf8编码------");
        byte[] bytesWithUTF8 = str.getBytes("UTF-8");

        System.out.println("用utf8解码:" + new String(bytesWithUTF8, "UTF-8"));
        System.out.println("用utf16解码:" + new String(bytesWithUTF8, "UTF-16"));
        System.out.println("用GBK解码:" + new String(bytesWithUTF8, "GBK"));
        System.out.println("用ISO-8859-1解码:" + new String(bytesWithUTF8, "ISO-8859-1"));


        System.out.println("------用ISO-8859-1编码------");
        byte[] bytesWithISO = str.getBytes("ISO-8859-1");
        System.out.println("用utf8解码:" + new String(bytesWithISO, "UTF-8"));
        System.out.println("用utf16解码:" + new String(bytesWithISO, "UTF-16"));
        System.out.println("用GBK解码:" + new String(bytesWithISO, "GBK"));
        System.out.println("用ISO-8859-1解码:" + new String(bytesWithISO, "ISO-8859-1"));


        System.out.println("------用GBK编码------");
        byte[] bytesWithGBK = str.getBytes("GBK");
        System.out.println("用utf8解码:" + new String(bytesWithGBK, "UTF-8"));
        System.out.println("用utf16解码:" + new String(bytesWithGBK, "UTF-16"));
        System.out.println("用GBK解码:" + new String(bytesWithGBK, "GBK"));
        System.out.println("用ISO-8859-1解码:" + new String(bytesWithGBK, "ISO-8859-1"));


        System.out.println("------用UTF-16编码------");
        byte[] bytesWithUTF16 = str.getBytes("UTF-16");
        System.out.println("用utf8解码:" + new String(bytesWithUTF16, "UTF-8"));
        System.out.println("用utf16解码:" + new String(bytesWithUTF16, "UTF-16"));
        System.out.println("用GBK解码:" + new String(bytesWithUTF16, "GBK"));
        System.out.println("用ISO-8859-1解码:" + new String(bytesWithUTF16, "ISO-8859-1"));
    }

    @Test
    public void webRequestMixCode() {
        //online read

        //http://www.dianping.com/kefu/servlet/陈胜?name=陈胜  path&query UTF-8

        //demo

        //get , post

        //ajax,ajax请求的编码默认与浏览器有关

        //tomcat
    }

    @Test
    public void encodeTest() throws UnsupportedEncodingException {
        String str= "abc会员一线def%";

        System.out.println(System.getProperty("file.encoding"));
        System.out.println("系统默认编码:"+Charset.defaultCharset().name());
        //UTF-8 编码
        byte[] bytes = str.getBytes("UTF-8");

        //UTF-8 解码 GBK编码，UTF-8 解码后的形式一般如：��Աһ��
        System.out.println(new String(bytes));

        //GBK 解码
        System.out.println(new String(bytes,"GBK"));


        //UTF8 编码
        byte[] utf8bytes = str.getBytes();

        //GBK 解码   UTF8编码，GBK 解码后的形式一般如: 浼氬憳涓�嚎
        System.out.println(new String(utf8bytes, "GBK"));

    }

    //使用场景： genesys sdk 乱码问题

    @Test
    public  void testJavaChar(){
        String test = "a";

    }
}
