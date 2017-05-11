package pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Created by tancw on 2017/5/8.
 */
public class PdfDemo {
    public static void main(String[] args) throws IOException, DocumentException, DocumentException {

        String fileName = "test.pdf";
        Rectangle rect = new Rectangle(PageSize.A4);// 设置页面大小
        rect.setBackgroundColor(BaseColor.WHITE);// 页面背景色
        Document document = new Document(rect);// 创建一个Document
        FileOutputStream fileOutputStream  = new FileOutputStream(new File(fileName));
        // 页边空白
        document.setMargins(10, 20, 30, 40); // 左，右，上，下
        PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);// 创建书写器(Writer) 与  document对象关联，通过书写器可以将文档写入磁盘中
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);// 设置PDF版本（默认1.4）
        // 文档属性
        document.addTitle("Title@sample"); // 标题
        document.addAuthor("Author@nicaisheng");// 作者
        document.addSubject("Subject@iText sample");// 主题
        document.addKeywords("Keywords@iText");// 关键字
        document.addCreator("Creator@iText");// 创建者



        //设置字体
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 8, Font.NORMAL);// 创建字体，设置family，size，style,还可以设置color
        Font titleChinese = new Font(bfChinese, 20, Font.BOLD);
        Font BoldChinese = new Font(bfChinese, 14, Font.BOLD);
        Font subBoldFontChinese = new Font(bfChinese, 8, Font.BOLD);

        document.open();// 打开文档
        Paragraph title = new Paragraph("专家信息", titleChinese);// 设置标题
        title.setAlignment(Element.ALIGN_CENTER);// 设置对齐方式
        title.setLeading(1f);// 设置行间距
        document.add(title);

        float[] widths = {25f, 30f, 30f,25f,25f,25f };// 设置表格的列宽和列数 默认是4列
        PdfPTable table = new PdfPTable(widths);// 建立一个pdf表格
        table.setSpacingBefore(20f);
        table.setWidthPercentage(100);// 设置表格宽度为100%

        PdfPCell cell = null;
        cell = new PdfPCell(new Paragraph("姓名",subBoldFontChinese));//
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("张大",fontChinese));//
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("性别",subBoldFontChinese));//
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("123",fontChinese));//
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("身份证号",subBoldFontChinese));//
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("123",fontChinese));//
        table.addCell(cell);

        document.add(table);
        document.close();
    }
}
