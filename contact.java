import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class contact extends JFrame{

    contact(){
        setSize(500, 500);
        
        setTitle("EMPLOYEE MANAGEMENT SYSTEM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100,50);
        setBounds(100,100,1000,530);
        setResizable(false);

        

        ImageIcon icon = new ImageIcon("E.png");
        setIconImage(icon.getImage());

        Container c = getContentPane();
        c.setLayout(null);

        JLabel cnt = new JLabel("Contact Details");
        cnt.setBounds(400,15,200,30);
        cnt.setFont(new Font("FreeSerif",Font.BOLD,20));
        cnt.setForeground(Color.BLACK);
        c.add(cnt);

        JLabel ph = new JLabel("Phone");
        ph.setBounds(550,100,200,30);
        ph.setFont(new Font("FreeSerif",Font.BOLD,20));
        ph.setForeground(Color.BLACK);
        c.add(ph);

        JTextField  bse= new JTextField();
        bse.setBounds(720,100,150,30);
        c.add(bse);

        JLabel tlp = new JLabel("Telephone");
        tlp.setBounds(550,145,200,30);
        tlp.setFont(new Font("FreeSerif",Font.BOLD,20));
        tlp.setForeground(Color.BLACK);
        c.add(tlp);

        JTextField  pft= new JTextField();
        pft.setBounds(720,145,150,30);
        c.add(pft);


        JLabel email = new JLabel("E-MAIL");
        email.setBounds(550,190,200,30);
        email.setFont(new Font("FreeSerif",Font.BOLD,20));
        email.setForeground(Color.BLACK);
        c.add(email);

        JTextField  odt= new JTextField();
        odt.setBounds(720,190,150,30);
        c.add(odt);

        JLabel ads = new JLabel("Address");
        ads.setBounds(550,235,200,30);
        ads.setFont(new Font("FreeSerif",Font.BOLD,20));
        ads.setForeground(Color.BLACK);
        c.add(ads);

        JTextField nst= new JTextField();
        nst.setBounds(720,235,150,30);
        c.add(nst);

        JLabel mn = new JLabel("Employee Id");
        mn.setBounds(550,270,200,30);
        mn.setFont(new Font("FreeSerif",Font.BOLD,20));
        mn.setForeground(Color.BLACK);
        c.add(mn);

        JTextField  mt= new JTextField();
        mt.setBounds(720,270,150,30);
        c.add(mt);

        JButton submit = new JButton("submit");
        submit.setBounds(550,340,100,25);
        c.add(submit);

        JButton back = new JButton("Back");
        back.setBounds(750,340,100,25);
        c.add(back);

        ImageIcon bg = new ImageIcon("login.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,1000,500);
        c.add(label);

        submit.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_system","root","rahul123");

                    Statement stmt=con.createStatement();
                    String query = "insert into contact_details values(" + mt.getText() + "," +bse.getText()+ ","+pft.getText()+",'"+odt.getText()+"','"+nst.getText()+"')";
                    stmt.executeUpdate(query);

                    ResultSet rs = stmt.executeQuery("select * from contact_details");
                    while (rs.next()) {

                        // New Student List

                        System.out.println("added");

                    }

                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            job jb = new job();
            dispose(); 
            }  
         });

        back.addActionListener(new ActionListener(){ 
           public void actionPerformed(ActionEvent e){  
            addemp ae = new addemp(); 
            }  
        });



        setVisible(true);

}
   
public static void main(String[] args) {
    contact cnt = new contact();
   }
}