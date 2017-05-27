package pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementHandler;
import com.itextpdf.tool.xml.Writable;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.pipeline.WritableElement;

/**
 * Created by qiao on 2017/5/21.
 */
public class PdfDemo4 {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("D:\\Workspaces\\springmvc5\\src\\main\\resources\\contract-new.html");
        Document document = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("pdfdemo04.pdf"));
        writer.setInitialLeading(12.5f);
        document.open();

        XMLWorkerHelper.getInstance().parseXHtml(new ElementHandler() {
            @Override
            public void add(Writable w) {
                if (w instanceof WritableElement) {
                    List<Element> elements = ((WritableElement) w).elements();
                    for (Element e : elements) {
                        try {
                            document.add(e);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }, fin, Charset.defaultCharset());
        System.out.println(writer.getPageNumber());
        document.close();
        IOUtils.closeQuietly(fin);
        System.out.println("over");
    }
}
