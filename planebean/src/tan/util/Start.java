package tan.util;

import java.awt.*;

public class Start {
    public int count = 0;

    public void drawStart(Graphics g, MyCanvas myCanvas) {
        g.setColor(Color.white);
        g.fillRoundRect(400, 500, count, 20, 15, 15);
        g.setColor(Color.orange);
        Font f = new Font("", Font.BOLD, 20);
        g.setFont(f);
        g.drawRoundRect(399, 499, 202, 22, 15, 15);
        count += 10;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
