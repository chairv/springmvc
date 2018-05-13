package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SpringDreamWithdrawNotice {
    public static final String DEF_REGEX = "\\$\\{(.+?)\\}";
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static String tempalte = "{    \n" +
            "   \"touser\": \"${weChatNo}\",\n" +
            "    \"template_id\": \"OspZkCcMgVtCAbUVxu_1rHr5lTdkZmE1KjCY-9Qt7ks\",\n" +
            "    \"url\": \"\",\n" +
            "    \"topcolor\": \"#FF0000\",\n" +
            "    \"data\": {\n" +
            "        \"first\": {\n" +
            "            \"value\": \"您春节期间到期的钱罐将于2月26日进行提现处理，建议您及时选择续投，续投当日计息！\"\n" +
            "        },\n" +
            "        \"productname\": {\n" +
            "            \"value\": \"钱罐\"\n" +
            "        },\n" +
            "        \"date\": {\n" +
            "            \"value\": \"${endDate}\"\n" +
            "        },\n" +
            "        \"remark\": {\n" +
            "           \"value\": \"如有问题请联系微信猪猪客服。\"\n" +
            "        }\n" +
            "    }\n" +
            "} ";

    public static void main(String[] args) throws Exception {
        File file = new File("F:\\job\\2018\\spring-withdraw.xls");
        InputStream is = new FileInputStream(file);
        Workbook wb = new HSSFWorkbook(is);
        Sheet sheet = wb.getSheetAt(0);
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            String endDate = row.getCell(9).getStringCellValue();
            Date date = DateUtils.parseDate(endDate, new String[]{"MM/dd/yyyy"});
            String msg = StringUtils.replace(tempalte, "${endDate}", dateFormat.format(date));
            Cell msgCell = row.createCell(11);
            msgCell.setCellValue(msg);
        }
        File wirteFile = new File("F:\\job\\2018\\notice2.xls");
        FileOutputStream outputStream = new FileOutputStream(wirteFile);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        IOUtils.closeQuietly(is);
    }
}
