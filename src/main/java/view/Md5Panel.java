package view;


import javax.swing.*;
import java.awt.*;

import static util.Md5Util.md5;

public class Md5Panel  extends JPanel {

    public Md5Panel(){
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

        JButton md5EncryptBtn = new JButton("加密");
        // 添加按钮到面板
        JPanel btnPanel = new JPanel();
        btnPanel.add(md5EncryptBtn);

        add(btnPanel, BorderLayout.SOUTH);

        // 按钮事件处理
        md5EncryptBtn.addActionListener(e -> {
            String input = inputArea.getText();
            String encrypted;
            try {
                encrypted = encrypt(input);
            } catch (Exception ex) {
                encrypted = "压缩出现错误" + ex.getMessage();
            }
            outputArea.setText(encrypted);
        });

    }

    protected String encrypt(String input) {
        try {
            return md5(input);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
