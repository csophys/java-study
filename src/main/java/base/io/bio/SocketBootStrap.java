package base.io.bio;

import java.io.IOException;

/**
 * Created by csophys on 2017/3/26.
 */
public class SocketBootStrap {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("启动服务端。。。");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SocketServer.initServer();
                } catch (IOException e) {
                    System.out.println("socketServer 启动失败");
                }
            }
        }).start();

        while (!SocketServer.isStarted()) {
            Thread.sleep(1000);
            System.out.println("服务端还未启动成功。继续探测。");
        }

        System.out.println("启动服务端成功。");
        for (int i = 1; i < 20; i++) {
            System.out.println("启动第"+i+"个客户端");
            SocketClient socketClient = new SocketClient();
            try {
                socketClient.start();
                System.out.println("启动第"+i+"个客户端成功。");
            } catch (IOException e) {
                System.out.println("第" + i + "个socketClient 启动失败");
            }
        }
    }
}
