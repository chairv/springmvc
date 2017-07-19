package http;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by tancw on 2017/7/19.
 */
public class OkHttpUtils {
    final static OkHttpClient  cLient = new OkHttpClient();
    public static void main(String[] args) {
        String url = "http://localhost:8123/refresh";
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = cLient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
