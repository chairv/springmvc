package pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Created by tancw on 2017/5/19.
 */
public class PdfDemo3 {
    public static void main(String[] args) throws IOException, DocumentException {
        FileInputStream fin = new FileInputStream("D:\\Workspaces\\springmvc5\\src\\main\\resources\\contract-new.html");
        Rectangle pageSize = PageSize.A4.rotate();
        Document document = new Document(pageSize);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdfdemo3"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, fin);
        Image image = Image.getInstance("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\hhz-beijing.png");
        image.scaleToFit(770, 523);
        float offsetX = (770 - image.getScaledWidth()) / 2;
        float offsetY = (523 - image.getScaledHeight()) / 2;
        image.setAbsolutePosition(36 + offsetX, 36 + offsetY);
        document.add(image);
        document.close();
        IOUtils.closeQuietly(fin);
        System.out.println("over");
    }
}
