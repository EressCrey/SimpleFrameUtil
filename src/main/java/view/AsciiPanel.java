package view;

import util.AsciiUtil;

public class AsciiPanel extends AbstractSimpleCryptoPanel {

    public AsciiPanel() {
        super("ASCII加密", "ASCII解密");
    }

    @Override
    protected String encode(String input) {
        return AsciiUtil.encodeToAscii(input);
    }

    @Override
    protected String decode(String input) {
        return AsciiUtil.decodeFromAscii(input);
    }
}
