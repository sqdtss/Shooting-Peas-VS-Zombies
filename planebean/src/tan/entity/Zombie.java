package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;

import java.awt.*;

public class Zombie extends EntityObject {

    public int type;
    public int hp;
    private final Image[][] imgs;
    private int index = 0;

    public Zombie(int x, int y, int type, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        this.type = type;
        this.hp = 8000 * (type + 1);
        imgs = new Image[][]{
                {
                        (Image) ImageUtil.imgMap.get("zombie1_1"),
                        (Image) ImageUtil.imgMap.get("zombie1_2"),
                        (Image) ImageUtil.imgMap.get("zombie1_3"),
                        (Image) ImageUtil.imgMap.get("zombie1_4"),
                        (Image) ImageUtil.imgMap.get("zombie1_5"),
                        (Image) ImageUtil.imgMap.get("zombie1_6"),
                        (Image) ImageUtil.imgMap.get("zombie1_7"),
                        (Image) ImageUtil.imgMap.get("zombie1_8")
                },
                {
                        (Image) ImageUtil.imgMap.get("zombie2_1"),
                        (Image) ImageUtil.imgMap.get("zombie2_2"),
                        (Image) ImageUtil.imgMap.get("zombie2_3"),
                        (Image) ImageUtil.imgMap.get("zombie2_4"),
                        (Image) ImageUtil.imgMap.get("zombie2_5"),
                        (Image) ImageUtil.imgMap.get("zombie2_6"),
                        (Image) ImageUtil.imgMap.get("zombie2_7"),
                        (Image) ImageUtil.imgMap.get("zombie2_8")
                },
                {
                        (Image) ImageUtil.imgMap.get("zombie3_1"),
                        (Image) ImageUtil.imgMap.get("zombie3_2"),
                        (Image) ImageUtil.imgMap.get("zombie3_3"),
                        (Image) ImageUtil.imgMap.get("zombie3_4"),
                        (Image) ImageUtil.imgMap.get("zombie3_5"),
                        (Image) ImageUtil.imgMap.get("zombie3_6"),
                        (Image) ImageUtil.imgMap.get("zombie3_7"),
                        (Image) ImageUtil.imgMap.get("zombie3_8")
                },
                {
                        //boss
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
                        (Image) ImageUtil.imgMap.get("boss11")
                },
                {
                        (Image) ImageUtil.imgMap.get("freezeZombie1_1"),
                        (Image) ImageUtil.imgMap.get("freezeZombie1_2"),
                        (Image) ImageUtil.imgMap.get("freezeZombie1_3"),
                        (Image) ImageUtil.imgMap.get("freezeZombie1_4"),
                        (Image) ImageUtil.imgMap.get("freezeZombie1_5"),
                        (Image) ImageUtil.imgMap.get("freezeZombie1_6"),
                        (Image) ImageUtil.imgMap.get("freezeZombie1_7"),
                        (Image) ImageUtil.imgMap.get("freezeZombie1_8")
                },
                {
                        (Image) ImageUtil.imgMap.get("freezeZombie2_1"),
                        (Image) ImageUtil.imgMap.get("freezeZombie2_2"),
                        (Image) ImageUtil.imgMap.get("freezeZombie2_3"),
                        (Image) ImageUtil.imgMap.get("freezeZombie2_4"),
                        (Image) ImageUtil.imgMap.get("freezeZombie2_5"),
                        (Image) ImageUtil.imgMap.get("freezeZombie2_6"),
                        (Image) ImageUtil.imgMap.get("freezeZombie2_7"),
                        (Image) ImageUtil.imgMap.get("freezeZombie2_8")
                },
                {
                        (Image) ImageUtil.imgMap.get("freezeZombie3_1"),
                        (Image) ImageUtil.imgMap.get("freezeZombie3_2"),
                        (Image) ImageUtil.imgMap.get("freezeZombie3_3"),
                        (Image) ImageUtil.imgMap.get("freezeZombie3_4"),
                        (Image) ImageUtil.imgMap.get("freezeZombie3_5"),
                        (Image) ImageUtil.imgMap.get("freezeZombie3_6"),
                        (Image) ImageUtil.imgMap.get("freezeZombie3_7"),
                        (Image) ImageUtil.imgMap.get("freezeZombie3_8")
                }
        };
    }

    @Override
    public void move() {
        x -= speed;
        outOfBounds();
    }

    public void outOfBounds() {
        if (x < -10) {
            canvas.zombies.remove(this);
            canvas.gameover = true;
            canvas.win = false;
            canvas.hasSong = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(imgs[type][index++ / 2], x, y, null);
        index %= 16;
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, imgs[type][0].getWidth(null) + 60, imgs[type][0].getHeight(null));
    }
}
