import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tancw on 2016/6/16.
 */
public class HttpTest {
    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        String url = "https://a.huodong.mi.com/activity/share/actForOpen?openid=oMH_Gjj7dnOLQXZPwXMlXeVBcRwU&code=max2gift&channel=m&jsonpcallback=share";
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
