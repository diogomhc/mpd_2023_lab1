package isel.mpd.painter2.view;

import java.awt.*;

public class OvalDrawer implements ConfigDrawer {

    private PainterFrame frame;

    public OvalDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g, BasicStroke dashed) {
        int w = frame.getCurr().x - frame.getStart().x + 1;
        int h = frame.getCurr().y - frame.getStart().y + 1;

        g.setStroke(dashed);
        g.drawOval(frame.getStart().x, frame.getStart().y, w, h);
    }

    @Override
    public void build() {
        int w = frame.getCurr().x - frame.getStart().x + 1;
        int h = frame.getCurr().y - frame.getStart().y + 1;

        frame.getCanvas().addOval(frame.getStart(), w, h, frame.getCurrColor());
    }
}
