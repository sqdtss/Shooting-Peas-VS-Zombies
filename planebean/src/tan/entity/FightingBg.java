package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;

import java.awt.*;

/**
 * 背景类
 */
public class FightingBg extends EntityObject {

    public Image img;

    public FightingBg(int x, int y, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        img = (Image) ImageUtil.imgMap.get("fightingBg");
    }

    @Override
    public void move() {
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(img, x, y, null);
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }
}
