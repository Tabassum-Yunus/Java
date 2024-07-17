 package Assignment;

import Practice.Swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;


public class Aq15_Store_Dlt_fromDB {
    public static void main(String[] args) {
        JFrame jf = new JFrame("My DB Example");
        jf.setVisible(true);
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlbl1 = new JLabel("Student Name: ");
        JTextField jtxt1 = new JTextField(10);
        JLabel jlbl2 = new JLabel("ID: ");
        JTextField jtxt2 = new JTextField(10);
        JButton store = new JButton("Store");
        JButton delete = new JButton("Delete");
        jf.add(jlbl1);
        jf.add(jtxt1);
        jf.add(jlbl2);
        jf.add(jtxt2);
        jf.add(store);
        jf.add(delete);
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Tabassum-Yunus:1521:XE", "system", "system");
            Statement stmt = conn.createStatement();
            
            if(conn != null){
                System.out.println("conn established");
            }
//            String name = jtxt1.getText();
//            String id = jlbl2.getText();
            
            ActionListener al = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                    String query = "INSERT INTO Student(Sname, Sid) VALUES(?,?)";
                    try{
                        PreparedStatement ps=conn.prepareStatement(query);
                        
                        ps.setString(1,jtxt1.getText());
                        ps.setString(2,jtxt2.getText());
                        ps.executeQuery();
                    }
                    catch(SQLException s){
                        System.out.println("can't execute Query");
                    }
                }
            };
            store.addActionListener(al);

            
            ActionListener all = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                    String query = "DELETE FROM Student WHERE Sname = ?  AND Sid = ? ";
                    try{
                        PreparedStatement ps = conn.prepareStatement(query);
                        
                        ps.setString(1,jtxt1.getText());
                        ps.setString(2,jtxt2.getText());
                        ps.executeQuery();
                    }
                    catch(SQLException s){
                        System.out.println("can't execute Query");
                    }
                }
            };
            store.addActionListener(all);
        }
        
        catch(SQLException s){
            System.out.println(s.getMessage());
        }
    }
}


// CREATE TABLE Student(Sname varchar2(20), Sid varchar2(10));
// INSERT INTO Student VALUES('jerry', 'g12');
// INSERT INTO Student VALUES('oreo', 'g123');
// INSERT INTO Student VALUES('denny', 'g1234');



