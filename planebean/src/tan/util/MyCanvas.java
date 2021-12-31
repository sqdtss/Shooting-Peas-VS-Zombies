package tan.util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import tan.client.PlaneClient;
import tan.entity.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyCanvas extends JPanel {

    public Pea player = new Pea(60, 115, 125, this);
    public FightingBg bg = new FightingBg(0, 0, 4, this);
    public List<Bullet> bullets = new CopyOnWriteArrayList<>();
    public List<Brain> brains = new CopyOnWriteArrayList<>();
    public List<Boss> bossList = new CopyOnWriteArrayList<>();
    public List<Zombie> zombies = new CopyOnWriteArrayList<>();
    public List<ZombieDeath> zombieDeaths = new CopyOnWriteArrayList<>();
    public List<BossDeath> bossDeaths = new CopyOnWriteArrayList<>();
    public List<Prop> props = new CopyOnWriteArrayList<>();
    public Random random = new Random();
    public Boss boss = null;
    public List<SunFlower> sunFlowers = new CopyOnWriteArrayList<>();
    public LoseBg loseBg = new LoseBg(0, 600, 10, this);
    public int type = 0;
    public boolean start;
    public boolean prop0 = false;
    public int prop0count = 0;
    // 一大波僵尸/BOSS来临持续时间计数
    public int until = 0;
    public boolean comingflag1 = true;
    public boolean comingflag2 = true;
    public boolean comingflag3 = true;
    public Start st;
    public boolean gameover;
    public boolean win;
    public boolean hasSong = false;

    public MyCanvas() {
        // 初始化
        st = new Start();
        start = false;
        gameover = false;
        win = false;
        // 初始化大脑
        brains.add(new Brain(20, 20 + 90, 0, this));
        brains.add(new Brain(20, 150 + 90, 0, this));
        brains.add(new Brain(20, 280 + 90, 0, this));
        brains.add(new Brain(20, 410 + 90, 0, this));
        brains.add(new Brain(20, 540 + 90, 0, this));
        // 初始化敌人
        zombies.add(new Zombie(700, 145 + 10 + 15, 0, 3, this));
        zombies.add(new Zombie(900, 395 + 10 + 15, 0, 3, this));
        zombies.add(new Zombie(800, 520 + 10 + 15, 0, 3, this));
    }

    public void doWin(Graphics g) {
        if (!win) {
            if (!hasSong) {
                try {
                    FileInputStream fis = new FileInputStream(MyCanvas.class.getClassLoader().getResource("tan/music/loser.wav").getPath());
                    AudioStream as = new AudioStream(fis);
                    AudioPlayer.player.start(as);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                hasSong = true;
            }
            g.drawImage((Image) ImageUtil.imgMap.get("loseBg"), 0, 0, 1000, 750, null);
            loseBg.draw(g);
        } else {
            if (!hasSong) {
                try {
                    FileInputStream fis = new FileInputStream(MyCanvas.class.getClassLoader().getResource("tan/music/access.wav").getPath());
                    AudioStream as = new AudioStream(fis);
                    AudioPlayer.player.start(as);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                hasSong = true;
            }
            g.drawImage((Image) ImageUtil.imgMap.get("fightingBg"), 0, 0, null);
            if (sunFlowers.size() < 70) {
                sunFlowers.add(new SunFlower((int) (Math.random() * 800),
                        (int) (Math.random() * 600) + 600, 30, this));
            }
            for (SunFlower sunFlower : sunFlowers) {
                sunFlower.draw(g);
            }
        }
    }

    /**
     * 画布绘制自动调用此方法
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if (gameover) {
            doWin(g);
            return;
        }
        if (start) {
            if (PlaneClient.START_TIME == 0) {
                PlaneClient.START_TIME = System.currentTimeMillis();
            }
            super.paint(g);
            // 画背景
            bg.draw(g);
            if (PlaneClient.ACTIVE_TIME > 29 * 1000 && type == 0 && until < 15) {
                if (comingflag1) {
                    try {
                        FileInputStream fis = new FileInputStream(MyCanvas.class.getClassLoader().getResource("tan/music/coming.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    comingflag1 = false;
                }
                until++;
                g.drawImage((Image) ImageUtil.imgMap.get("aBunchOfZombiesComing"), 0, 0, null);
            } else if (PlaneClient.ACTIVE_TIME > 59 * 1000 && type == 1 && until < 15) {
                if (comingflag2) {
                    try {
                        FileInputStream fis = new FileInputStream(MyCanvas.class.getClassLoader().getResource("tan/music/coming.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    comingflag2 = false;
                }
                until++;
                g.drawImage((Image) ImageUtil.imgMap.get("aBunchOfZombiesComing"), 0, 0, null);
            } else if (PlaneClient.ACTIVE_TIME > 89 * 1000 && type == 2 && until < 15) {
                if (comingflag3) {
                    try {
                        FileInputStream fis = new FileInputStream(MyCanvas.class.getClassLoader().getResource("tan/music/coming.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    comingflag3 = false;
                }
                until++;
                g.drawImage((Image) ImageUtil.imgMap.get("bossComing"), 0, 0, null);
            } else {
                until = 0;
            }
            for (Brain brain : brains) {
                brain.draw(g);
            }
            for (BossDeath explode : bossDeaths) {
                explode.draw(g);
            }
            // 画玩家飞机
            player.draw(g);
            // 画玩家子弹
            for (Bullet bullet : bullets) {
                bullet.draw(g);
            }
            for (Zombie enemy : zombies) {
                enemy.draw(g);
            }
            // 画爆炸效果
            for (ZombieDeath zombieDeath : zombieDeaths) {
                if (zombieDeath.useful)
                    zombieDeath.draw(g);
                else {
                    zombieDeaths.remove(zombieDeath);
                }
            }
            // 画道具
            for (Prop prop : props) {
                if (prop.useful)
                    prop.draw(g);
                else {
                    zombieDeaths.remove(prop);
                }
            }
            // 碰撞检测
            // 玩家子弹与敌方飞机碰撞检测
            for (Bullet bullet : bullets) {
                bullet.collisionDetection(zombies, player);
            }
            // 道具与玩家飞机碰撞检测
            for (Prop prop : props) {
                prop.collisionDetection(player);
            }
            // 大脑与敌方飞机碰撞检测
            for (Brain brain : brains) {
                brain.collisionEnemyPlane(zombies);
            }
            if (prop0) {
                prop0count++;
            }
            if (prop0count == 30) {
                prop0count = 0;
                prop0 = false;
            }
            if (PlaneClient.ACTIVE_TIME > 30 * 1000 && type == 0) {
                type = 1;
            } else if (PlaneClient.ACTIVE_TIME > 60 * 1000 && type == 1) {
                type = 2;
            } else if (PlaneClient.ACTIVE_TIME > 90 * 1000 && type == 2) {
                type = 3;
            } else if (PlaneClient.ACTIVE_TIME > 120 * 1000 && type == 3) {
                gameover = true;
                win = true;
                hasSong = false;
            }
            // 当敌军数小于4并且没有在清屏道具时间内时随机产生僵尸
            if (zombies.size() <= 4 && !prop0) {
                int c = 0, he = 0, rand;
                if (type == 1) {
                    c = 1;
                } else if (type == 2) {
                    c = 2;
                    he = 26;
                }
                rand = random.nextInt(c + 1);
                if (rand == 2) {
                    c = 1;
                } else {
                    c = 0;
                }
                zombies.add(new Zombie(700 + random.nextInt(200), 30 + 15 + 125 * random.nextInt(5) - c * he, rand, 3, this));
                zombies.add(new Zombie(700 + random.nextInt(200), 30 + 15 + 125 * random.nextInt(5) - he, type, 3, this));
                zombies.add(new Zombie(700 + random.nextInt(200), 30 + 15 + 125 * random.nextInt(5) - he, type, 3, this));
            }
            // 记录现在游戏时间
            PlaneClient.ACTIVE_TIME = System.currentTimeMillis() - PlaneClient.START_TIME - PlaneClient.STOP_TIME;
            g.setFont(new Font("黑体", Font.BOLD, 30));
            g.setColor(Color.CYAN);
            g.drawString("level: " + player.level, 10, 30);
            g.drawString("has killed: " + player.hasKilled, 10, 60);
            g.drawString("time remaining: " + (120000 - PlaneClient.ACTIVE_TIME) / 1000 + "s", 10, 90);
        } else {
            g.drawImage((Image) ImageUtil.imgMap.get("startBg"), 0, 0, 1000, 750, null);
            if (st.count <= 200) {
                st.drawStart(g, this);
            }
            if (st.count == 210) {
                g.setFont(new Font("宋体", Font.BOLD, 20));
                g.setColor(Color.white);
                g.drawString("按K开始游戏", 450, 500);
                g.drawString("TIP:", 631, 630);
                g.drawString("游戏中暂停请按P", 660, 650);
                g.drawString("游戏中重新开始请按R", 660, 670);
                g.drawString("游戏中上下键移动，空格键开火", 660, 690);
            }
        }
    }

    public void reinit() {
        // 把MyCanvas里需要初始化的变量全部初始化

        this.sunFlowers.clear();
        this.loseBg = new LoseBg(0, 600, 10, this);
        this.start = true;
        this.prop0 = false;
        this.prop0count = 0;
        this.until = 0;
        this.comingflag1 = true;
        this.comingflag2 = true;
        this.comingflag3 = true;
        this.gameover = false;
        this.win = false;
        this.hasSong = false;
        this.bossDeaths.clear();
        this.type = 0;
        this.player = new Pea(60, 115, 125, this);
        this.bullets.clear();
        this.zombies.clear();
        this.zombieDeaths.clear();
        this.props.clear();
        this.brains.clear();
        this.boss = null;
        // 初始化大脑
        this.brains.add(new Brain(20, 20 + 90, 0, this));
        this.brains.add(new Brain(20, 150 + 90, 0, this));
        this.brains.add(new Brain(20, 280 + 90, 0, this));
        this.brains.add(new Brain(20, 410 + 90, 0, this));
        this.brains.add(new Brain(20, 540 + 90, 0, this));
        // 初始化敌人
        this.zombies.add(new Zombie(700, 145 + 10 + 15, 0, 3, this));
        this.zombies.add(new Zombie(900, 395 + 10 + 15, 0, 3, this));
        this.zombies.add(new Zombie(800, 520 + 10 + 15, 0, 3, this));
    }
}
