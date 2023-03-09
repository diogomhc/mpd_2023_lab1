package isel.mpd.painter2.model;

import java.awt.*;

public class Oval implements IShape{

    private Color color;

    private Point start;

    private int width, height;

    public Oval(Point start, Color color, int w, int h) {
        this.start = start;
        this.color = color;
        width = w;
        height = h;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Point getRef() {
        return null;
    }

    @Override
    public boolean intersects(IShape other) {
        return false;
    }

    @Override
    public boolean contains(Point point) {
        return false;
    }

    @Override
    public boolean contains(IShape other) {
        return false;
    }

    @Override
    public void translate(int dx, int dy) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getRef().x, getRef().y, width, height);
    }
}
