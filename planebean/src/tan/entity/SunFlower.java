package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;

import java.awt.*;

public class SunFlower extends EntityObject {

    public Image[] images;

    public SunFlower(int x, int y, int speed, MyCanvas myCanvas) {
        super(x, y, speed, myCanvas);
        images = new Image[]{
                (Image) ImageUtil.imgMap.get("sunFlower"),
                (Image) ImageUtil.imgMap.get("win"),
        };
    }

    @Override
    public void move() {
        y -= speed;
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(images[0], x, y, null);
        if (canvas.sunFlowers.size() >= 70) {
            g.drawImage(images[1], 350, 150, null);
        }
        g.setColor(Color.black);
        g.setFont(new Font("幼圆", Font.BOLD, 30));
        g.drawString("游戏结束，按R重新开始", 330, 650);
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

}
