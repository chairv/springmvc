package http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by tancw on 2017/7/19.
 */
public class OkHttpUtils {
    final static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

//    public static void main(String[] args) {
//        String url = "http://localhost:8123/refresh";
//        RequestBody body = new FormBody.Builder().build();
//        Request request = new Request.Builder().url(url).post(body).build();
//        try {
//            Response response = cLient.newCall(request).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static String post(String url, String jsonParam) throws IOException {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonParam);
        Request request = new Request.Builder()
                .url(url)//请求的url
                .post(requestBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


}
