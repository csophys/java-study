package books.deep_analysis_java_web.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by csophys on 16/4/16.
 */
public class NIO {

    @Test
    public void FileNio() throws IOException {
        //channel
        String iOchanel1 = "IOchane1";
        File file = new File(iOchanel1);
        file.createNewFile();
        //Channel,Selector,Buffer
    }

    @Test
    public void SocketNio() {
        //TODO
    }
}
