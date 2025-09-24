package view;

import util.Base64Utils;

public class Base64Panel extends AbstractSimpleCryptoPanel {

    public Base64Panel() {
        super("base64加密", "base64解密");
    }

    @Override
    protected String encode(String input) {
        return Base64Utils.encode(input);
    }

    @Override
    protected String decode(String input) {
        return Base64Utils.decode(input);
    }
}
