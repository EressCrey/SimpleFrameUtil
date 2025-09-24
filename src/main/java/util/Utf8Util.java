package util;

import java.nio.charset.StandardCharsets;

public class Utf8Util {

    /**
     * 将字符串转换为 UTF-8 十六进制表示
     * 例如 "ABC" -> "41 42 43"
     */
    public static String encodeToUtf8(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b)).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 将 UTF-8 十六进制字符串转换回普通字符串
     * 例如 "41 42 43" -> "ABC"
     */
    public static String decodeFromUtf8(String hexText) {
        if (hexText == null || hexText.trim().isEmpty()) {
            return "";
        }
        String[] parts = hexText.trim().split("\\s+");
        byte[] bytes = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            bytes[i] = (byte) Integer.parseInt(parts[i], 16);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
