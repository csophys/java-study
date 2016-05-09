package util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class HttpUtil {

    private static RequestConfig requestConfig =
            RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();

    public static String post(String url) throws Exception {
        return post(url, new HashMap<String, String>());
    }

    public static String get(String url, Map<String, String> params) throws Exception {
        String generatedUrl = url + "?";
        Iterator<String> keyIterator = params.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            generatedUrl += key + "=" + params.get(key);
            if (keyIterator.hasNext()) {
                generatedUrl += "&";
            }
        }
        return get(generatedUrl);
    }

    public static String get(String url) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.setConfig(requestConfig);
        String body = invoke(client, get);
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static String post(String url, Map<String, String> params) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = postForm(url, params);
        post.setConfig(requestConfig);
        String body = invoke(client, post);
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static String post(String url, String json) throws Exception {
        StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setConfig(requestConfig);
        post.setEntity(requestEntity);
        post.setHeader("Content-type", "application/json");

        String body = invoke(client, post);
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;

    }

    private static String invoke(HttpClient httpclient, HttpUriRequest httpost) throws Exception {
        HttpResponse response = sendRequest(httpclient, httpost);
        String body = paseResponse(response);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 400 && statusCode < 500) {
            throw new ClientException(statusCode, body);
        } else if (statusCode >= 500) {
            throw new ServerException(statusCode, body);
        }


        return body;
    }

    private static String paseResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        String body = null;
        try {
            body = EntityUtils.toString(entity);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    private static HttpResponse sendRequest(HttpClient httpclient, HttpUriRequest httpost) throws Exception {
        HttpResponse response;
        response = httpclient.execute(httpost);

        return response;
    }

    private static HttpPost postForm(String url, Map<String, String> params) {
        HttpPost httpost = new HttpPost(url);
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();

            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key)));
            }

            try {
                httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return httpost;
    }

    public static String rest(String queueCountBroadCastUrl, Object[] objects) throws Exception {
        StringBuilder destUrl = new StringBuilder(queueCountBroadCastUrl);
        for (Object object : objects) {
            destUrl.append("/" + URLEncoder.encode(object.toString(), "UTF-8"));
        }
        return post(destUrl.toString());
    }

    public static class ClientException extends RuntimeException {
        public ClientException(int statusCode, String body) {
            super(("statusCode" + statusCode + ",body:" + body));
        }
    }

    public static class ServerException extends RuntimeException {
        public ServerException(int statusCode, String body) {
            super(("statusCode" + statusCode + ",body:" + body));
        }
    }

}