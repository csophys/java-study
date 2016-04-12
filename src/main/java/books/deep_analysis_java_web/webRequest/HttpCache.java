package books.deep_analysis_java_web.webRequest;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by csophys on 16/4/10.
 */
public class HttpCache {
    /**
     * 1.cache-control
     */

    /**
     public	所有内容都将被缓存
     private	内容只缓存到私有缓存中
     no-cache	所有内容都不会被缓存
     no-store	所有内容都不会被缓存到缓存或 Internet 临时文件中
     must-revalidation/proxy-revalidation	如果缓存的内容失效，请求必须发送到服务器/代理以进行重新验证
     max-age=xxx (xxx is numeric)	缓存的内容将在 xxx 秒后失效, 这个选项只在HTTP 1.1可用, 并如果和Last-Modified一起使用时, 优先级较高
     缓存指令是单向的，即请求中存在一个指令并不意味着响应中将存在同一个指令。
     */


    /**
     * 2.Expired
     */

    /**
     Expires 头部字段提供一个日期和时间，响应在该日期和时间后被认为失效。失效的缓存条目通常不会被缓存（无论是代理缓存还是用户代理缓存）返回，除非首先通过原始 服务器（或者拥有该实体的最新副本的中介缓存）验证。（注意：cache-control max-age 和 s-maxage 将覆盖 Expires 头部。）
     */


    /**
     * 3.ETag/Last-Modified
     */

    /**
     Last-Modified 实体头部字段值通常用作一个缓存验证器。简单来说，如果实体值在 Last-Modified 值之后没有被更改，则认为该缓存条目有效。ETag 响应头部字段值是一个实体标记，它提供一个 “不透明” 的缓存验证器。这可能在以下几种情况下提供更可靠的验证：不方便存储修改日期；HTTP 日期值的 one-second 解决方案不够用；或者原始服务器希望避免由于使用修改日期而导致的某些冲突。
     If-Modified-Since & If-None-Match
     */


    /**
     * chrome浏览器执行
     * 按前进，后退按扭	如果值为private、must-revalidate、max-age,则不会重访问,而如果为no-cache,则每次都重复访问.
     * 地址栏回车，按刷新按扭	无论为何值,都会重复访问.
     */

    @Test
    public void test304() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://www.baidu.com/img/bd_logo1.png");
        CloseableHttpResponse httpResponse = client.execute(post);
        Assert.assertTrue(httpResponse.getStatusLine().getStatusCode() == 200);
        System.out.println(httpResponse);

        //测试ETag
        HttpGet get = new HttpGet("https://www.baidu.com/img/bd_logo1.png");
        get.addHeader("If-None-Match", httpResponse.getFirstHeader("ETag").getValue());


        Assert.assertTrue(client.execute(get).getStatusLine().getStatusCode() == 304);

        //测试Last-Modified
        get = new HttpGet("https://www.baidu.com/img/bd_logo1.png");
        get.addHeader("If-Modified-Since", "Wed, 03 Sep 2015 10:00:27 GMT");
        Assert.assertTrue(client.execute(get).getStatusLine().getStatusCode() == 304);

        //如果header中同时含有两者，一般是并且的关系，同时需要满足
    }


/*
    创建的HTTP Header
*/
}
