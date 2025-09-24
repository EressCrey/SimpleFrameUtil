package view;

import util.GzipUtil;

import javax.swing.*;
import java.awt.*;

public class GzipCompressionPanel extends AbstractSimpleCryptoPanel {

    public GzipCompressionPanel(){
        super("加压", "解压");
    }

    @Override
    protected String encode(String input) throws Exception {
        return GzipUtil.compress(input);
    }

    @Override
    protected String decode(String input) throws Exception {
        return GzipUtil.unCompress(input);
    }
}
