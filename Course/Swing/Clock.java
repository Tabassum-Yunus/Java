package Week13_14;
  
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ClockPanel extends JPanel {
    private int hour = 0;
    private int minute = 0;

    public void setTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        repaint();      // repaint the clock component
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw clock face
        int centerX = getWidth() / 2;
        System.out.println("Width of window: "+getWidth());
        int centerY = getHeight() / 2;
        System.out.println("Height of window: "+getWidth());
        int radius = Math.min(centerX, centerY) - 10;
        
        System.out.println("centerX: "+centerX);
        System.out.println("centerY: "+centerY);
        System.out.println("Radius: "+radius);
        
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius); // x, y, width, height

        // Draw hands
        drawHand(g, centerX, centerY, radius - 40, hour * 30 + minute * 0.5);       // hour hand
        drawHand(g, centerX, centerY, radius - 10, minute * 6);                     // minute hand
    }

    private void drawHand(Graphics g, int x, int y, int length, double angle){
        double rad = Math.toRadians(angle - 90);        // 0 degrees is at 3 o'clock
        int endX = (int) (x + length * Math.cos(rad));
        int endY = (int) (y + length * Math.sin(rad));
        g.drawLine(x, y, endX, endY);
    }
}

public class Clock {
    public static void main(String[] args) {

            JFrame jf = new JFrame("Clock Application");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLayout(new BorderLayout());
            jf.setSize(500,500);
            jf.setVisible(true);
            
            ClockPanel clockPanel = new ClockPanel();
            jf.add(clockPanel, BorderLayout.CENTER);

            JPanel inputPanel = new JPanel();
            JLabel label = new JLabel("Enter the time in hh:mm");
            JTextField timeField = new JTextField(5);
            JButton submitButton = new JButton("OK");
            JButton cancelButton = new JButton("Cancel");

            inputPanel.add(label);
            inputPanel.add(timeField);
            inputPanel.add(submitButton, BorderLayout.SOUTH);
            inputPanel.add(cancelButton);
            jf.add(inputPanel, BorderLayout.NORTH);
            
            
//            ActionListener al = new ActionListener(){
//            @Override
//                public void actionPerformed(ActionEvent e) {
//                    String[] parts = timeField.getText().split(":");
//                    
//                    if (parts.length == 2) {
//                        try {
//                            int hour = Integer.parseInt(parts[0]);
//                            int minute = Integer.parseInt(parts[1]);
//                            clockPanel.setTime(hour, minute);
//                        } catch (NumberFormatException ex) {
//                            JOptionPane.showMessageDialog(jf, "Please enter a valid time format hh:mm");
//                        }
//                    }
//                }
//            };
//             submitButton.addActionListener(al);
        
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] parts = timeField.getText().split(":");
                    
                    if (parts.length == 2) {
                        try {
                            int hour = Integer.parseInt(parts[0]);
                            int minute = Integer.parseInt(parts[1]);
                            clockPanel.setTime(hour, minute);
                        } 
                        catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(jf, "Please enter a valid time format hh:mm");
                        }
                    }
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });


    }
}
