package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;

import java.awt.*;

public class Boss extends EntityObject {
    public int hp = 100000 * 2;
    public Image[] imgs;
    public int index = 0;

    public Boss(int x, int y, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        imgs = new Image[]{
                (Image) ImageUtil.imgMap.get("boss01"),
                (Image) ImageUtil.imgMap.get("boss02"),
                (Image) ImageUtil.imgMap.get("boss03"),
                (Image) ImageUtil.imgMap.get("boss04"),
                (Image) ImageUtil.imgMap.get("boss05"),
                (Image) ImageUtil.imgMap.get("boss06"),
                (Image) ImageUtil.imgMap.get("boss07"),
                (Image) ImageUtil.imgMap.get("boss08"),
                (Image) ImageUtil.imgMap.get("boss09"),
                (Image) ImageUtil.imgMap.get("boss10"),
                (Image) ImageUtil.imgMap.get("boss11"),
        };
    }

    @Override
    public void move() {
        x -= speed;
        outOfBounds();
    }

    public void outOfBounds() {
        if (x < (0 - imgs[0].getWidth(null))) {
            canvas.bossList.remove(this);
        }
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(imgs[index++], x, y, null);
        if (index == 11) {
            index = 0;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, imgs[11].getWidth(null), imgs[11].getHeight(null));
    }
}
