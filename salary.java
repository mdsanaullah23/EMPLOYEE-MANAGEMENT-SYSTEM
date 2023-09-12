import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class salary extends JFrame{

    salary(){
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

        JLabel hmp = new JLabel("Salary Details");
        hmp.setBounds(400,15,200,30);
        hmp.setFont(new Font("FreeSerif",Font.BOLD,20));
        hmp.setForeground(Color.BLACK);
        c.add(hmp);

        JLabel bs = new JLabel("Basic salary");
        bs.setBounds(550,100,200,30);
        bs.setFont(new Font("FreeSerif",Font.BOLD,20));
        bs.setForeground(Color.BLACK);
        c.add(bs);

        JTextField  bse= new JTextField();
        bse.setBounds(720,100,150,30);
        c.add(bse);

        JLabel pf = new JLabel("Provident Fund");
        pf.setBounds(550,145,200,30);
        pf.setFont(new Font("FreeSerif",Font.BOLD,20));
        pf.setForeground(Color.BLACK);
        c.add(pf);

        JTextField  pft= new JTextField();
        pft.setBounds(720,145,150,30);
        c.add(pft);


        JLabel od = new JLabel("Other Deduction");
        od.setBounds(550,190,200,30);
        od.setFont(new Font("FreeSerif",Font.BOLD,20));
        od.setForeground(Color.BLACK);
        c.add(od);

        JTextField  odt= new JTextField();
        odt.setBounds(720,190,150,30);
        c.add(odt);

        JLabel ns = new JLabel("Net Salary");
        ns.setBounds(550,235,200,30);
        ns.setFont(new Font("FreeSerif",Font.BOLD,20));
        ns.setForeground(Color.BLACK);
        c.add(ns);

        JTextField nst= new JTextField();
        nst.setBounds(720,235,150,30);
        c.add(nst);


        JLabel mn = new JLabel("Employee Id");
        mn.setBounds(550,300,200,30);
        mn.setFont(new Font("FreeSerif",Font.BOLD,20));
        mn.setForeground(Color.BLACK);
        c.add(mn);

        JTextField  mt= new JTextField();
        mt.setBounds(720,300,150,30);
        c.add(mt);

        JButton submit = new JButton("submit");
        submit.setBounds(550,340,100,25);
        c.add(submit);

        JButton back = new JButton("Back");
        back.setBounds(750,340,100,25);
        c.add(back);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(750,380,100,25);
        c.add(cancel);

        // Font font = new Font("Island Moments",Font.BOLD,30);
        // label.setFont(font);

        ImageIcon bg = new ImageIcon("login.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,1000,500);
        c.add(label);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_system","root","rahul123");

                    Statement stmt=con.createStatement();
                    String query = "insert into salary_dtls values(" + mt.getText() + "," +bse.getText()+ ","+pft.getText()+","+odt.getText()+","+nst.getText()+")";
                    stmt.executeUpdate(query);

                    ResultSet rs = stmt.executeQuery("select * from salary_dtls");
                    while (rs.next()) {

                        // New Student List

                        System.out.println("added");

                    }

                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        back.addActionListener(new ActionListener(){ 
           
            public void actionPerformed(ActionEvent e){  
            job jb = new job(); 
            }  
            });

        cancel.addActionListener(new ActionListener(){ 
           public void actionPerformed(ActionEvent e){  
            dispose(); 
            }  
            });
    


        setVisible(true);

}
   
public static void main(String[] args) {
    salary sl = new salary();
   }
}