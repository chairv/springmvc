package http;


import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by tancw on 2017/6/16.
 */
public class HttpClientDemo {
    final static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) {
        String appid = "wx62aa1895c2c35ffd";
        String secret = "e2a12b12d7fe55822cb5186c6ee19f2a";
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
        HttpGet httpget = new HttpGet(String.format(url, appid, secret));

        ResponseHandler<String> rh = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                if (statusLine.getStatusCode() >= 300) {
                    throw new HttpResponseException(
                            statusLine.getStatusCode(),
                            statusLine.getReasonPhrase());
                }
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                return IOUtils.toString(entity.getContent());
            }
        };

        try {
            String result = httpClient.execute(httpget, rh);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
