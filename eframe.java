import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class eframe extends JFrame{

   
        eframe(){

        123
        setTitle("EMPLOYEE MANAGEMENT SYSTEM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100,50);
        setBounds(100,100,1000,530);
        setResizable(false);

        ImageIcon icon = new ImageIcon("E.png");
        setIconImage(icon.getImage());

        Container c = getContentPane();
        c.setLayout(null);

        JLabel un = new JLabel("Username");
        un.setBounds(550,150,200,30);
        un.setFont(new Font("FreeSerif",Font.BOLD,20));
        un.setForeground(Color.BLACK);
        c.add(un);

        JTextField unt = new JTextField();
        unt.setBounds(550,180,200,30);
        c.add(unt);

        JLabel ps = new JLabel("Password");
        ps.setBounds(550,240,200,30);
        ps.setFont(new Font("FreeSerif",Font.BOLD,20));
        ps.setForeground(Color.BLACK);
        c.add(ps);

        JTextField psw = new JTextField();
        psw.setBounds(550,270,200,30);
        c.add(psw);

        JButton login = new JButton("Login");
        login.setBounds(600,350,100,25);
        c.add(login);

        ImageIcon bg = new ImageIcon("login.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,1000,500);
        c.add(label);


        login.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                String un = unt.getText();
                String pa = String.valueOf(psw.getText());

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","rahul123");

                    Statement stmt=con.createStatement();

//step4 execute query
                    ResultSet rs=stmt.executeQuery("select * from emp_system.login");
                    while(rs.next()){

                        if(un.equals(rs.getString(1)) && pa.equals(rs.getString(2))) {

                            System.out.println("login sucessful");
                            JOptionPane.showMessageDialog(c,"Login Successful");
                            home hm = new home();
                        }
                        else if (rs.isLast()){
                            JOptionPane.showMessageDialog(c,"Try Again","Alert",JOptionPane.WARNING_MESSAGE);
                            System.out.println("Try again");

                        }

                    }
//step5 close the connection object
                    con.close();

                }catch(Exception e2){ System.out.println(e2);}

            }
            });  


        setVisible(true);

}
   
public static void main(String[] args) {
    eframe ef = new eframe();
   }
}