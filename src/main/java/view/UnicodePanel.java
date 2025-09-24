package view;

import util.UnicodeUtil;

public class UnicodePanel extends AbstractSimpleCryptoPanel {

    public UnicodePanel() {
        super("Unicode 编码", "Unicode 解码");
    }

    @Override
    protected String encode(String input) {
        return UnicodeUtil.encodeToUnicode(input);
    }

    @Override
    protected String decode(String input) {
        return UnicodeUtil.decodeFromUnicode(input);
    }
}
