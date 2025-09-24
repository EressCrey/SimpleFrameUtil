package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlCodecUtil {

    /**
     * URL 编码
     */
    public static String encode(String text, String charset) throws UnsupportedEncodingException {
        if (text == null || text.isEmpty()) return "";
        return URLEncoder.encode(text, charset);
    }

    /**
     * URL 解码
     */
    public static String decode(String text, String charset) throws UnsupportedEncodingException {
        if (text == null || text.isEmpty()) return "";
        return URLDecoder.decode(text, charset);
    }
}
