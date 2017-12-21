package http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpBaseTest {


    @Test
    public void poiTest() throws IOException, InterruptedException {
        String file = "F:\\job\\2017\\11\\mami\\11月加息券数据.xls";
        FileInputStream xlsFile = new FileInputStream(new File(file));
        Workbook wb = new HSSFWorkbook(xlsFile);
        Sheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        for (int i = 1; i <= rowNum; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(2);
            CellType type = cell.getCellTypeEnum();
            String mobile;
            if (type == CellType.NUMERIC) {
                mobile = String.valueOf(cell.getNumericCellValue());
            } else {
                mobile = cell.getStringCellValue();
            }
            System.out.print(mobile + "   ===> ");
            System.out.println(showArea(mobile));
            Thread.sleep(1000L);
        }

    }

    private static String showArea(String mobile) {
        try {
            String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + mobile;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            okhttp3.Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String rsStr = response.body().string();
//                System.out.println(rsStr);
                return parse(rsStr);
            } else {
                System.out.println("error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Test
    public void getTest() {
        try {
            String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13998428125";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            okhttp3.Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.out.println("error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String DEF_REGEX = "province:'(.+?)'";
    public static String parse(String str) {
        Pattern pattern = Pattern.compile(DEF_REGEX);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return  matcher.group(1);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(showArea("18604091288"));
    }
}
