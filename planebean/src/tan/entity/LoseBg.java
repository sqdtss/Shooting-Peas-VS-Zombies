package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;

import java.awt.*;

public class LoseBg extends EntityObject {

    public Image[] images;

    public LoseBg(int x, int y, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);

        images = new Image[]{
                (Image) ImageUtil.imgMap.get("badbg01"),
                (Image) ImageUtil.imgMap.get("badbg02")
        };
    }

    @Override
    public void move() {
        if (y > 0) {
            y -= speed * 2;
        }
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(images[1], x, y, 1000, 750, null);
        g.setColor(Color.white);
        g.setFont(new Font("幼圆", Font.BOLD, 30));
        g.drawString("游戏结束，按R重新开始", 330, 650);
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }
}
