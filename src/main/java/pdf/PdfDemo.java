package pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

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
        File input = new File("src/main/resources/contract-one.txt");
        System.out.println(input.exists());
        org.jsoup.nodes.Document doc = Jsoup.parse(input, "UTF-8", "D:\\Workspaces\\springmvc5\\src\\main\\webapp");
        org.jsoup.nodes.Element body = doc.body();
        String title = doc.title();
        System.out.println(title);

        String fileName = "test.pdf";
        Rectangle rect = new Rectangle(PageSize.A4);// 设置页面大小
        rect.setBackgroundColor(BaseColor.WHITE);// 页面背景色
        Document document = new Document(rect);// 创建一个Document
        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
//        // 页边空白
//        document.setMargins(10, 20, 30, 40); // 左，右，上，下
        PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);// 创建书写器(Writer) 与  document对象关联，通过书写器可以将文档写入磁盘中
//        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);// 设置PDF版本（默认1.4）
//        // 文档属性
//        document.addTitle("Title@sample"); // 标题
//        document.addAuthor("Author@nicaisheng");// 作者
//        document.addSubject("Subject@iText sample");// 主题
//        document.addKeywords("Keywords@iText");// 关键字
//        document.addCreator("Creator@iText");// 创建者
//
//
//
//        //设置字体
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font n5 = new Font(bfChinese, 14, Font.NORMAL);// 创建字体，设置family，size，style,还可以设置color
        Font h3 = new Font(bfChinese, 17, Font.BOLD);
        Font h5 = new Font(bfChinese, 14, Font.BOLD);
        Font h7 = new Font(bfChinese, 8, Font.BOLD);
//
        document.open();// 打开文档
        Paragraph pdfTitle = new Paragraph(title, h3);// 设置标题
        pdfTitle.setAlignment(Element.ALIGN_CENTER);// 设置对齐方式
        pdfTitle.setLeading(1f);// 设置行间距
        document.add(pdfTitle);
//

        Elements divs = doc.select("div");

        for (org.jsoup.nodes.Element div : divs) {
            Element ediv = parse(div);
            if (ediv != null) document.add(ediv);
        }
//        org.jsoup.nodes.Element table = body.getElementById("tableone");
//        org.jsoup.nodes.Element thead = body.getElementById("thead");
//        org.jsoup.nodes.Element tbody = body.getElementById("tbody");
//        org.jsoup.select.Elements ths = thead.getElementsByTag("th");
//
//       float[] widths = new float[ths.size()];
//        for(int i = 0; i < ths.size(); i++){
//            widths[i] = 100/ths.size();
//        }
//        PdfPTable pdfTable = new PdfPTable(widths);
//        pdfTable.setSpacingBefore(20f);
//        pdfTable.setWidthPercentage(60);
//
//        //head
//        org.jsoup.select.Elements headTrs = thead.getElementsByTag("tr");
//        for (org.jsoup.nodes.Element e : headTrs.select("th")) {
//            System.out.println(e.text());
//            PdfPCell cell = new PdfPCell(new Paragraph(e.text(), h5));
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            pdfTable.addCell(cell);
//        }
//
//        org.jsoup.select.Elements tbTrs = tbody.getElementsByTag("tr");
//        for (org.jsoup.nodes.Element e : tbTrs.select("td")) {
//            System.out.println(e.text());
//            PdfPCell cell = new PdfPCell(new Paragraph(e.text(), n5));
//            cell.setBackgroundColor(BaseColor.WHITE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            pdfTable.addCell(cell);
//        }


//        float[] widths = {25f, 30f, 30f,25f,25f,25f };// 设置表格的列宽和列数 默认是4列
//        PdfPTable table = new PdfPTable(widths);// 建立一个pdf表格
//        table.setSpacingBefore(20f);
//        table.setWidthPercentage(100);// 设置表格宽度为100%
//
//        PdfPCell cell = null;
//        cell = new PdfPCell(new Paragraph("姓名",subBoldFontChinese));//
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("张大",fontChinese));//
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("性别",subBoldFontChinese));//
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("123",fontChinese));//
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("身份证号",subBoldFontChinese));//
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("123",fontChinese));//
//        table.addCell(cell);
//
//        document.add(pdfTable);
        document.close();
    }

    private static Element parse(org.jsoup.nodes.Element div) throws IOException, DocumentException {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font n5 = new Font(bfChinese, 14, Font.NORMAL);
        Font h5 = new Font(bfChinese, 14, Font.BOLD);

        if (div.hasClass("content")) {
            return new Paragraph(div.text(), n5);
        } else if (div.hasClass("table")) {
            Elements els = div.select("tr");
            PdfPTable table = new PdfPTable(getWidth(els.get(0)));
            for (org.jsoup.nodes.Element el : els.select("th")) {
                PdfPCell cell = new PdfPCell(new Paragraph(el.text(), h5));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            for (org.jsoup.nodes.Element el : els.select("td")) {
                PdfPCell cell = new PdfPCell(new Paragraph(el.text(), h5));
                cell.setBackgroundColor(BaseColor.WHITE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            return table;
        }
        return null;
    }

    private static float[] getWidth(org.jsoup.nodes.Element thead) {
        Elements ths = thead.select("th");
        float[] widthes = new float[ths.size()];
        for (int i = 0, len = ths.size(); i < len; i++) {
            float width = 0;
            String widthAttr = ths.get(i).attr("width");
            if (StringUtils.isBlank(widthAttr)) {
                width = 100 / ths.size();
            } else {
                width = Float.valueOf(widthAttr);
            }
            widthes[i] = width;
        }
        return widthes;
    }


}
