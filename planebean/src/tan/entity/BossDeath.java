package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;

import java.awt.*;

// 最后一种僵尸爆炸类
public class BossDeath extends EntityObject {
    private final Image[] imgs;
    private int index = 0;

    public BossDeath(int x, int y, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        imgs = new Image[]{
                (Image) ImageUtil.imgMap.get("bossDeath01"),
                (Image) ImageUtil.imgMap.get("bossDeath02"),
                (Image) ImageUtil.imgMap.get("bossDeath03"),
                (Image) ImageUtil.imgMap.get("bossDeath04"),
                (Image) ImageUtil.imgMap.get("bossDeath05"),
                (Image) ImageUtil.imgMap.get("bossDeath06"),
                (Image) ImageUtil.imgMap.get("bossDeath07"),
                (Image) ImageUtil.imgMap.get("bossDeath08"),
                (Image) ImageUtil.imgMap.get("bossDeath09"),
                (Image) ImageUtil.imgMap.get("bossDeath10"),
                (Image) ImageUtil.imgMap.get("bossDeath11"),
                (Image) ImageUtil.imgMap.get("bossDeath12"),
                (Image) ImageUtil.imgMap.get("bossDeath13"),
                (Image) ImageUtil.imgMap.get("bossDeath14"),
                (Image) ImageUtil.imgMap.get("bossDeath15"),
                (Image) ImageUtil.imgMap.get("bossDeath16"),
                (Image) ImageUtil.imgMap.get("bossDeath17"),
                (Image) ImageUtil.imgMap.get("bossDeath18"),
                (Image) ImageUtil.imgMap.get("bossDeath19"),
                (Image) ImageUtil.imgMap.get("bossDeath20"),
        };
    }

    @Override
    public void move() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(imgs[index++], x, y, null);
        if (index == 20) {
            canvas.bossDeaths.remove(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

}
