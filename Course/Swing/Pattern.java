import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class DrawPanel extends JPanel {
        private static final int DIAMETER = 90;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            int padding = 20;
            int startX = padding;
            int startY = padding;
            int gap = 20;

            for (int row = 0; row < 3; row++) {             // 3x3 pattern of circles
                for (int col = 0; col < 3; col++) {
                    int x = startX + col * (DIAMETER + gap);
                    int y = startY + row * (DIAMETER + gap);
                    
                    if (row == col) {                                  // solid circles
                        g.setColor(Color.BLACK);
                        g.fillOval(x, y, DIAMETER, DIAMETER);
                    } 
                    else {
                        g.setColor(Color.BLACK);
                        g.drawOval(x, y, DIAMETER, DIAMETER);
//                        g.setColor(Color.WHITE);
//                        g.fillOval(x, y, DIAMETER, DIAMETER);
                    }
                }
            }
        }
    }

public class Pattern {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Circle pattern");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,400);
        jf.setVisible(true);
        DrawPanel d = new DrawPanel();
        jf.add(d);
    }
}
