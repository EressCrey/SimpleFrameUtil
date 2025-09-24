package util;

public class UnicodeUtil {

    /**
     * 将字符串编码为 Unicode 形式，如 "你好" -> "\u4f60\u597d"
     */
    public static String encodeToUnicode(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append("\\u").append(String.format("%04x", (int) c));
        }
        return sb.toString();
    }

    /**
     * 将 Unicode 编码字符串解码回普通字符串
     * 如 "\u4f60\u597d" -> "你好"
     */
    public static String decodeFromUnicode(String unicodeText) {
        if (unicodeText == null || unicodeText.trim().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] parts = unicodeText.split("\\\\u"); // 两个反斜杠用于转义

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int codePoint = Integer.parseInt(part.trim(), 16);
            sb.append((char) codePoint);
        }
        return sb.toString();
    }
}
