import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class job extends JFrame{

    job(){
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

        JLabel hmp = new JLabel("Job Details");
        hmp.setBounds(400,15,300,30);
        hmp.setFont(new Font("FreeSerif",Font.BOLD,20));
        hmp.setForeground(Color.BLACK);
        c.add(hmp);

        JLabel jn = new JLabel("Joining");
        jn.setBounds(550,100,200,30);
        jn.setFont(new Font("FreeSerif",Font.BOLD,20));
        jn.setForeground(Color.BLACK);
        c.add(jn);

        JTextField  jnt= new JTextField();
        jnt.setBounds(720,100,150,30);
        c.add(jnt);

        JLabel ds = new JLabel("Designation");
        ds.setBounds(550,145,200,30);
        ds.setFont(new Font("FreeSerif",Font.BOLD,20));
        ds.setForeground(Color.BLACK);
        c.add(ds);

        JTextField  dst= new JTextField();
        dst.setBounds(720,145,150,30);
        c.add(dst);


        JLabel dpt = new JLabel("Department");
        dpt.setBounds(550,190,200,30);
        dpt.setFont(new Font("FreeSerif",Font.BOLD,20));
        dpt.setForeground(Color.BLACK);
        c.add(dpt);

        JTextField dtt= new JTextField();
    dtt.setBounds(720,190,150,30);
        c.add(dtt);

        JLabel exp = new JLabel("Experience");
        exp.setBounds(550,235,200,30);
        exp.setFont(new Font("FreeSerif",Font.BOLD,20));
        exp.setForeground(Color.BLACK);
        c.add(exp);

        JTextField  expt= new JTextField();
        expt.setBounds(720,235,150,30);
        c.add(expt);

        JLabel dg = new JLabel("Degree");
        dg.setBounds(550,280,200,30);
        dg.setFont(new Font("FreeSerif",Font.BOLD,20));
        dg.setForeground(Color.BLACK);
        c.add(dg);

        JTextField  dgt= new JTextField();
        dgt.setBounds(720,280,150,30);
        c.add(dgt);

        JLabel mn = new JLabel("Employee Id");
        mn.setBounds(550,320,200,30);
        mn.setFont(new Font("FreeSerif",Font.BOLD,20));
        mn.setForeground(Color.BLACK);
        c.add(mn);

        JTextField  mt= new JTextField();
        mt.setBounds(720,320,150,30);
        c.add(mt);

        JButton submit = new JButton("submit");
        submit.setBounds(550,340,100,25);
        c.add(submit);

        JButton back = new JButton("Back");
        back.setBounds(750,340,100,25);
        c.add(back);

        submit.addActionListener(new ActionListener(){ 
           
            public void actionPerformed(ActionEvent e){
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_system","root","rahul123");

                    Statement stmt=con.createStatement();
                    String query = "insert into job_details values(" + mt.getText() + ",'" +jnt.getText()+ "','"+dst.getText()+"','"+dtt.getText()+"','"+expt.getText()+"','"+dgt.getText()+"')";
                    stmt.executeUpdate(query);

                    ResultSet rs = stmt.executeQuery("select * from job_details");
                    while (rs.next()) {

                        // New Student List

                        System.out.println("added");

                    }

                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
               salary sl = new salary();
            }  
            }); 

        ImageIcon bg = new ImageIcon("login.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,1000,500);
        c.add(label);

        back.addActionListener(new ActionListener(){ 
           
            public void actionPerformed(ActionEvent e){  
            contact cnt = new contact();
            }  
            });



        setVisible(true);

}
   
public static void main(String[] args) {
    job jb = new job();
   }
}