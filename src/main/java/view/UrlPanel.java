package view;

import util.UrlCodecUtil;

import javax.swing.*;
import java.awt.*;

public class UrlPanel extends JPanel {

    public UrlPanel() {
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

        // 按钮和字符集选择
        JButton encodeButton = new JButton("URL 编码");
        JButton decodeButton = new JButton("URL 解码");

        JComboBox<String> charsetCombo = new JComboBox<>(new String[]{"UTF-8", "GB2312"});
        charsetCombo.setSelectedItem("UTF-8");

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("字符集:"));
        bottomPanel.add(charsetCombo);
        bottomPanel.add(encodeButton);
        bottomPanel.add(decodeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 按钮事件
        encodeButton.addActionListener(e -> {
            String input = inputArea.getText();
            String charset = (String) charsetCombo.getSelectedItem();
            try {
                outputArea.setText(UrlCodecUtil.encode(input, charset));
            } catch (Exception ex) {
                outputArea.setText("编码失败: " + ex.getMessage());
            }
        });

        decodeButton.addActionListener(e -> {
            String input = inputArea.getText();
            String charset = (String) charsetCombo.getSelectedItem();
            try {
                outputArea.setText(UrlCodecUtil.decode(input, charset));
            } catch (Exception ex) {
                outputArea.setText("解码失败: " + ex.getMessage());
            }
        });
    }
}
