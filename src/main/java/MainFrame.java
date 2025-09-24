import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("工具");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建标签页
        JTabbedPane tabbedPane = new JTabbedPane();

        // 创建加解密标签页
        JPanel cryptoPanel = new AESCBCPanel();
        tabbedPane.addTab("AES加解密", cryptoPanel);

        // 创建Md5加密标签页
        JPanel md5Panel = new Md5Panel();
        tabbedPane.addTab("Md5加密", md5Panel);

        // 创建解压加压标签页
        JPanel compressionPanel = new GzipCompressionPanel();
        tabbedPane.addTab("Gzip解加压", compressionPanel);

        // 创建Base64编解码标签页
        JPanel base64Panel = new Base64Panel();
        tabbedPane.addTab("Base64编解码", base64Panel);

        // 创建jwt编解码标签页
        JPanel jwtPanel = new JwtPanel();
        tabbedPane.addTab("Jwt编解码", jwtPanel);

        // 创建ASCII编解码标签页
        JPanel asciiPanel = new AsciiPanel();
        tabbedPane.addTab("ASCII编解码", asciiPanel);

        // 创建unicode编解码标签页
        JPanel unicodePanel = new UnicodePanel();
        tabbedPane.addTab("Unicode编解码", unicodePanel);

        // 创建utf8编解码标签页
        JPanel utf8Panel = new Utf8Panel();
        tabbedPane.addTab("UTF-8编解码", utf8Panel);

        // 创建url编解码标签页
        JPanel urlPanel = new UrlPanel();
        tabbedPane.addTab("URL编解码", urlPanel);

        add(tabbedPane);

        // 监听窗口大小变化以调整字体大小
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustFontSize(tabbedPane);
            }
        });

        setVisible(true);
    }


    private void adjustFontSize(JComponent component) {
        int newSize = Math.max(12, (int) (getHeight() / 30.0));
        component.setFont(new Font("微软雅黑", Font.PLAIN, newSize));

        // 遍历子组件，递归设置字体大小
        for (Component child : component.getComponents()) {
            if (child instanceof JComponent) {
                adjustFontSize((JComponent) child);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
