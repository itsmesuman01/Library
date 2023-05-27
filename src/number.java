import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
        
// Main Class
public class number extends JFrame
{
    private JFrame frame ;
    private String uname ;
    private ResultSet rs ;
    private int count ;
    // Main Methods
    public static void main(String[]args)
    {
     number obj = new number() ;   
    }
    
    // Constructor
    number()
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
     
     JLabel label0 = new JLabel(" Enter Your Number ") ;
     label0.setBounds(150, 90, 400, 100) ;
     label0.setForeground(Color.white) ;
     panel2.add(label0) ;
     
     JTextField field2 = new JTextField() ;
     field2.setBounds(150, 180, 130,30) ;
     panel2.add(field2) ;
     
     JLabel label10 = new JLabel("Your Password Will Appear Here ") ;
     label10.setBounds(125, 300, 210,30) ;
     label10.setForeground(Color.white) ;
     panel2.add(label10) ;
     
     // Hidden
     JLabel label12 = new JLabel("This Is Your Password ") ;
     label12.setBounds(143, 300, 210,30) ;
     label12.setForeground(Color.white) ;
     label12.setVisible(false) ;
     panel2.add(label12) ;
     
     JLabel label11 = new JLabel() ;
     label11.setBounds(180, 340, 130,30) ;
     label11.setForeground(Color.white) ;
     Font font = new Font("IMPACT",Font.PLAIN,20) ;
     label11.setFont(font) ;
     panel2.add(label11) ;
     
     JButton button = new JButton("Click") ;
     button.setBounds(170, 230, 80,25) ;
     button.setBackground(Color.white) ;
     panel2.add(button) ;
     
     JButton button2 = new JButton("Back") ;
     button2.setBounds(170, 270, 80,25) ;
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
                             String var = field2.getText() ;
                             uname= rs.getString(5) ;
                             if(uname.equals(var))
                             {
                                
                                    label11.setText(rs.getString(4)) ;
                                    label10.setVisible(false) ;
                                    label12.setVisible(true) ;    
                                    
                             }
                             // JOptionPane.showMessageDialog(null,"Sorry, Your Username Not Found ") ;
                            }
                        
                        field2.setText("") ;
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
              forgetpassword sc = new forgetpassword() ;
          }
      }) ;
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
}