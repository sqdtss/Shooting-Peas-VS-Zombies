package tan.entity;

import tan.client.PlaneClient;
import tan.util.ImageUtil;
import tan.util.MyCanvas;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.FileInputStream;

/**
 * 道具类
 */
public class Prop extends EntityObject {
    public boolean useful = true;
    // 道具类型，范围0~2
    private final int type;
    private final Image[][] imgs;
    private int index = 0;

    public Prop(int x, int y, int type, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        this.type = type;
        imgs = new Image[][]{
                {
                        (Image) ImageUtil.imgMap.get("prop1_1"),
                        (Image) ImageUtil.imgMap.get("prop1_2"),
                        (Image) ImageUtil.imgMap.get("prop1_3"),
                        (Image) ImageUtil.imgMap.get("prop1_4")
                },
                {
                        (Image) ImageUtil.imgMap.get("prop2_1"),
                        (Image) ImageUtil.imgMap.get("prop2_2"),
                        (Image) ImageUtil.imgMap.get("prop2_3"),
                        (Image) ImageUtil.imgMap.get("prop2_4")
                },
                {
                        (Image) ImageUtil.imgMap.get("prop3_1"),
                        (Image) ImageUtil.imgMap.get("prop3_2"),
                        (Image) ImageUtil.imgMap.get("prop3_3"),
                        (Image) ImageUtil.imgMap.get("prop3_4")
                }
        };
    }

    // 道具与玩家碰撞检测方法
    public void collisionDetection(Pea plane) {
        // 如果发生碰撞
        if (plane.getRectangle().intersects(this.getRectangle())) {
            // 根据道具类别产生不同事件
            if (type == 0) {
                // 道具0杀光屏幕中僵尸
                if (useful) {
                    for (Zombie zombie : canvas.zombies) {
                        try {
                            FileInputStream fis = new FileInputStream(Prop.class.getClassLoader().getResource("tan/music/daoxia.wav").getPath());
                            AudioStream as = new AudioStream(fis);
                            AudioPlayer.player.start(as);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        canvas.prop0 = true;
                        // 玩家击杀数+1
                        canvas.player.hasKilled++;
                        // 添加爆炸效果
                        canvas.zombieDeaths.add(new ZombieDeath(zombie.x, zombie.y, 0, canvas));
                    }
                    canvas.zombies.clear();
                }
                // 将道具置为无效
                useful = false;
            } else if (type == 1) {
                if (useful) {
                    // 通过暂停时间修改距离游戏胜利时间
                    try {
                        FileInputStream fis = new FileInputStream(Prop.class.getClassLoader().getResource("tan/music/time.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    PlaneClient.STOP_TIME -= 5000;
                }
                // 将道具置为无效
                useful = false;
            } else if (type == 2) {
                if (useful) {
                    // 玩家升级
                    plane.level++;
                    try {
                        FileInputStream fis = new FileInputStream(Prop.class.getClassLoader().getResource("tan/music/up.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                //  将道具置为无效
                useful = false;
            }
        }
    }

    @Override
    public void move() {
        x -= speed;
        outOfBounds();
    }

    public void outOfBounds() {
        if (x < 0) {
            useful = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(imgs[type][index++ / 3], x, y, null);
        index %= 12;
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, imgs[0][0].getWidth(null), imgs[0][0].getHeight(null));
    }
}
