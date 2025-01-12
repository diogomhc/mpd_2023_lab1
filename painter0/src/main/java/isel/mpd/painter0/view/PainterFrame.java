package isel.mpd.painter0.view;


import isel.mpd.painter0.utils.RandomUtils;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JColorChooser;

import java.awt.*;
import java.awt.event.ActionListener;


public class PainterFrame extends JFrame {
    /* min and max sizes for width and height of random generated shapes */
    public static final int MIN_WIDTH = 50, MAX_WIDTH = 200;
    public static final int MIN_HEIGHT = 50, MAX_HEIGHT = 200;

    /* canvas sizes */
    public static final int CANVAS_SIZE_X = 1024;
    public static final int CANVAS_SIZE_Y = 600;

    // command shape names, to use on Menus
    public static final String SHAPE_CMD_RECT = "Rect";
    public static final String SHAPE_CMD_LINE = "Line";

    public static final String SHAPE_CMD_TRIANGLE = "Triangle";

    public static final String SHAPE_CMD_OVAL = "Oval";

    public static final String SHAPE_CMD_CIRCLE = "Circle";

    // state variables
    private Color currColor = Color.BLACK;

    // components
    JTextArea mouseHistory;
    PaintPanel canvas;

    public  PainterFrame(){
        initComponents();
        buildMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }

    private void initComponents() {
        BorderLayout layout = new BorderLayout();
        Container container = getContentPane();
        container.setLayout(layout);
        canvas = new PaintPanel(CANVAS_SIZE_X, CANVAS_SIZE_Y, Color.WHITE);

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

    void drawRect() {
        canvas.addRect(RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
                RandomUtils.getRandomInt(MIN_WIDTH, MAX_WIDTH),
                RandomUtils.getRandomInt(MIN_HEIGHT, MAX_HEIGHT),
                currColor
        );
    }

    void drawTriangle() {
         canvas.addTriangle(RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
                 RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
                 RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
                 currColor
         );
    }

    void drawLine() {
         canvas.addLine(RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
                 RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
                 currColor
         );
    }

    void drawOval() {
        canvas.addOval(RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
                RandomUtils.getRandomInt(MIN_WIDTH, MAX_WIDTH),
                RandomUtils.getRandomInt(MIN_HEIGHT, MAX_HEIGHT),
                currColor);
    }

    void drawCircle() {
       int random = RandomUtils.getRandomInt(MIN_WIDTH, MAX_WIDTH);
       canvas.addOval(RandomUtils.getRandomPoint(CANVAS_SIZE_X, CANVAS_SIZE_Y),
               random,
               random,
               currColor);
    }

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu creationSel = new JMenu("Add Shape");

        JMenu configSel = new JMenu("Config");
        JMenuItem color = new JMenuItem("Color");
        color.addActionListener(evt -> {
            currColor = JColorChooser.showDialog(null,"Choose Color", currColor);
        });
        creationSel.add(buildItem(SHAPE_CMD_RECT, al -> {
            drawRect();
            mouseHistory.append("add rectangle\n");
        }));
        creationSel.add(buildItem(SHAPE_CMD_TRIANGLE, al -> {
            drawTriangle();
            mouseHistory.append("add triangle\n");
        }));
        creationSel.add(buildItem(SHAPE_CMD_OVAL, al -> {
            drawOval();
            mouseHistory.append("add oval\n");
        }));
        creationSel.add(buildItem(SHAPE_CMD_LINE, al -> {
            drawLine();
            mouseHistory.append("add line\n");
        }));
        creationSel.add(buildItem(SHAPE_CMD_CIRCLE, al -> {
            drawCircle();
            mouseHistory.append("add circle\n");
        }));
        configSel.add(color);
        menuBar.add(creationSel);
        menuBar.add(configSel);
        setJMenuBar(menuBar);
    }

}
