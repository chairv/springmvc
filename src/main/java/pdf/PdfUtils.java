package pdf;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Created by tancw on 2017/6/5.
 */
public class PdfUtils {

    //将html转成pdf流
    public static byte[] html2Stream(String message)  {
        Rectangle rect = new Rectangle(PageSize.A4);// 设置页面大小
        rect.setBackgroundColor(BaseColor.WHITE);// 页面背景色
        final Document document = new Document(rect);// 创建一个Document
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, os);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(message));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(os);
        }
        document.close();
        return os.toByteArray();
    }

    //获取关键字坐标
    public static float[] getLocation(PdfReader reader, String word) throws Exception {
        final float[] result = new float[3];
        int pageNum = reader.getNumberOfPages();
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        for (int i = 1; i <= pageNum; i++) {
            final int page = i;
            parser.processContent(page, new RenderListener() {
                @Override
                public void beginTextBlock() {

                }

                @Override
                public void renderText(TextRenderInfo renderInfo) {
                    String text = renderInfo.getText();
                    System.out.println(text);
                    if (text != null && text.contains(word)) {
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
                public void renderImage(ImageRenderInfo imageRenderInfo) {

                }
            });

        }
        return result;
    }
}
