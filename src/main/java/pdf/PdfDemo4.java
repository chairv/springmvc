package pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
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
        FileInputStream fin = new FileInputStream("D:\\Workspaces\\springmvc5\\src\\main\\resources\\view_test-cp.html");
        Document document = new Document();
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
                            if (e instanceof Paragraph) {
                                Chunk chunk = ((Paragraph)e).getChunks().get(0);
                                HashMap attrs = chunk.getAttributes();
                                if (attrs.containsKey("IMAGE")) {
                                    Image image = Image.getInstance("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\hhz-beijing.png");
                                     image.setAbsolutePosition(110,document.getPageSize().getHeight()-250);
                                    document.add(image);
                                    continue;
                                }
                            }
                            document.add(e);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }, fin, Charset.defaultCharset());
        document.close();
        IOUtils.closeQuietly(fin);
        System.out.println("over");
    }
}
