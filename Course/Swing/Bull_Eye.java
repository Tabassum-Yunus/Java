import javax.swing.*;
import java.awt.*;

    class BullsEye extends JPanel {
        private static final int SIZE = 400;
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int centerX = getWidth() / 2;       // Returns the current width of this component
            int centerY = getHeight() / 2;      // Returns the current width of this component
            int radius = SIZE / 2;

            for (int i = 0; i < 5; i++) { 
                g.setColor(i % 2 == 0 ? Color.BLACK : Color.WHITE);           // even i -> black, odd i -> white
                g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
                radius = radius - SIZE / 10;        // 40 --> 200, 160, 120, 80, 40 
            }
        }
    }

public class Bull_Eye {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Bulls pattern");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500,500);
        jf.setVisible(true);
        BullsEye b = new BullsEye();
        jf.add(b);
    }
}