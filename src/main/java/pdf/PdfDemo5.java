package pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.tool.xml.XMLWorkerHelper;


/**
 * Created by tancw on 2017/5/23.
 */
public class PdfDemo5 {
    public static void main(String[] args) throws IOException, DocumentException {
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
        float[] keyflag = getKeyWords(reader,"盖章");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("pdfdemo5.pdf"));
        Image image = Image.getInstance("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\hhz-beijing.png");
        image.setAbsolutePosition(keyflag[0]+ 36, keyflag[1] + 36);
        PdfContentByte over = stamper.getOverContent((int)keyflag[2]);
        over.addImage(image);
        stamper.close();
        reader.close();
    }


    public static float[] getKeyWords(PdfReader reader, String key) throws IOException {
        float[] result = new float[3];
        int pageNum = reader.getNumberOfPages();
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        for (int i = 1; i < pageNum; i++) {
            final int page = i;
            parser.processContent(page, new RenderListener() {
                @Override
                public void beginTextBlock() {

                }

                @Override
                public void renderText(TextRenderInfo renderInfo) {
                    String text = renderInfo.getText();
                    System.out.println(text);
                    if (text != null && text.contains(key)) {
                        Rectangle2D.Float boundingRectange = renderInfo.getBaseline().getBoundingRectange();
                        result[0] = boundingRectange.x;
                        result[1] = boundingRectange.y;
                        result[2] = page;
                    }
                }

                @Override
                public void endTextBlock() {

                }

                @Override
                public void renderImage(ImageRenderInfo renderInfo) {

                }
            });

        }
        return result;
    }

}
