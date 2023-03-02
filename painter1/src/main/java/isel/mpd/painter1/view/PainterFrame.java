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

import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
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
    JTextArea mouseHistory;
    PaintPanel canvas;

    public  PainterFrame(App app){
        initComponents();
        buildMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }

    private  class PaintMouselistener extends  MouseAdapter {
        public void mousePressed(MouseEvent me) {
            // TODO
        }

        public void mouseDragged(MouseEvent me) {
            // TODO
        }

        public void mouseReleased(MouseEvent me) {
            // TODO
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

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu creationSel = new JMenu("Add Shape");

        // TO COMPLETE

        JMenu configSel = new JMenu("Config");
        JMenuItem color = new JMenuItem("Color");
        color.addActionListener(evt -> {
            currColor = JColorChooser.showDialog(null,"Choose Color", currColor);
        });
        configSel.add(color);
        menuBar.add(creationSel);
        menuBar.add(configSel);
        setJMenuBar(menuBar);
    }

}
