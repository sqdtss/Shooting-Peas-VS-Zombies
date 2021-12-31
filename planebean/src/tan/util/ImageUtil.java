package tan.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载图像
 */
public class ImageUtil {
    public static Map imgMap = new HashMap<String, Object>();

    static {
        // 静态方法将图片放入imgMap（读取进内存）中

        // 加载背景的图片
        imgMap.put("fightingBg", getImage("tan/imgs/backgrounds/fightingBg.png"));
        // 加载一大波僵尸/BOSS正在来临图片
        imgMap.put("aBunchOfZombiesComing", getImage("tan/imgs/backgrounds/aBunchOfZombiesComing.png"));
        imgMap.put("bossComing", getImage("tan/imgs/backgrounds/bossComing.png"));
        // 加载大脑的图片
        imgMap.put("brain", getImage("tan/imgs/backgrounds/brain.png"));
        // 加载开始/胜利/失败的游戏结束界面
        imgMap.put("startBg", getImage("tan/imgs/backgrounds/startBg.png"));
        imgMap.put("win", getImage("tan/imgs/backgrounds/win.png"));
        imgMap.put("loseBg", getImage("tan/imgs/backgrounds/loseBg.jpg"));
        imgMap.put("sunFlower", getImage("tan/imgs/backgrounds/sunFlower.png"));

        // 加载peas的图片
        // 级别1图片
        imgMap.put("pea1_1", getImage("tan/imgs/peas/pea1/1.png"));
        imgMap.put("pea1_2", getImage("tan/imgs/peas/pea1/2.png"));
        imgMap.put("pea1_3", getImage("tan/imgs/peas/pea1/3.png"));
        imgMap.put("pea1_4", getImage("tan/imgs/peas/pea1/4.png"));
        imgMap.put("pea1_5", getImage("tan/imgs/peas/pea1/5.png"));
        imgMap.put("pea1_6", getImage("tan/imgs/peas/pea1/6.png"));
        imgMap.put("pea1_7", getImage("tan/imgs/peas/pea1/7.png"));
        imgMap.put("pea1_8", getImage("tan/imgs/peas/pea1/8.png"));
        // 级别2图片
        imgMap.put("pea2_1", getImage("tan/imgs/peas/pea2/1.png"));
        imgMap.put("pea2_2", getImage("tan/imgs/peas/pea2/2.png"));
        imgMap.put("pea2_3", getImage("tan/imgs/peas/pea2/3.png"));
        imgMap.put("pea2_4", getImage("tan/imgs/peas/pea2/4.png"));
        imgMap.put("pea2_5", getImage("tan/imgs/peas/pea2/5.png"));
        imgMap.put("pea2_6", getImage("tan/imgs/peas/pea2/6.png"));
        imgMap.put("pea2_7", getImage("tan/imgs/peas/pea2/7.png"));
        imgMap.put("pea2_8", getImage("tan/imgs/peas/pea2/8.png"));
        // 级别3图片
        imgMap.put("pea3_1", getImage("tan/imgs/peas/pea3/1.png"));
        imgMap.put("pea3_2", getImage("tan/imgs/peas/pea3/2.png"));
        imgMap.put("pea3_3", getImage("tan/imgs/peas/pea3/3.png"));
        imgMap.put("pea3_4", getImage("tan/imgs/peas/pea3/4.png"));
        imgMap.put("pea3_5", getImage("tan/imgs/peas/pea3/5.png"));
        imgMap.put("pea3_6", getImage("tan/imgs/peas/pea3/6.png"));
        imgMap.put("pea3_7", getImage("tan/imgs/peas/pea3/7.png"));
        imgMap.put("pea3_8", getImage("tan/imgs/peas/pea3/8.png"));

        // 加载peas射出的子弹的图片
        // 子弹级别1图片
        imgMap.put("bullet1_1", getImage("tan/imgs/bullets/bullet1/1.png"));
        imgMap.put("bullet1_2", getImage("tan/imgs/bullets/bullet1/2.png"));
        imgMap.put("bullet1_3", getImage("tan/imgs/bullets/bullet1/3.png"));
        // 子弹级别2图片
        imgMap.put("bullet2_1", getImage("tan/imgs/bullets/bullet2/1.png"));
        imgMap.put("bullet2_2", getImage("tan/imgs/bullets/bullet2/2.png"));
        imgMap.put("bullet2_3", getImage("tan/imgs/bullets/bullet2/3.png"));
        // 子弹级别3图片
        imgMap.put("bullet3_1", getImage("tan/imgs/bullets/bullet3/1.png"));
        imgMap.put("bullet3_2", getImage("tan/imgs/bullets/bullet3/2.png"));
        imgMap.put("bullet3_3", getImage("tan/imgs/bullets/bullet3/3.png"));

        // 加载僵尸图片
        // 僵尸级别1图片
        imgMap.put("zombie1_1", getImage("tan/imgs/zombies/zombie1/1.png"));
        imgMap.put("zombie1_2", getImage("tan/imgs/zombies/zombie1/2.png"));
        imgMap.put("zombie1_3", getImage("tan/imgs/zombies/zombie1/3.png"));
        imgMap.put("zombie1_4", getImage("tan/imgs/zombies/zombie1/4.png"));
        imgMap.put("zombie1_5", getImage("tan/imgs/zombies/zombie1/5.png"));
        imgMap.put("zombie1_6", getImage("tan/imgs/zombies/zombie1/6.png"));
        imgMap.put("zombie1_7", getImage("tan/imgs/zombies/zombie1/7.png"));
        imgMap.put("zombie1_8", getImage("tan/imgs/zombies/zombie1/8.png"));
        // 僵尸级别2图片
        imgMap.put("zombie2_1", getImage("tan/imgs/zombies/zombie2/1.png"));
        imgMap.put("zombie2_2", getImage("tan/imgs/zombies/zombie2/2.png"));
        imgMap.put("zombie2_3", getImage("tan/imgs/zombies/zombie2/3.png"));
        imgMap.put("zombie2_4", getImage("tan/imgs/zombies/zombie2/4.png"));
        imgMap.put("zombie2_5", getImage("tan/imgs/zombies/zombie2/5.png"));
        imgMap.put("zombie2_6", getImage("tan/imgs/zombies/zombie2/6.png"));
        imgMap.put("zombie2_7", getImage("tan/imgs/zombies/zombie2/7.png"));
        imgMap.put("zombie2_8", getImage("tan/imgs/zombies/zombie2/8.png"));
        // 僵尸级别3图片
        imgMap.put("zombie3_1", getImage("tan/imgs/zombies/zombie3/1.png"));
        imgMap.put("zombie3_2", getImage("tan/imgs/zombies/zombie3/2.png"));
        imgMap.put("zombie3_3", getImage("tan/imgs/zombies/zombie3/3.png"));
        imgMap.put("zombie3_4", getImage("tan/imgs/zombies/zombie3/4.png"));
        imgMap.put("zombie3_5", getImage("tan/imgs/zombies/zombie3/5.png"));
        imgMap.put("zombie3_6", getImage("tan/imgs/zombies/zombie3/6.png"));
        imgMap.put("zombie3_7", getImage("tan/imgs/zombies/zombie3/7.png"));
        imgMap.put("zombie3_8", getImage("tan/imgs/zombies/zombie3/8.png"));
        // 冻僵尸级别1图片
        imgMap.put("freezeZombie1_1", getImage("tan/imgs/freezeZombies/freezeZombie1/1.png"));
        imgMap.put("freezeZombie1_2", getImage("tan/imgs/freezeZombies/freezeZombie1/2.png"));
        imgMap.put("freezeZombie1_3", getImage("tan/imgs/freezeZombies/freezeZombie1/3.png"));
        imgMap.put("freezeZombie1_4", getImage("tan/imgs/freezeZombies/freezeZombie1/4.png"));
        imgMap.put("freezeZombie1_5", getImage("tan/imgs/freezeZombies/freezeZombie1/5.png"));
        imgMap.put("freezeZombie1_6", getImage("tan/imgs/freezeZombies/freezeZombie1/6.png"));
        imgMap.put("freezeZombie1_7", getImage("tan/imgs/freezeZombies/freezeZombie1/7.png"));
        imgMap.put("freezeZombie1_8", getImage("tan/imgs/freezeZombies/freezeZombie1/8.png"));
        // 冻僵尸级别2图片
        imgMap.put("freezeZombie2_1", getImage("tan/imgs/freezeZombies/freezeZombie2/1.png"));
        imgMap.put("freezeZombie2_2", getImage("tan/imgs/freezeZombies/freezeZombie2/2.png"));
        imgMap.put("freezeZombie2_3", getImage("tan/imgs/freezeZombies/freezeZombie2/3.png"));
        imgMap.put("freezeZombie2_4", getImage("tan/imgs/freezeZombies/freezeZombie2/4.png"));
        imgMap.put("freezeZombie2_5", getImage("tan/imgs/freezeZombies/freezeZombie2/5.png"));
        imgMap.put("freezeZombie2_6", getImage("tan/imgs/freezeZombies/freezeZombie2/6.png"));
        imgMap.put("freezeZombie2_7", getImage("tan/imgs/freezeZombies/freezeZombie2/7.png"));
        imgMap.put("freezeZombie2_8", getImage("tan/imgs/freezeZombies/freezeZombie2/8.png"));
        // 冻僵尸级别3图片
        imgMap.put("freezeZombie3_1", getImage("tan/imgs/freezeZombies/freezeZombie3/1.png"));
        imgMap.put("freezeZombie3_2", getImage("tan/imgs/freezeZombies/freezeZombie3/2.png"));
        imgMap.put("freezeZombie3_3", getImage("tan/imgs/freezeZombies/freezeZombie3/3.png"));
        imgMap.put("freezeZombie3_4", getImage("tan/imgs/freezeZombies/freezeZombie3/4.png"));
        imgMap.put("freezeZombie3_5", getImage("tan/imgs/freezeZombies/freezeZombie3/5.png"));
        imgMap.put("freezeZombie3_6", getImage("tan/imgs/freezeZombies/freezeZombie3/6.png"));
        imgMap.put("freezeZombie3_7", getImage("tan/imgs/freezeZombies/freezeZombie3/7.png"));
        imgMap.put("freezeZombie3_8", getImage("tan/imgs/freezeZombies/freezeZombie3/8.png"));
        // 加载boss图片
        imgMap.put("boss01", getImage("tan/imgs/boss/1.png"));
        imgMap.put("boss02", getImage("tan/imgs/boss/2.png"));
        imgMap.put("boss03", getImage("tan/imgs/boss/3.png"));
        imgMap.put("boss04", getImage("tan/imgs/boss/4.png"));
        imgMap.put("boss05", getImage("tan/imgs/boss/5.png"));
        imgMap.put("boss06", getImage("tan/imgs/boss/6.png"));
        imgMap.put("boss07", getImage("tan/imgs/boss/7.png"));
        imgMap.put("boss08", getImage("tan/imgs/boss/8.png"));
        imgMap.put("boss09", getImage("tan/imgs/boss/9.png"));
        imgMap.put("boss10", getImage("tan/imgs/boss/10.png"));
        imgMap.put("boss11", getImage("tan/imgs/boss/11.png"));
        // 加载普通僵尸死图片
        imgMap.put("zombieDeath01", getImage("tan/imgs/zombieDeath/1.png"));
        imgMap.put("zombieDeath02", getImage("tan/imgs/zombieDeath/2.png"));
        imgMap.put("zombieDeath03", getImage("tan/imgs/zombieDeath/3.png"));
        imgMap.put("zombieDeath04", getImage("tan/imgs/zombieDeath/4.png"));
        imgMap.put("zombieDeath05", getImage("tan/imgs/zombieDeath/5.png"));
        // 加载boss死图片
        imgMap.put("bossDeath01", getImage("tan/imgs/bossDeath/1.png"));
        imgMap.put("bossDeath02", getImage("tan/imgs/bossDeath/2.png"));
        imgMap.put("bossDeath03", getImage("tan/imgs/bossDeath/3.png"));
        imgMap.put("bossDeath04", getImage("tan/imgs/bossDeath/4.png"));
        imgMap.put("bossDeath05", getImage("tan/imgs/bossDeath/5.png"));
        imgMap.put("bossDeath06", getImage("tan/imgs/bossDeath/6.png"));
        imgMap.put("bossDeath07", getImage("tan/imgs/bossDeath/7.png"));
        imgMap.put("bossDeath08", getImage("tan/imgs/bossDeath/8.png"));
        imgMap.put("bossDeath09", getImage("tan/imgs/bossDeath/9.png"));
        imgMap.put("bossDeath10", getImage("tan/imgs/bossDeath10.png"));
        imgMap.put("bossDeath11", getImage("tan/imgs/bossDeath/11.png"));
        imgMap.put("bossDeath12", getImage("tan/imgs/bossDeath/12.png"));
        imgMap.put("bossDeath13", getImage("tan/imgs/bossDeath/13.png"));
        imgMap.put("bossDeath14", getImage("tan/imgs/bossDeath/14.png"));
        imgMap.put("bossDeath15", getImage("tan/imgs/bossDeath/15.png"));
        imgMap.put("bossDeath16", getImage("tan/imgs/bossDeath/16.png"));
        imgMap.put("bossDeath17", getImage("tan/imgs/bossDeath/17.png"));
        imgMap.put("bossDeath18", getImage("tan/imgs/bossDeath/18.png"));
        imgMap.put("bossDeath19", getImage("tan/imgs/bossDeath/19.png"));
        imgMap.put("bossDeath20", getImage("tan/imgs/bossDeath/20.png"));

        // 加载道具图片
        // 道具级别1图片
        imgMap.put("prop1_1", getImage("tan/imgs/props/prop1/1.png"));
        imgMap.put("prop1_2", getImage("tan/imgs/props/prop1/2.png"));
        imgMap.put("prop1_3", getImage("tan/imgs/props/prop1/3.png"));
        imgMap.put("prop1_4", getImage("tan/imgs/props/prop1/4.png"));
        // 道具级别2图片
        imgMap.put("prop2_1", getImage("tan/imgs/props/prop2/1.png"));
        imgMap.put("prop2_2", getImage("tan/imgs/props/prop2/2.png"));
        imgMap.put("prop2_3", getImage("tan/imgs/props/prop2/3.png"));
        imgMap.put("prop2_4", getImage("tan/imgs/props/prop2/4.png"));
        // 道具级别3图片
        imgMap.put("prop3_1", getImage("tan/imgs/props/prop3/1.png"));
        imgMap.put("prop3_2", getImage("tan/imgs/props/prop3/2.png"));
        imgMap.put("prop3_3", getImage("tan/imgs/props/prop3/3.png"));
        imgMap.put("prop3_4", getImage("tan/imgs/props/prop3/4.png"));
    }

    public static Image getImage(String path) {
        Image image = null;
        URL url = ImageUtil.class.getClassLoader().getResource(path);
        try {
            image = ImageIO.read(url);
        } catch (Exception e) {
        }
        return image;
    }
}
