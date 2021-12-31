package tan.util;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        loadFrame();
    }

    public void loadFrame() {
        //设置大小
        this.setSize(1000, 750);
        //设置关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置不可变大小
        this.setResizable(false);
        //设置窗口打开时屏蔽输入法
        this.enableInputMethods(false);
        //设置显示要放在最后
        this.setVisible(true);
    }
}
