package isel.mpd.painter2.model;

import java.awt.*;

class ShapeUtils {

    static boolean intersects(IShape shape, IShape other) {
        return shape.getBounds().intersects(other.getBounds());
    }

    static boolean contains(IShape shape, IShape other) {
        return shape.getBounds().contains(other.getBounds());
    }

    static boolean contains(IShape shape, Point point) {
        return shape.getBounds().contains(point);
    }

    static void translate(IShape shape, int dx, int dy) {shape.getBounds().translate(dx, dy);}
}
