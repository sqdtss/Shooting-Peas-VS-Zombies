package tan.entity;

import tan.util.ImageUtil;
import tan.util.MyCanvas;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.FileInputStream;
import java.util.List;

public class Brain extends EntityObject {
    public Image[] imgs;

    public Brain(int x, int y, int speed, MyCanvas canvas) {
        super(x, y, speed, canvas);
        imgs = new Image[]{
                (Image) ImageUtil.imgMap.get("brain")
        };
    }

    @Override
    public void move() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(imgs[0], x, y, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, imgs[0].getWidth(null) + 15, imgs[0].getHeight(null) - 5);
    }

    public void collisionEnemyPlane(List<Zombie> enemyPlaneList) {
        for (Zombie enemyPlane : enemyPlaneList) {
            if (this.getRectangle().intersects(enemyPlane.getRectangle())) {
                try {
                    FileInputStream fis = new FileInputStream(Brain.class.getClassLoader().getResource("tan/music/eating.wav").getPath());
                    AudioStream as = new AudioStream(fis);
                    AudioPlayer.player.start(as);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                canvas.zombies.remove(enemyPlane);
                canvas.brains.remove(this);
            }
        }
    }
}
