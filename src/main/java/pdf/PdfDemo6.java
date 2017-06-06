package pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Created by tancw on 2017/6/5.
 */
public class PdfDemo6 {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("D:\\Workspaces\\springmvc5\\src\\main\\resources\\contract-new.html");
        Rectangle pageSize = PageSize.A4;
        Document document = new Document(pageSize);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, os);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, fin);
        document.close();
        IOUtils.closeQuietly(fin);
        System.out.println("over");
        PdfReader reader = new PdfReader(os.toByteArray());
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("pdfdemo5.pdf"));


        PdfContentByte over =  stamper.getOverContent(0);
//        int pageNo = form.getFieldPositions("签署并生效日期").get(0).page;
//        Rectangle signRect = form.getFieldPositions("签署并生效日期").get(0).position;
//        float x = signRect.getLeft();
//        float y = signRect.getBottom();
//        Image image = Image.getInstance("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\hhz-beijing.png");
//        image.setAlignment(Image.ALIGN_UNDEFINED);
//        image.scalePercent(90f);
//        image.setAbsolutePosition(x, y);
//        PdfContentByte over = stamper.getOverContent(pageNo);
//        over.addImage(image);
//        stamper.close();
        reader.close();
    }
}
