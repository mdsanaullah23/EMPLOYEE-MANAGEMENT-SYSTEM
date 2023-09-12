import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.*;  

public class home extends JFrame{

    private JButton login;
    private JTextField text;
    

    home(){
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

        JLabel hmp = new JLabel("Homepage");
        hmp.setBounds(400,15,200,30);
        hmp.setFont(new Font("FreeSerif",Font.BOLD,20));
        hmp.setForeground(Color.BLACK);
        c.add(hmp);


        JButton ae = new JButton("Add Employee");
        ae.setBounds(600,150,200,25);
        c.add(ae);

        JButton rm = new JButton("Remove Employee");
        rm.setBounds(600,200,200,25);
        c.add(rm);

        JButton ue = new JButton("Update Employee");
        ue.setBounds(600,250,200,25);
        c.add(ue);

        JButton ds = new JButton("Disployee Employee");
        ds.setBounds(600,300,200,25);
        c.add(ds);

        ae.addActionListener(new ActionListener(){ 
           
            public void actionPerformed(ActionEvent e){  
               dispose(); 
               addemp ae = new addemp();
            }  
            });  

        rm.addActionListener(new ActionListener(){ 
            
            public void actionPerformed(ActionEvent e){  
            remove rv = new remove();
            }  
            }); 

        ue.addActionListener(new ActionListener(){ 
            
            public void actionPerformed(ActionEvent e){
            dispose();
                updateemp uemp = new updateemp();
            }  
            });   
            
            
        ds.addActionListener(new ActionListener(){ 
           
            public void actionPerformed(ActionEvent e){  
            dispose();
                displayemp demp = new displayemp();
            }  
            });

        ImageIcon bg = new ImageIcon("login.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,1000,500);
        c.add(label);

        setVisible(true);

}
   
public static void main(String[] args) {
    home hm = new home();
   }
}