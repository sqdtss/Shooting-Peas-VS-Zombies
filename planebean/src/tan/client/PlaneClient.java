package tan.client;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import tan.entity.Bullet;
import tan.util.MyCanvas;
import tan.util.MyFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class PlaneClient extends MyFrame {
    public static int SCORE;
    public static long START_TIME;
    public static long ACTIVE_TIME;
    public static long START_TO_STOP_TIME;
    public static long STOP_TIME;
    public static boolean STOP;
    public MyCanvas canvas;

    public PlaneClient() {
        SCORE = 0;
        START_TIME = 0;
        STOP = false;
    }

    /**
     * 程序主入口
     *
     * @param args
     */
    public static void main(String[] args) {
        new PlaneClient();
    }

    @Override
    public void loadFrame() {
        // 加载画布，将画布加入显示框
        canvas = new MyCanvas();
        this.add(canvas);
        /**
         * 键盘监听
         */
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                canvas.player.keyPressed(e);
                // 按K开始检测
                if (e.getKeyCode() == KeyEvent.VK_K) {
                    canvas.start = true;
                    try {
                        FileInputStream fis = new FileInputStream(Bullet.class.getClassLoader().getResource("tan/music/pause.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
                // 按P暂停检测
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    STOP = !STOP;
                    if (STOP) {
                        START_TO_STOP_TIME = System.currentTimeMillis();
                    } else {
                        STOP_TIME += System.currentTimeMillis() - START_TO_STOP_TIME;
                    }
                    try {
                        FileInputStream fis = new FileInputStream(Bullet.class.getClassLoader().getResource("tan/music/pause.wav").getPath());
                        AudioStream as = new AudioStream(fis);
                        AudioPlayer.player.start(as);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
                // 按R重新开始检测
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    canvas.gameover = false;
                    restart(canvas);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                canvas.player.keyReleased(e);
            }
        });
        new Thread(new Timer()).start();
        new BgMusic().start();
        super.loadFrame();
    }

    /**
     * 重新开始方法
     *
     * @param canvas
     */
    public void restart(MyCanvas canvas) {
        SCORE = 0;
        START_TIME = 0;
        ACTIVE_TIME = 0;
        START_TO_STOP_TIME = System.currentTimeMillis();
        STOP_TIME = 0;
        STOP = false;
        canvas.reinit();
    }

    class BgMusic extends Thread {
        public void run() {
            while (true) {
                bgMusic sound = new bgMusic(Bullet.class.getClassLoader().getResource("tan/music/fire.wav").getPath());
                InputStream stream = new ByteArrayInputStream(sound.getSamples());
                sound.play(stream);
            }
        }
    }

    class Timer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 如果没有按下暂停P键，刷新页面
                if (!STOP)
                    repaint();
            }
        }
    }
}

