package isel.mpd.painter2.view;

import java.awt.*;

public class TriangleDrawer implements ConfigDrawer{
    private PainterFrame frame;

    public TriangleDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g, BasicStroke dashed) {
        int[] xPoints = {frame.getStart().x, frame.getCurr().x, frame.getStart().x - (frame.getCurr().x - frame.getStart().x)};
        int[] yPoints = {frame.getStart().y, frame.getCurr().y, frame.getCurr().y};

        g.setStroke(dashed);
        g.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void build() {
        Point simetric = new Point(frame.getStart().x - (frame.getCurr().x - frame.getStart().x), frame.getCurr().y);
        frame.getCanvas().addTriangle(frame.getStart(), frame.getCurr(), simetric, frame.getCurrColor());
    }
}
