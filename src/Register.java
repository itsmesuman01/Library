import javax.swing.* ;  
import java.awt.* ;
import java.awt.event.*;
import java.sql.PreparedStatement;
        
// Main Class
public class Register extends JFrame
{
    private JFrame frame ;
    // Main Methods
    public static void main(String[]args)
    {
     Register obj = new Register() ;
    }
    
    // Constructor
    public Register()
    {
     JDialog.setDefaultLookAndFeelDecorated(true);
     ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\Documents\\NetBeansProjects\\LMS\\image\\book.jpg") ;
     frame = new JFrame() ;
     setSize(600,600) ;
     setLocationRelativeTo(null); 
     
     // JPanel
     JPanel panel = new JPanel() ;
     panel.setBackground(Color.decode("#5E2B0F")) ;
     
     
     // JPanle 2
     JPanel panel2 = new JPanel() ;
     panel2.setBounds(80,80,417,400) ;
     panel2.setBackground(Color.decode("#84421E"));
     
     JLabel myLevel = new JLabel(icon) ;
     myLevel.setBounds(0,0,417,400);
     // panel2.add(myLevel) ;
     
     // Components
     
     JLabel label0 = new JLabel("Username") ;
     label0.setBounds(150, 90, 100, 100) ;
     label0.setForeground(Color.white) ;
     
     JTextField field0 = new JTextField() ;
     field0.setBounds(230,125,160,30) ;
     
     JLabel label = new JLabel("Name") ;
     label.setBounds(150, 150, 100,100) ;
     label.setForeground(Color.white) ;
     
     JTextField field = new JTextField() ;
     field.setBounds(230,185,160,30) ;
     
     JLabel label2 = new JLabel("Password") ;
     label2.setBounds(150, 210, 100,100) ;
     label2.setForeground(Color.white) ;
     
     JTextField field2 = new JTextField() ;
     field2.setBounds(230,245,160,30) ;
     
     JLabel label3 = new JLabel("Number") ;
     label3.setBounds(150, 270, 100,100) ;
     label3.setForeground(Color.white) ;
     
     JTextField nfield = new JTextField() ;
     nfield.setBounds(230, 300, 160,30) ;
     
     JLabel label4 = new JLabel("Secret Key") ;
     label4.setBounds(150, 330, 100,100) ;
     label4.setForeground(Color.white) ;
     
     JTextField skeyfield = new JTextField() ;
     skeyfield.setBounds(230, 355, 160,30) ;
     
     JButton button = new JButton("Create") ;
     button.setBounds(180, 420, 80,30);
     button.setBackground(Color.white) ;
     
     JButton button2 = new JButton("Back") ;
     button2.setBounds(280, 420, 80,30);
     button2.setBackground(Color.white) ;
     
     button.addActionListener(new ActionListener()
     {
         @Override
         public void actionPerformed(ActionEvent ae)
         {
                String a= field0.getText() ;
                String b= field.getText() ;
                String c= field2.getText() ;
                String d= nfield.getText() ;
                String e= skeyfield.getText() ;
             if((a.equals(""))||(b.equals(""))||(c.equals(""))||(d.equals(""))||(e.equals("")))
                {
                    JOptionPane.showMessageDialog(null, "Something is Missing");
                }
             else
             {
             try
             {
               
               conn sc = new conn();
               String sqll = "DELETE FROM register" ;
               PreparedStatement stt = sc.c.prepareStatement(sqll);
               stt.executeUpdate() ;
               
               String sql="insert into register(id,uname,name,pwd,num,secretkey) values(1,?,?,?,?,?)" ;
               PreparedStatement st = sc.c.prepareStatement(sql);
               st.setString(1, field0.getText());
               st.setString(2, field.getText());
	       st.setString(3, field2.getText());
	       st.setString(4, nfield.getText());
               st.setString(5, skeyfield.getText());
               
               
               int i = st.executeUpdate();
	       if (i > 0){
                          JOptionPane.showMessageDialog(null, "Successfully Created");
                         }
                field0.setText("");
                field.setText("");
		field2.setText("");
                nfield.setText("");
                skeyfield.setText("");
                
           
              }
             catch(Exception ee)
             {
              System.out.println(ee)  ;
             }
         }
         }
     });
     
     button2.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              login sc = new login() ;
          }
          
      }) ;
     
     
     
     
     
     // Adding to JFrame
     add(label0) ;
     add(field0) ;
     add(label) ;
     add(field) ;
     add(label2) ;
     add(field2) ;    
     add(label3) ;
     add(nfield) ;
     add(label4) ;
     add(skeyfield) ;
     add(button) ;
     add(button2);
     add(panel2) ;
     add(panel) ;
     
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
}