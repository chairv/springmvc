package com.itextpdf.tool.xml.html;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.BaseFont;

/**
 * @author redlab_b
 */
public class HTMLUtils {
    public static BaseFont bfCN = null;

    static {
        try {
            bfCN = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
        }
    }

    private static final boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static final boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param str                the string to sanitize
     * @param preserveWhiteSpace to trim or not to trim
     * @return sanitized string
     */
    private static List<Chunk> sanitize(final String str, final boolean preserveWhiteSpace, final boolean replaceNonBreakableSpaces) {
        StringBuilder builder = new StringBuilder();
        StringBuilder whitespaceBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        ArrayList<Chunk> chunkList = new ArrayList<Chunk>();
        boolean isWhitespace = chars.length > 0 ? Character.isWhitespace(chars[0]) : true;
        for (char c : chars) {
            if (isWhitespace && !Character.isWhitespace(c)) {
                if (builder.length() == 0) {
                    chunkList.add(Chunk.createWhitespace(builder.toString(), preserveWhiteSpace));
                } else {
                    builder.append(" ");
                }
                whitespaceBuilder = new StringBuilder();
            }

            isWhitespace = Character.isWhitespace(c);
            if (isWhitespace) {
                whitespaceBuilder.append(c);
            } else {
                builder.append(c);
            }
        }

        if (builder.length() > 0) {
            chunkList.add(new Chunk(replaceNonBreakableSpaces ? builder.toString().replace(Character.valueOf('\u00a0'), Character.valueOf(' ')) : builder.toString()));
        }

        if (whitespaceBuilder.length() > 0) {
            chunkList.add(Chunk.createWhitespace(whitespaceBuilder.toString(), preserveWhiteSpace));
        }

        return chunkList;
    }

    public static List<Chunk> sanitize(final String str, final boolean preserveWhiteSpace) {
        return sanitize(str, preserveWhiteSpace, false);
    }

    /**
     * Sanitize the String for use in in-line tags.
     *
     * @param str the string to sanitize
     * @return a sanitized String for use in in-line tags
     */
    public static List<Chunk> sanitizeInline(final String str, final boolean preserveWhiteSpace) {
        return sanitize(str, preserveWhiteSpace, false);
    }

    public static List<Chunk> sanitizeInline(final String str, final boolean preserveWhiteSpace, final boolean replaceNonBreakableSpaces) {
        return sanitize(str, preserveWhiteSpace, replaceNonBreakableSpaces);
    }
}
