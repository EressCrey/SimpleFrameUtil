package view;

import util.AESCBCUtil;

public class AESCBCPanel extends AbstractCryptoPanel {
    protected String encrypt(String input, String key) {
        String s;
        try {
            s = AESCBCUtil.encryptAES(input, key);
        } catch (Exception e) {
            s = "加密出现错误" + e.getMessage();
        }
        return s;
    }

    protected String decrypt(String input, String key) {
        String s;
        try {
            s = AESCBCUtil.decryptAES(input, key);
        } catch (Exception e) {
            s = "解密出现错误" + e.getMessage();
        }
        return s;
    }
}
