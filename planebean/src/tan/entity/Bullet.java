package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.FileInputStream;
import java.util.List;
import java.util.Random;

/**
 * 玩家子弹类
 */
public class Bullet extends EntityObject {

    public Image[][] imgs;
    private int index = 0;
    private final int type;
    private boolean flag = false;

    public Bullet(int x, int y, int type, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        this.type = type;
        imgs = new Image[][]{
                {
                        (Image) ImageUtil.imgMap.get("bullet1_1"),
                        (Image) ImageUtil.imgMap.get("bullet1_2"),
                        (Image) ImageUtil.imgMap.get("bullet1_3")
                },
                {
                        (Image) ImageUtil.imgMap.get("bullet2_1"),
                        (Image) ImageUtil.imgMap.get("bullet2_2"),
                        (Image) ImageUtil.imgMap.get("bullet2_3")
                },
                {
                        (Image) ImageUtil.imgMap.get("bullet3_1"),
                        (Image) ImageUtil.imgMap.get("bullet3_2"),
                        (Image) ImageUtil.imgMap.get("bullet3_3")
                }
        };
    }

    @Override
    public void move() {
        x += speed;
        outOfBounds();
    }

    public void outOfBounds() {
        if (x > 1000) {
            canvas.bullets.remove(this);
        }
        if (y > 700 || y < 10) {
            canvas.bullets.remove(this);
            flag = true;
        }
    }

    @Override
    public void draw(Graphics g) {
        move();
        if (flag) {
            return;
        }
        if (type == 2) {
            if (index >= 2) {
                g.drawImage(imgs[type][2], x, y - imgs[type][2].getHeight(null) / 2, null);
            } else {
                g.drawImage(imgs[type][index], x, y, null);
            }
            if (index < 11)
                index++;
        } else {
            g.drawImage(imgs[type][index], x, y, null);
            if (index < 2) {
                index++;
            }
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, imgs[type][index / 5].getWidth(null), imgs[type][index / 5].getHeight(null));
    }

    public void collisionDetection(List<Zombie> enemyPlaneList, Pea plane) {
        for (Zombie enemyPlane : enemyPlaneList) {
            // 玩家子弹与敌人飞机碰撞检测
            if (enemyPlane.getRectangle().intersects(this.getRectangle())) {
                try {
                    FileInputStream fis = new FileInputStream(Bullet.class.getClassLoader().getResource("tan/music/diaoxie.wav").getPath());
                    AudioStream as = new AudioStream(fis);
                    AudioPlayer.player.start(as);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (this.type == 1 && enemyPlane.type <= 2) {
                    try {
                        FileInputStream fis = new FileInputStream(Bullet.class.getClassLoader().getResource("tan/music/freeze.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                    enemyPlane.type += 4;
                    if (enemyPlane.type != 3)
                        enemyPlane.speed -= 2;
                }
                // 敌机hp减1000
                enemyPlane.hp -= 1000;
                // 敌机血量小于等于0时即放销毁音乐爆炸移除敌机
                if (enemyPlane.hp <= 0) {
                    // 如果敌机血量小于等于0
                    try {
                        FileInputStream fis = new FileInputStream(Bullet.class.getClassLoader().getResource("tan/music/daodi.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    plane.hasKilled++;
                    canvas.zombies.remove(enemyPlane);
                    // 如果是铁桶僵尸他高一点偏移了一点特殊处理
                    if (enemyPlane.type == 2) {
                        canvas.zombieDeaths.add(new ZombieDeath(enemyPlane.x + 26, enemyPlane.y + 13, 0, canvas));
                    } else if (enemyPlane.type == 3) {
                        canvas.bossDeaths.add(new BossDeath(enemyPlane.x, enemyPlane.y, 0, canvas));
                    } else {
                        canvas.zombieDeaths.add(new ZombieDeath(enemyPlane.x, enemyPlane.y, 0, canvas));
                    }
                    // 随机掉落道具
                    if (new Random().nextInt(1000) < 100)
                        canvas.props.add(new Prop(enemyPlane.x - 40, enemyPlane.y + 38, new Random().nextInt(3), 10, canvas));
                }
                // 移除子弹
                canvas.bullets.remove(this);
            }
        }
    }
}
