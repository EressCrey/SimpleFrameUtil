package view;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractCryptoPanel extends JPanel {

    public AbstractCryptoPanel() {
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

        // 单行输入框
        JPanel field = new JPanel();
        JTextField keyField = new JTextField("", 40);
        field.add(keyField);

        // 创建按钮
        JButton encryptButton = new JButton("加密");
        JButton decryptButton = new JButton("解密");
        // 添加按钮到面板
        JPanel btnPanel = new JPanel();
        btnPanel.add(encryptButton);
        btnPanel.add(decryptButton);

        //整合输入框与按钮
        JPanel fieldAndButton = new JPanel();
        fieldAndButton.setLayout(new BorderLayout());
        fieldAndButton.add(keyField, BorderLayout.WEST);
        fieldAndButton.add(btnPanel, BorderLayout.EAST);

        add(fieldAndButton, BorderLayout.SOUTH);

        // 按钮事件处理
        encryptButton.addActionListener(e -> {
            String input = inputArea.getText();
            String key = keyField.getText();
            // 这里添加加密逻辑
            String encrypted = encrypt(input, key);
            outputArea.setText(encrypted);
        });

        decryptButton.addActionListener(e -> {
            String input = inputArea.getText();
            String key = keyField.getText();
            // 这里添加解密逻辑
            String decrypted = decrypt(input, key);
            outputArea.setText(decrypted);
        });

    }

    protected abstract String decrypt(String input, String key);

    protected abstract String encrypt(String input, String key);

}
