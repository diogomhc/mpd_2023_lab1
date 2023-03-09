package isel.mpd.painter1.view;

import java.awt.*;

public class CircleDrawer implements ConfigDrawer{

    private PainterFrame frame;

    public CircleDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g, BasicStroke dashed) {
        int r = frame.getCurr().x - frame.getStart().x + 1;

        g.setStroke(dashed);
        g.drawOval(frame.getStart().x, frame.getStart().y, r, r);
    }

    @Override
    public void build() {
        int r = frame.getCurr().x - frame.getStart().x + 1;

        frame.getCanvas().addOval(frame.getStart(), r, r, frame.getCurrColor());
    }
}
