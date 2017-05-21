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
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPages;
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
        FileInputStream fin = new FileInputStream("D:\\workspace2017\\springmvc\\src\\main\\resources\\view_test.html");
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

                            if (e instanceof PdfPages) {
                                System.out.println("page");
                            }
                            if (e instanceof Paragraph) {
                                System.out.println("Paragraph");
                                e = (Paragraph) e;
//                                if (StringUtils.equals("zhang", ((Paragraph) e).getContent())) {
//                                    Image image = Image.getInstance("D:\\workspace2017\\springmvc\\src\\main\\resources\\logo2.png");
//                                    document.add(image);
//                                }
                            }
                            if (e instanceof Chunk) {
                                HashMap atts = ((Chunk) e).getAttributes();
                                if (atts.keySet().contains("IMAGE")) {
//                                    Image image = Image.getInstance("D:\\workspace2017\\springmvc\\src\\main\\resources\\logo2.png");
//                                    document.add(image);
//                                    continue;
                                    ImgRaw row = (ImgRaw) atts.get("IMAGE");
                                    row.setAbsolutePosition(20,20);
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
