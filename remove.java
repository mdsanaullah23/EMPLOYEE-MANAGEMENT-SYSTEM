import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class remove extends JFrame{

    remove(){
        // setSize(500, 500);
        
        setTitle("EMPLOYEE MANAGEMENT SYSTEM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100,50);
        setBounds(100,100,1000,530);
        setResizable(false);

        

        ImageIcon icon = new ImageIcon("E.png");
        setIconImage(icon.getImage());

        Container c = getContentPane();
        c.setLayout(null);

        JLabel rmp = new JLabel("Remove Employee");
        rmp.setBounds(350,15,200,30);
        rmp.setFont(new Font("FreeSerif",Font.BOLD,20));
        rmp.setForeground(Color.BLACK);
        c.add(rmp);

        JLabel bs = new JLabel("Enter Employee ID");
        bs.setBounds(500,100,200,30);
        bs.setFont(new Font("FreeSerif",Font.BOLD,15));
        bs.setForeground(Color.BLACK);
        c.add(bs);

        JTextField  bse= new JTextField();
        bse.setBounds(650,100,100,25);
        c.add(bse);

        JButton search = new JButton("SEARCH");
        search.setBounds(780,100,100,25);
        search.setBackground(Color.white);
        search.setOpaque(true);
        c.add(search);

        JLabel name = new JLabel("Name");
        name.setBounds(520,150,80,20);
        name.setForeground(Color.BLACK);
        c.add(name);

        JLabel name_l = new JLabel();
        name_l.setBounds(600,150,100,20);
        name_l.setForeground(Color.BLACK);
        c.add(name_l);

        JLabel eid = new JLabel("Emp ID");
        eid.setBounds(520,170,80,20);
        eid.setForeground(Color.BLACK);
        c.add(eid);

        JLabel eid_l = new JLabel();
        eid_l.setBounds(600,170,100,20);
        eid_l.setForeground(Color.BLACK);
        c.add(eid_l);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(520,190,80,20);
        gender.setForeground(Color.BLACK);
        c.add(gender);

        JLabel gender_l = new JLabel();
        gender_l.setBounds(600,190,100,20);
        gender_l.setForeground(Color.BLACK);
        c.add(gender_l);

        JLabel joining = new JLabel("Joining");
        joining.setBounds(520,210,80,20);
        joining.setForeground(Color.BLACK);
        c.add(joining);

        JLabel joining_l = new JLabel();
        joining_l.setBounds(600,210,100,20);
        joining_l.setForeground(Color.BLACK);
        c.add(joining_l);

        JLabel desgn = new JLabel("Designation");
        desgn.setBounds(520,230,80,20);
        desgn.setForeground(Color.BLACK);
        c.add(desgn);

        JLabel desgn_l = new JLabel();
        desgn_l.setBounds(600,230,100,20);
        desgn_l.setForeground(Color.BLACK);
        c.add(desgn_l);

        JLabel dept = new JLabel("Department");
        dept.setBounds(520,250,80,20);
        dept.setForeground(Color.BLACK);
        c.add(dept);

        JLabel dept_l = new JLabel();
        dept_l.setBounds(600,250,100,20);
        dept_l.setForeground(Color.BLACK);
        c.add(dept_l);

        JLabel phn = new JLabel("Phone NO");
        phn.setBounds(520,270,80,20);
        phn.setForeground(Color.BLACK);
        c.add(phn);

        JLabel phn_l = new JLabel();
        phn_l.setBounds(600,270,100,20);
        phn_l.setForeground(Color.BLACK);
        c.add(phn_l);

        JLabel nsal = new JLabel("Net Sal");
        nsal.setBounds(520,290,80,20);
        nsal.setForeground(Color.BLACK);
        c.add(nsal);

        JLabel nsal_l = new JLabel();
        nsal_l.setBounds(600,290,100,20);
        nsal_l.setForeground(Color.BLACK);
        c.add(nsal_l);


        


        

       

       

        

        JButton remove = new JButton("remove");
        remove.setBounds(550,340,100,25);
        c.add(remove);

        JButton cancel = new JButton("cancel");
        cancel.setBounds(750,340,100,25);
        c.add(cancel);

        
        ImageIcon bg = new ImageIcon("login.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,1000,500);
        c.add(label);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_system","root","rahul123");

                    Statement stmt=con.createStatement();

                    ResultSet rs = stmt.executeQuery("select * from emp_detail ");
                    while (rs.next()) {
                        if(rs.getInt(2)==Integer.parseInt(bse.getText())){
                            name_l.setText(rs.getString(1));
                            eid_l.setText(String.valueOf(rs.getInt(2)));
                            gender_l.setText(rs.getString(3));
                            phn_l.setText(String.valueOf(rs.getInt(4)));

                        }
                    }
                    ResultSet rs1 = stmt.executeQuery("select * from job_details");
                    while (rs1.next()) {
                        if(rs1.getInt(1)==Integer.parseInt(bse.getText())){
                            joining_l.setText(rs1.getString(2));
                            desgn_l.setText(rs1.getString(3));
                            dept_l.setText(rs1.getString(4));
                        }
                    }
                    ResultSet rs2 = stmt.executeQuery("select * from salary_dtls");
                    while (rs2.next()) {
                        if(rs2.getInt(1)==Integer.parseInt(bse.getText())){
                            nsal_l.setText(String.valueOf(rs2.getInt(5)));

                        }
                    }

                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        remove.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                int s_id=Integer.parseInt(bse.getText());
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_system", "root", "rahul123");

                    Statement stmt = con.createStatement();

                    ResultSet rs = stmt.executeQuery("select * from emp_detail ");
                    while (rs.next()) {
                        if (rs.getInt(2) == s_id) {
                            String query="delete from emp_detail where eid="+s_id;
                            stmt.executeUpdate(query);

                            name_l.setText(" ");
                            eid_l.setText(" ");
                            gender_l.setText(" ");
                            joining_l.setText(" ");
                            desgn_l.setText(" ");
                            dept_l.setText(" ");
                            phn_l.setText(" ");
                            nsal_l.setText(" ");

                        }
                    }
                }
                    catch (Exception e2){
                        e2.printStackTrace();
                    }

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
    remove rv = new remove();
   }
}