import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addemp extends JFrame{

    addemp(){
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

//        JPanel

        JLabel hmp = new JLabel("Employee Personal Details");
        hmp.setBounds(400,15,300,30);
        hmp.setFont(new Font("FreeSerif",Font.BOLD,20));
        hmp.setForeground(Color.BLACK);
        c.add(hmp);

        JLabel nm = new JLabel("Name");
        nm.setBounds(550,100,200,30);
        nm.setFont(new Font("FreeSerif",Font.BOLD,20));
        nm.setForeground(Color.BLACK);
        c.add(nm);

        JTextField  nt= new JTextField();
        nt.setBounds(720,100,150,30);
        c.add(nt);

        JLabel mn = new JLabel("Employee Id");
        mn.setBounds(550,145,200,30);
        mn.setFont(new Font("FreeSerif",Font.BOLD,20));
        mn.setForeground(Color.BLACK);
        c.add(mn);

        JTextField  mt= new JTextField();
        mt.setBounds(720,145,150,30);
        c.add(mt);


        JLabel fn = new JLabel("Gender");
        fn.setBounds(550,190,200,30);
        fn.setFont(new Font("FreeSerif",Font.BOLD,20));
        fn.setForeground(Color.BLACK);
        c.add(fn);

        JTextField  ft= new JTextField();
        ft.setBounds(720,190,150,30);
        c.add(ft);

        JLabel no = new JLabel("Phone Number");
        no.setBounds(550,235,200,30);
        no.setFont(new Font("FreeSerif",Font.BOLD,20));
        no.setForeground(Color.BLACK);
        c.add(no);

        JTextField  pt= new JTextField();
        pt.setBounds(720,235,150,30);
        c.add(pt);

        JLabel db = new JLabel("DOB");
        db.setBounds(550,280,200,30);
        db.setFont(new Font("FreeSerif",Font.BOLD,20));
        db.setForeground(Color.BLACK);
        c.add(db);

        JTextField  dbt= new JTextField();
        dbt.setBounds(720,280,150,30);
        c.add(dbt);

        JButton submit = new JButton("submit");
        submit.setBounds(550,340,100,25);
        c.add(submit);

        JButton back = new JButton("Back");
        back.setBounds(750,340,100,25);
        c.add(back);

        submit.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
//                String un = nt.getText();
//                String pa = String.valueOf(rollt.getText());


                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","rahul123");

                    Statement stmt=con.createStatement();

                    ResultSet rs = stmt.executeQuery("select * from emp_system.emp_detail");
                    while (rs.next()) {

                        // New Student List
                            String query = "insert into emp_system.emp_detail values('" + String.valueOf(nt.getText()) + "'," +mt.getText()+ ",'"+String.valueOf(ft.getText())+"',"+pt.getText()+",'"+String.valueOf(ft.getText())+"')";
                            stmt.executeUpdate(query);
                            System.out.println("added");

                        }

                }
                catch (Exception e1){
                    e1.printStackTrace();
                }

               dispose(); 
               contact cnt = new contact();
            }  
            }); 

        ImageIcon bg = new ImageIcon("login.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,1000,500);
        c.add(label);

        back.addActionListener(new ActionListener(){ 
           
            public void actionPerformed(ActionEvent e){  
            home hm = new home(); 
            
            }
            });



        setVisible(true);

}
   
public static void main(String[] args) {
    addemp ae = new addemp();
   }
}