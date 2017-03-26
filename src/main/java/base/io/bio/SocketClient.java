package base.io.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by csophys on 2017/3/26.
 */
public class SocketClient {

    public static final int PORT = 1999;
    public static final String HOST = "127.0.0.1";

    public void start() throws IOException {
        Socket socket = new Socket(HOST, PORT);
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);
        bufferedWriter.write("发送给服务端的数据，"+(int)(100*Math.random()));
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
