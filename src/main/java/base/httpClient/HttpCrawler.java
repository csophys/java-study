package base.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by csophys on 16/4/21.
 */
public class HttpCrawler {

    @Test
    public void download() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://10.128.18.28:29500/retriever/replay?audio:format=Portable&audioinums=721004011314494&encryption=None&type=audio&searcharchiver=false&searchbuffer=true&token=994A5FDCBED46ADE994A5FDCBED46ADEADBBEAC25C5728923BA4FC84E99F98C80CA04E422D61664BAC671FDF72342B34925AE419F01C5D64915A95A90C753C31AE6B657BDFC93D49BBD7EF58312B42D273D89B812C711F1663B3574060AA124B94749EF91019D510&ext=.wav");
        Date start = new Date();
        System.out.println(start);
        CloseableHttpResponse httpResponse = client.execute(get);

        HttpEntity entity = httpResponse.getEntity();

        InputStream content = entity.getContent();

        FileOutputStream fileOutputStream = new FileOutputStream("1.wav");

        Date startWriteLocalFile = new Date();
        System.out.println(startWriteLocalFile);
        while (true) {
            int read = content.read();
            if (read != -1) {
                fileOutputStream.write(read);
            } else {
                break;
            }
        }

        Date end = new Date();
        System.out.println(end);
        System.out.println((end.getTime() - start.getTime()));

    }
}
