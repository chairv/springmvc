import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiao on 2015/12/19.
 */
public class LogTest {
    public static void main(String[] args) throws IOException {
        String encoding = "utf-8";
        File file = new File("C:\\Users\\tancw\\Downloads\\log0114.txt");
        Set<String> result = new HashSet<String>();
        if (file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("http://.+.ittun.com");
                Matcher matcher = pattern.matcher(lineTxt);
                if (matcher.find()) {
                    result.add(matcher.group());
                }
            }
            read.close();
            System.out.println(result.size());
            for (Iterator<String> iterator = result.iterator(); iterator.hasNext(); ) {
                String next = iterator.next();
                System.out.println(next);
            }
        } else {
            System.out.println("没发现文件");
        }
    }
}
