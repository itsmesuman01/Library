import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
import java.awt.event.* ;
        
// Main Class
public class changepassword2 extends JFrame
{
   private JFrame frame ;
   private JLabel label3,label4 ;
   private JTextField field3,field4 ;
   private String var, var2 ;
   private JButton button, button2 ;
   private String pwd ;
    public static void main(String[]args)
    {
     changepassword2 obj = new changepassword2() ;   
    } 
    // Constructor
    changepassword2()
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

     label3 = new JLabel("New Password") ;
     label3.setBounds(50, 120, 100,100) ;
     label3.setForeground(Color.white) ;
     panel2.add(label3);
     
     field3 = new JTextField() ;
     field3.setBounds(160,155,160,30) ;
     panel2.add(field3);
     
     label4 = new JLabel("Confirm Password") ;
     label4.setBounds(50, 180, 120,100) ;
     label4.setForeground(Color.white) ;
     panel2.add(label4);
     
     field4 = new JTextField() ;
     field4.setBounds(160,215,160,30) ;
     panel2.add(field4);
     
     
     button = new JButton("SUBMIT") ;
     button.setBounds(195, 265, 90, 30) ;
     button.setBackground(Color.white) ;
     panel2.add(button);
     
     button2 = new JButton("Return") ;
     button2.setBounds(195, 300, 90, 30) ;
     button2.setBackground(Color.white) ;
     panel2.add(button2);

     
     button.addActionListener(new ActionListener()
     {
     public void actionPerformed(ActionEvent ae)
    {
     var = field3.getText() ;
     var2 = field4.getText() ;
     if( var.equals(var2))
     {
         if(var2.equals(""))
         {
           JOptionPane.showMessageDialog(null," Empty !!! ") ;   
         }
         else
         {
         try
         {
         conn sc = new conn();
                        String query="UPDATE register SET pwd=? WHERE id=1  " ;
                        PreparedStatement st = sc.c.prepareStatement(query);   
                             st.setString(1,field4.getText()) ;
                             st.executeUpdate() ;
                            
                        st.close() ;
                        sc.c.close();  
                        JOptionPane.showMessageDialog(null," Successfully Updated") ;
         }
         catch(Exception e)
         {
             
         }
         }
     
     
     
     field3.setText("") ;
     field4.setText("") ;
     }
     else
     {
         JOptionPane.showMessageDialog(null," Not Match ") ;
         field3.setText("") ;
         field4.setText("") ;
     }
    }});
     button2.addActionListener(new ActionListener()
     {
     public void actionPerformed(ActionEvent ae)
    {
     dispose() ;
     login sc = new login() ;
    }});
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
}
}