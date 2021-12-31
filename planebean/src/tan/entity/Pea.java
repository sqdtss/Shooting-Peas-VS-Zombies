package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;

public class Pea extends EntityObject {

    // 玩家级别
    public int level;
    // 击杀僵尸数
    public int hasKilled;
    private final Image[][] imgs;
    private int index = 0;
    private Boolean up = false, down = false, fire = false;

    public Pea(int x, int y, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        level = 1;
        hasKilled = 0;
        imgs = new Image[][]{
                {
                        (Image) ImageUtil.imgMap.get("pea1_1"),
                        (Image) ImageUtil.imgMap.get("pea1_2"),
                        (Image) ImageUtil.imgMap.get("pea1_3"),
                        (Image) ImageUtil.imgMap.get("pea1_4"),
                        (Image) ImageUtil.imgMap.get("pea1_5"),
                        (Image) ImageUtil.imgMap.get("pea1_6"),
                        (Image) ImageUtil.imgMap.get("pea1_7"),
                        (Image) ImageUtil.imgMap.get("pea1_8")
                },
                {
                        (Image) ImageUtil.imgMap.get("pea2_1"),
                        (Image) ImageUtil.imgMap.get("pea2_2"),
                        (Image) ImageUtil.imgMap.get("pea2_3"),
                        (Image) ImageUtil.imgMap.get("pea2_4"),
                        (Image) ImageUtil.imgMap.get("pea2_5"),
                        (Image) ImageUtil.imgMap.get("pea2_6"),
                        (Image) ImageUtil.imgMap.get("pea2_7"),
                        (Image) ImageUtil.imgMap.get("pea2_8")
                },
                {
                        (Image) ImageUtil.imgMap.get("pea3_1"),
                        (Image) ImageUtil.imgMap.get("pea3_2"),
                        (Image) ImageUtil.imgMap.get("pea3_3"),
                        (Image) ImageUtil.imgMap.get("pea3_4"),
                        (Image) ImageUtil.imgMap.get("pea3_5"),
                        (Image) ImageUtil.imgMap.get("pea3_6"),
                        (Image) ImageUtil.imgMap.get("pea3_7"),
                        (Image) ImageUtil.imgMap.get("pea3_8")
                }
        };
    }

    @Override
    public void move() {
        if (up) {
            y -= (level - 1) * 1 + speed;
        }
        if (down) {
            y += (level - 1) * 1 + speed;
        }
        if (fire) {
            fire();
        }
        outOfBounds();
    }

    /**
     * 开火
     */
    public void fire() {
        int c = level - 1;
        if (c > 2) {
            c = 2;
        }
        canvas.bullets.add(new Bullet(x + 10 + imgs[0][0].getWidth(null) / 2, y - 30 + imgs[0][0].getHeight(null) / 2, c, (level - 1) * 2 + 90, canvas));
    }

    /**
     * 玩家的pea不能出边框
     */
    public void outOfBounds() {
        if (y < 100) {
            y = 100;
        } else if (y > 582) {
            y = 580;
        }
    }

    /**
     * 上下左右开火按键检测以及移动开火
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fire = true;
            try {
                FileInputStream fis = new FileInputStream(Pea.class.getClassLoader().getResource("tan/music/boom.wav").getPath());
                AudioStream as = new AudioStream(fis);
                AudioPlayer.player.start(as);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fire = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        move();
        int c = level - 1;
        if (c > 2) {
            c = 2;
        }
        g.drawImage(imgs[c][index++ / 2], x, y, null);
        index %= 16;
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, imgs[0][0].getWidth(null), imgs[0][0].getHeight(null));
    }
}
