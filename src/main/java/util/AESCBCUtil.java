package util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AESCBCUtil {

    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * AES加密 并进行 BASE64 转码
     *
     * @param data 待加密字符串
     * @param key  密钥
     * @return
     */
    public static String encryptAES(String data, String key) throws Exception {
        //初始化长度为 16 的空字节数组
        byte[] srcIv = new byte[16];
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(srcIv);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), iv);
        byte[] result = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return (new BASE64Encoder()).encodeBuffer(result);
    }

    /**
     * AES 解密
     *
     * @param data 需解密的参数
     * @param key  密钥
     * @return
     * @throws Exception
     */
    public static String decryptAES(String data, String key) throws Exception {
        // 初始化长度为 16 的空字节数组
        byte[] srcIv = new byte[16];
        SecretKeySpec secks = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secks, new IvParameterSpec(srcIv));
        // 先用base64 转码
        byte[] decrypted = (new BASE64Decoder()).decodeBuffer(data);
        byte[] dec = cipher.doFinal(decrypted);
        String result = new String(dec);
        String res = new String(result.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        return res;
    }
}
