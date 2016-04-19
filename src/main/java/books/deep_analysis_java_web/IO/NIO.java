package books.deep_analysis_java_web.IO;

import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.Callable;

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
    public void SocketNio() throws IOException {
        // --- server socket
        //新建一个serverSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(1999));

        //非阻塞模式
        serverSocketChannel.configureBlocking(false);


        //创建 selector
        final Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // --- client socket1

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(1999));


        // 可以继续设置多个socket

        Awaitility.await().atMost(Duration.FIVE_SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                while (true) {
                    /**
                     * 等待客户端连接；
                     */
                    selector.select();

                    //处理连接的请求
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    for (SelectionKey selectionKey : selectionKeys) {
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                        //获取channel
                        SocketChannel socketChannel2 = serverSocketChannel1.accept();
                        // 设置成非阻塞
                        socketChannel2.configureBlocking(false);
                        //更改channel的事件类型
                        socketChannel2.register(selector, SelectionKey.OP_READ);
                    }
                    System.out.println(selectionKeys);
                    return true;
                }

            }
        }, Matchers.equalTo(true));


    }
}
