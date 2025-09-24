package util;

public class AsciiUtil {

    /**
     * 将字符串转换为 ASCII 编码（以空格分隔）
     * 例如: "ABC" -> "65 66 67"
     */
    public static String encodeToAscii(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((int) c).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 将 ASCII 编码转换为字符串
     * 例如: "65 66 67" -> "ABC"
     */
    public static String decodeFromAscii(String asciiText) {
        if (asciiText == null || asciiText.trim().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] parts = asciiText.trim().split("\\s+");
        for (String part : parts) {
            int code = Integer.parseInt(part);
            sb.append((char) code);
        }
        return sb.toString();
    }
}
