package pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Created by tancw on 2017/5/18.
 */
public class PdfDemo2 {

    public static void main(String[] args) throws Exception {
        find();
    }

    public static void create() throws Exception {
        // step 1
        Rectangle rect = new Rectangle(PageSize.A4);// 设置页面大小
        rect.setBackgroundColor(BaseColor.WHITE);// 页面背景色
        Document document = new Document(rect);// 创建一个Document
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdfdemo2.pdf"));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream("src/main/resources/contract-new.html"), Charset.forName("UTF-8"));
        //step 5


        Image jpeg = Image.getInstance("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\hhz-beijing.png");
        jpeg.setAlignment(Image.ALIGN_UNDEFINED);
        jpeg.scalePercent(90f);
        System.out.println(document.bottom());
        document.getPageSize();
//        document.add(jpeg);
        document.close();
        System.out.println("PDF Created!");
    }

    public static void find() throws Exception {
        // 模板文件路径
        String templatePath = "pdfdemo2.pdf";
        // 生成的文件路径
        String targetPath = "target.pdf";
        // 书签名
        String fieldName = "角色名称定义：";
        // 图片路径
        String imagePath = "image.jpg";

        // 读取模板文件
        InputStream input = new FileInputStream(new File(templatePath));
        PdfReader reader = new PdfReader(input);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(targetPath));
        // 提取pdf中的表单
        AcroFields form = stamper.getAcroFields();
        form.addSubstitutionFont(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));

        // 通过域名获取所在页和坐标，左下角为起点
        int pageNo = form.getFieldPositions(fieldName).get(0).page;
        Rectangle signRect = form.getFieldPositions(fieldName).get(0).position;
        float x = signRect.getLeft();
        float y = signRect.getBottom();

        // 读图片
        Image image = Image.getInstance("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\hhz-beijing.png");
        // 获取操作的页面
        PdfContentByte under = stamper.getOverContent(pageNo);
        // 根据域的大小缩放图片
        image.scaleToFit(signRect.getWidth(), signRect.getHeight());
        // 添加图片
        image.setAbsolutePosition(x, y);
        under.addImage(image);

        stamper.close();
        reader.close();
    }
}
