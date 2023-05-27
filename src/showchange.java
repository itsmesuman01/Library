import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
        
// Main Class
public class showchange extends JFrame implements ActionListener
{
    private String uname, pwd ;
    private JButton button,button2,button3 ;
    private JFrame frame ;
    // Main Methods
    public static void main(String[]args)
    {
     showchange obj = new showchange() ;   
    }
    
    // Constructor
    showchange()
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
     
     button = new JButton("Show Password") ;
     button.setBounds(140, 150, 140, 30) ;
     button.setBackground(Color.white) ;
     panel2.add(button) ;
     button.addActionListener(this);
     
     button2 = new JButton("Change Password") ;
     button2.setBounds(140, 210, 140, 30) ;
     button2.setBackground(Color.white) ;
     panel2.add(button2) ;
     button2.addActionListener(this);
     
     button3 = new JButton("Back") ;
     button3.setBounds(165,270,90,20);
     button3.setBackground(Color.white) ;
     panel2.add(button3) ;
     button3.addActionListener(this);
     
     
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==button)
        {
            frame.dispose();
         forgetpassword sc = new forgetpassword() ;
        }
        if(ae.getSource()==button2)
        {
         frame.dispose();
         forgetpassword2 sc = new forgetpassword2() ;
        }
        if(ae.getSource()==button3)
        {
         frame.dispose();
         login sc = new login() ;
        } 
    }
}