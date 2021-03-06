package pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;


/**
 * Created by tancw on 2017/5/23.
 */
public class PdfDemo5 {
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
        float[] keyflag = PdfUtils.getLocation(reader,"丙方盖章");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("pdfdemo5.pdf"));
        Image image = Image.getInstance("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\hhz-beijing.png");
        image.setAlignment(Image.ALIGN_UNDEFINED);
        image.scalePercent(90f);
        image.setAbsolutePosition(keyflag[0]+36, keyflag[1] - 36);
        PdfContentByte over = stamper.getOverContent((int)keyflag[2]);
        over.addImage(image);
        stamper.close();
        reader.close();
    }


}
