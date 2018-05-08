package books.headfirst.patternDesign.decorater;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by csophys on 2018/5/7.
 */
public class JDKDecorateDemo {

    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream= new BufferedInputStream(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        });

    }
}
