import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
        
// Main Class
public class forgetpassword2 extends JFrame
{
    private JFrame frame ;
    private String uname ;
    private ResultSet rs ;
    private int count ;
    // Main Methods
    public static void main(String[]args)
    {
     forgetpassword2 obj = new forgetpassword2() ;   
    }
    
    // Constructor
    forgetpassword2()
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
     
     JLabel label0 = new JLabel(" Enter Your Username ") ;
     label0.setBounds(150, 90, 400, 100) ;
     label0.setForeground(Color.white) ;
     panel2.add(label0) ;
     
     JTextField field = new JTextField() ;
     field.setBounds(150, 180, 130,30) ;
     panel2.add(field) ;
     
     JButton button = new JButton("Click") ;
     button.setBounds(170, 230, 80,25) ;
     button.setBackground(Color.white) ;
     panel2.add(button) ;
     
     JButton button2 = new JButton("Back") ;
     button2.setBounds(170, 275, 80,25) ;
     button2.setBackground(Color.white) ;
     panel2.add(button2) ;

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
                                rs = s.executeQuery(query) ; 
                            
                            // Display Row
                            
                            while(rs.next())
                            {
                             String var = field.getText() ;
                             uname= rs.getString(2) ;
                             if(uname.equals(var))
                             {
                                    dispose();
                                    changepassword sc = new changepassword() ;
                                    
                             }
                            }
                        
                        field.setText("") ;
                        count ++ ;
                        if(count==5)
                        {
                            frame.dispose() ;
                        }
                        
                        
                        s.close() ;
                        c.close();
              }
              catch(Exception e)
              {
                  
              }
             
         }
     }) ;
     button2.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              showchange sc = new showchange() ;
          }
      }) ;
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
}