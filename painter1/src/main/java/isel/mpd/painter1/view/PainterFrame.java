package isel.mpd.painter1.view;

import isel.mpd.painter1.app.App;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JColorChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainterFrame extends JFrame {
    public static int CANVAS_SIZE_X = 1024;
    public static int CANVAS_SIZE_Y = 600;

    // command names
    public static final String SHAPE_CMD_RECT = "Rect";
    public static final String SHAPE_CMD_LINE = "Line";
    public static final String SHAPE_CMD_TRIANGLE = "Triangle";
    public static final String SHAPE_CMD_OVAL = "Oval";
    public static final String SHAPE_CMD_CIRCLE = "Circle";

    // state variables
    private Color currColor = Color.BLACK;

    // components
    private Point start, curr;
    private JTextArea mouseHistory;
    private PaintPanel canvas;
    private ConfigDrawer currDrawer;

    public Point getStart() {
        return start;
    }

    public Point getCurr(){
        return curr;
    }

    public Color getCurrColor() {return currColor;}

    public PaintPanel getCanvas() {return canvas;}

    public  PainterFrame(App app){
        initComponents();
        buildMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }

    private class PaintMouselistener extends MouseAdapter {
        public void mousePressed(MouseEvent me) {
            start = me.getPoint();
            curr = start;
            canvas.setBuildMode(currDrawer);
        }

        public void mouseDragged(MouseEvent me) {
            curr = me.getPoint();
            canvas.repaint();
        }

        public void mouseReleased(MouseEvent me) {
            currDrawer.build();
            canvas.resetBuildMode();
        }
    }

    private void initComponents() {
        BorderLayout layout = new BorderLayout();
        Container container = getContentPane();
        container.setLayout(layout);
        canvas = new PaintPanel(CANVAS_SIZE_X, CANVAS_SIZE_Y, Color.WHITE);
        PaintMouselistener mlistener = new PaintMouselistener();
        canvas.addMouseMotionListener(mlistener);
        canvas.addMouseListener(mlistener);

        mouseHistory = new JTextArea(6, 80);
        mouseHistory.setBackground(new Color(240,240,240));
        mouseHistory.setEditable(false); // set textArea non-editable
        var scroll = new JScrollPane(mouseHistory);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        container.add(canvas, BorderLayout.CENTER);
        container.add(scroll, BorderLayout.SOUTH);
    }

    private JMenuItem buildItem(String name, ActionListener action) {
        var item = new JMenuItem(name);
        item.addActionListener(action);
        return item;
    }

    private void addItem(String name, JMenu menu) {
        menu.add(buildItem(name, al -> {
            mouseHistory.append(name);
            currDrawer = createDrawerFromName(name);
        }));
    }

    private ConfigDrawer createDrawerFromName(String name) {
        return switch (name) {
            case SHAPE_CMD_RECT -> new RectDrawer(this);
            case SHAPE_CMD_TRIANGLE -> new TriangleDrawer(this);
            case SHAPE_CMD_OVAL -> new OvalDrawer(this);
            case SHAPE_CMD_LINE -> new LineDrawer(this);
            default -> new CircleDrawer(this);
        };
    }

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu creationSel = new JMenu("Add Shape");
        JMenu configSel = new JMenu("Config");
        JMenuItem color = new JMenuItem("Color");
        color.addActionListener(evt -> {
            currColor = JColorChooser.showDialog(null,"Choose Color", currColor);
        });
        addItem(SHAPE_CMD_RECT, creationSel);
        addItem(SHAPE_CMD_TRIANGLE, creationSel);
        addItem(SHAPE_CMD_OVAL, creationSel);
        addItem(SHAPE_CMD_LINE, creationSel);
        addItem(SHAPE_CMD_CIRCLE, creationSel);
        configSel.add(color);
        menuBar.add(creationSel);
        menuBar.add(configSel);
        setJMenuBar(menuBar);
    }

}
