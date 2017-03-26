package base.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by csophys on 2017/3/26.
 */
public class SocketServer {

    private static boolean started = false;
    public static final int PORT = 1999;

    public static boolean isStarted() {
        return started;
    }

    public static void initServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        started = true;

        while (true) {
            //获取一个socket连接
            final Socket socket = serverSocket.accept();
            System.out.println(socket + "已经连接");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        //只默认读取一行。
                        System.out.println("接收到客户端数据:"+bufferedReader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
