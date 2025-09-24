package view;

import javax.swing.*;
import java.awt.*;

/**
 * 不需要输入密钥的窗体
 */
public abstract class AbstractSimpleCryptoPanel extends JPanel {

    public AbstractSimpleCryptoPanel(String encodeBtnText, String decodeBtnText) {
        setLayout(new BorderLayout());

        // 输入框
        JTextArea inputArea = new JTextArea(10, 30);
        JScrollPane inputScroll = new JScrollPane(inputArea);
        add(inputScroll, BorderLayout.NORTH);

        // 输出框
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        add(outputScroll, BorderLayout.CENTER);

        // 按钮
        JButton encodeButton = new JButton(encodeBtnText);
        JButton decodeButton = new JButton(decodeBtnText);

        JPanel btnPanel = new JPanel();
        btnPanel.add(encodeButton);
        btnPanel.add(decodeButton);

        add(btnPanel, BorderLayout.SOUTH);

        // 事件绑定
        encodeButton.addActionListener(e -> {
            String input = inputArea.getText();
            try {
                String encoded = encode(input);
                outputArea.setText(encoded);
            } catch (Exception ex) {
                outputArea.setText("出现错误: " + ex.getMessage());
            }
        });

        decodeButton.addActionListener(e -> {
            String input = inputArea.getText();
            try {
                String decoded = decode(input);
                outputArea.setText(decoded);
            } catch (Exception ex) {
                outputArea.setText("出现错误: " + ex.getMessage());
            }
        });
    }

    // 子类实现具体的编码/解码逻辑
    protected abstract String encode(String input) throws Exception;

    protected abstract String decode(String input) throws Exception;
}
