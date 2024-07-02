import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.JFrame;

class House extends JComponent{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawHouse(g);
        
    }
    public void drawHouse(Graphics g){
        g.drawRect(100, 100, 200, 120);     // House body
        g.drawLine(100, 100, 200, 50);          // Left side of roof
        g.drawLine(200, 50, 300, 100);          // Right side of roof
        g.drawRect(140, 150, 40, 70);       // Gate
        g.drawRect(210, 140, 60, 30);       // Window
    }
}

public class Draw_House {
    public static void main(String[] args) {
        JFrame frame = new JFrame("House Outline Drawing");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        House h = new House();
        frame.add(h);
        
    }
}
