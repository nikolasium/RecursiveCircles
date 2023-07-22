import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class RecursiveCircle extends JFrame {

    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static final int MAX_DEPTH = 6;
    private static final int radius = 100;

    public RecursiveCircle() {
/*
        Set Frame settings
*/
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        var panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);                                      // 200
                //drawRecursiveCircles(g, WIDTH / 2, HEIGHT / 2, 80, MAX_DEPTH);
                drawRecursiveCircles(g, getWidth() / 2, getHeight() / 2, radius, MAX_DEPTH);
            }

            private void drawRecursiveCircles(Graphics g, int x, int y, int radius, int depth) {
                if (depth == 0) {
                    return;
                }

                //g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
                g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

                int newRadius = radius / 2;

                drawRecursiveCircles(g, x + radius + newRadius / 2, y, newRadius, depth - 1);
                drawRecursiveCircles(g, x - radius - newRadius / 2, y, newRadius, depth - 1);
                drawRecursiveCircles(g, x, y + radius + newRadius / 2, newRadius, depth - 1);
                drawRecursiveCircles(g, x, y - radius - newRadius / 2, newRadius, depth - 1);

            }
        };
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        //panel.setBackground(Color.GREEN);
        add(panel);
        pack();
        setVisible(true);
    }

}
