package books.deep_analysis_java_web.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by csophys on 16/4/16.
 */
public class NIO {

    /*
        阻塞IO与非阻塞IO
    */
    @Test
    public void FileNio() throws IOException {
        //channel
        String iOchanel1 = "IOchane1";
        File file = new File(iOchanel1);
        file.createNewFile();
        //Channel,Selector,Buffer
        /*Channel和stream对比，Channel是双向的,stream是单向的。

        buffer是载体，数据需要在buffer上装载。

        selector 来监听注册在上面的channel 的事件。*/

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //1.创建channel
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(1000);

        allocate.put("I am buffer".getBytes());
        //必须flip后才能 供后续读取,flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。

        allocate.put("我是中文".getBytes());

        allocate.flip();
        channel.write(allocate);

        channel.close();


        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel1 = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
        channel1.read(byteBuffer);

/*
        marker,position,limit,capacity
*/
        byteBuffer.flip();

        /**
         * ByteBuffer 与 CharBuffer 之间存在转换
         */
        System.out.print(Charset.defaultCharset().decode(byteBuffer));

    }

    @Test
    public void SocketNio() {
        //TODO
    }
}
