package isel.mpd.painter1.view;

import java.awt.*;

public class LineDrawer implements ConfigDrawer{

    private PainterFrame frame;

    public LineDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g, BasicStroke dashed) {
        g.setStroke(dashed);
        g.drawLine(frame.getStart().x, frame.getStart().y, frame.getCurr().x, frame.getCurr().y);
    }

    @Override
    public void build() {
        frame.getCanvas().addLine(frame.getStart(), frame.getCurr(), frame.getCurrColor());
    }
}
