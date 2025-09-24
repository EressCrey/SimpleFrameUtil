package util;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    /**
     * 将字符串进行 Base64 编码
     * @param input 需要编码的字符串
     * @return 编码后的 Base64 字符串
     */
    public static String encode(String input) {
        if (input == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 将 Base64 编码的字符串进行解码
     * @param base64Str Base64 编码的字符串
     * @return 解码后的字符串
     */
    public static String decode(String base64Str) {
        if (base64Str == null) {
            return null;
        }
        byte[] decodedBytes = Base64.getDecoder().decode(base64Str);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    /**
     * 将字节数组进行 Base64 编码
     * @param bytes 需要编码的字节数组
     * @return 编码后的 Base64 字符串
     */
    public static String encode(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 将 Base64 编码的字符串解码为字节数组
     * @param base64Str Base64 编码的字符串
     * @return 解码后的字节数组
     */
    public static byte[] decodeToBytes(String base64Str) {
        if (base64Str == null) {
            return null;
        }
        return Base64.getDecoder().decode(base64Str);
    }
}
