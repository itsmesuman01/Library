import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
import java.awt.event.* ;
        
// Main Class
public class changepassword extends JFrame
{
   private JFrame frame ;
   private JLabel label ;
   private JTextField field ;
   private JButton button,button2 ;
   private String pwd ;
    public static void main(String[]args)
    {
     changepassword obj = new changepassword() ;   
    }
    
    // Constructor
    changepassword()
    {
     JDialog.setDefaultLookAndFeelDecorated(true);
     frame = new JFrame() ;
     setSize(600,600) ;
     setLocationRelativeTo(null); 
     
     // JPanel
     JPanel panel = new JPanel() ;
     panel.setLayout(null) ;
     panel.setBackground(Color.decode("#5E2B0F")) ;
     add(panel) ;
     // JPanle 2
     JPanel panel2 = new JPanel() ;
     panel2.setLayout(null) ;
     panel2.setBounds(80,80,417,400) ;
     panel2.setBackground(Color.decode("#84421E"));
     panel.add(panel2) ;
     
     label = new JLabel("Password") ;
     label.setBounds(90, 120, 100,100) ;
     label.setForeground(Color.white) ;
     panel2.add(label);
     
     field = new JTextField() ;
     field.setBounds(160,155,160,30) ;
     panel2.add(field);
     
     button = new JButton("ENTER") ;
     button.setBounds(190, 230, 90, 30) ;
     button.setBackground(Color.white) ;
     panel2.add(button);
     
     button2 = new JButton("Back") ;
     button2.setBounds(190, 270, 90, 30) ;
     button2.setBackground(Color.white) ;
     panel2.add(button2);
    

     button.addActionListener(new ActionListener()
     {
     public void actionPerformed(ActionEvent ae)
    {
         try
              {
                  Class.forName("com.mysql.cj.jdbc.Driver");  
                        Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");    
                        Statement s = c.createStatement();
                        String query="select * from register" ;
                                ResultSet rs = s.executeQuery(query) ; 
                            
                            // Display Row
                            
                            while(rs.next())
                            {
                                
                             pwd = rs.getString(4) ;
                            }
                        s.close() ;
                        c.close();
              }
              catch(Exception e)
              {
                  
              }
             
              String l1 = field.getText() ;
              
              if(l1.equals(pwd))
              {
               dispose();
               changepassword2 sc = new changepassword2() ;
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"Wrong Password");
              }
    }});
     
     button2.addActionListener(new ActionListener()
     {
     public void actionPerformed(ActionEvent ae)
    {
         forgetpassword2 sc = new forgetpassword2() ;
    }});
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
 
}
}