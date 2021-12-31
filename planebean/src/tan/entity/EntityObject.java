package tan.entity;

import tan.util.MyCanvas;

import java.awt.*;

public abstract class EntityObject {
    public int x;
    public int y;
    public int speed;
    public MyCanvas canvas;

    public EntityObject(int x, int y, int speed, MyCanvas canvas) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.canvas = canvas;
    }

    public abstract void move();

    public abstract void draw(Graphics g);

    public abstract Rectangle getRectangle();
}
