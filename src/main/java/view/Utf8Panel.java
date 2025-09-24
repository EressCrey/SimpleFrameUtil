package view;

import util.Utf8Util;

public class Utf8Panel extends AbstractSimpleCryptoPanel {

    public Utf8Panel() {
        super("UTF-8 编码", "UTF-8 解码");
    }

    @Override
    protected String encode(String input) {
        return Utf8Util.encodeToUtf8(input);
    }

    @Override
    protected String decode(String input) {
        return Utf8Util.decodeFromUtf8(input);
    }
}
