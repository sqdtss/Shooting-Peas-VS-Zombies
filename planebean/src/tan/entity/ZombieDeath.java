package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;

import java.awt.*;

public class ZombieDeath extends EntityObject {


    // 爆炸效果结束标志
    public Boolean useful = true;
    private final Image[] imgs;
    // 当前显示图片位置
    private int index = 0;

    public ZombieDeath(int x, int y, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        imgs = new Image[]{
                (Image) ImageUtil.imgMap.get("zombieDeath01"),
                (Image) ImageUtil.imgMap.get("zombieDeath02"),
                (Image) ImageUtil.imgMap.get("zombieDeath03"),
                (Image) ImageUtil.imgMap.get("zombieDeath04"),
                (Image) ImageUtil.imgMap.get("zombieDeath05")
        };
    }

    @Override
    public void move() {
    }

    /**
     * 绘制死亡图片
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(imgs[index++], x, y, null);
        if (index == 5) {
            useful = false;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, imgs[index].getWidth(null), imgs[index].getHeight(null));
    }
}
