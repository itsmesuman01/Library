import javax.swing.* ;  
import java.awt.* ;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate ;
        
// Main Class
public class bookreturn extends JFrame
{
    private JFrame frame ;
    private LocalDate date ;
    private int iddd ;
    private String snamep, snamep2 ;
    
    // Main Methods
    public static void main(String[]args)
    {
     bookreturn obj = new bookreturn() ;   
    }
    
    // Constructor
    public bookreturn()
    {
     JDialog.setDefaultLookAndFeelDecorated(true);
     date = LocalDate.now() ;
     
     frame = new JFrame() ;
     setSize(600,600) ;
     setLocationRelativeTo(null); 
     
     // JPanel
     JPanel panel = new JPanel() ;
     panel.setLayout(null) ;
     panel.setBackground(Color.decode("#5E2B0F")) ;
     
     JButton logout = new JButton("LOGOUT") ;
     logout.setBounds(470,10,90,23);
     logout.setForeground(Color.white) ;
     logout.setBackground(Color.decode("#5E2B0F")) ;
     Font font2 = new Font("TimesNewRoman",Font.PLAIN,10) ;
     logout.setFont(font2) ;
     logout.setBorder(BorderFactory.createEmptyBorder());
     panel.add(logout) ;
     
     JButton button0 = new JButton("Submit") ;
     button0.setBounds(253,260,80,25) ;
     button0.setBackground(Color.white) ;
     panel.add(button0) ;
     
     JButton button3 = new JButton("Back") ;
     button3.setBounds(253,300,80,25) ;
     button3.setBackground(Color.white) ;
     panel.add(button3) ;
     
     JLabel label = new JLabel("BOOK RETURN ") ;
     label.setBounds(230,10,200,30) ;
     label.setForeground(Color.white) ;
     Font font = new Font("TimesNewRoman",Font.BOLD,20) ;
     label.setFont(font) ;
     panel.add(label) ;
     add(panel) ;
    
     
     JPanel panel2 = new JPanel();
     panel2.setLayout(null) ;
     panel2.setBounds(10,50,265,200);
     panel2.setBackground(Color.decode("#84421E")) ;
     panel.add(panel2) ;
     
     JLabel label2 = new JLabel("Student Id") ;
     label2.setBounds(5,5,100,50) ;
     label2.setForeground(Color.white) ;
     panel2.add(label2) ;
     
     JLabel label3 = new JLabel("Student Name") ;
     label3.setBounds(5,40,100,50) ;
     label3.setForeground(Color.white) ;
     panel2.add(label3) ;
     
     JTextField field = new JTextField() ;
     field.setBounds(120,17,120,20) ;
     panel2.add(field) ;
     
     JTextField field2 = new JTextField() ;
     field2.setBounds(120,53,120,20) ;
     panel2.add(field2) ;
     
     JButton button = new JButton("Click") ;
     button.setBounds(100,150,70,20) ;
     button.setBackground(Color.white) ;
     panel2.add(button) ;

     JPanel panel3 = new JPanel();
     panel3.setLayout(null);
     panel3.setBounds(310,50,265,200);
     panel3.setBackground(Color.decode("#84421E")) ;
     panel.add(panel3) ;
     
     JLabel label5 = new JLabel("Book Id") ;
     label5.setBounds(5,5,100,50) ;
     label5.setForeground(Color.white) ;
     panel3.add(label5) ;
     
     JLabel label6 = new JLabel("Book Name") ;
     label6.setBounds(5,40,100,50) ;
     label6.setForeground(Color.white) ;
     panel3.add(label6) ;
     
     JTextField field4 = new JTextField() ;
     field4.setBounds(120,17,120,20) ;
     panel3.add(field4) ;
     
     JTextField field5 = new JTextField() ;
     field5.setBounds(120,53,120,20) ;
     panel3.add(field5) ;
     
     button.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
             try
             {
                       conn obj = new conn() ;
                        PreparedStatement sa = obj.c.prepareStatement("select SID,SNAME,BID,BNAME from bookissue where SID=? ");
                        iddd = Integer.parseInt(field.getText()) ;
                        sa.setInt(1,iddd) ;
                        ResultSet rs = sa.executeQuery() ;
                        if(rs.next()==false)
                        {
                            JOptionPane.showMessageDialog(null,"Nothing Found") ;
                            field2.setText("") ;
                            field4.setText("") ;
                            field5.setText("") ;  
                        }
                        else
                        {
                            snamep = rs.getString("sname") ;
                            snamep2 = rs.getString("bname") ;
                            field2.setText(snamep) ;
                            field4.setText(rs.getString("bid")) ;
                            field5.setText(snamep2) ;   
                        }
             }
             catch(Exception ee)
             {
                 System.out.println(ee);
             }   
         }
      });

     button0.addActionListener(new ActionListener()
     {
         @Override
         public void actionPerformed(ActionEvent ae)
         {
            try
             {
                 String dateString = String.valueOf(date) ;
                 conn sc = new conn() ;
                 
                 //  DELETE PLACE
                int num = Integer.parseInt(field.getText().toString()) ;
                String sql2 = "DELETE FROM bookissue where SID =?" ;
                PreparedStatement pstmt = sc.c.prepareStatement(sql2) ;
                pstmt.setInt(1,num) ;
                pstmt.executeUpdate() ;
                
                 String sql = "insert into bookreturn(SID,SNAME,BID,BNAME,DATE) value(?,?,?,?,?)" ;
                 PreparedStatement st = sc.c.prepareStatement(sql) ;
                 st.setString(1, field.getText());
                 st.setString(2, field2.getText());
	         st.setString(3, field4.getText());
	         st.setString(4, field5.getText());
                 st.setString(5, dateString);
               int i = st.executeUpdate();
	       if (i > 0)
               {
                JOptionPane.showMessageDialog(null, "Successfully Returned");
                String log = snamep+" Returned The Book "+snamep2 ;
                 try
                 {
                     String query = "insert into log(LOG) value(?)" ;
                     PreparedStatement stmt = sc.c.prepareStatement(query) ;
                     stmt.setString(1,log) ;
                     stmt.executeUpdate() ;
                 }
                 catch(Exception ee)
                 {
                     System.out.println(ee) ;
                 }
               }
                field.setText("");
                field2.setText("");
		field4.setText("");
		field5.setText("");
                
             }
             catch(Exception e)
             {
                System.out.println(e) ;
                // DELETE PLACE
             }
             dispose() ;
             bookreturn sccc = new bookreturn() ;
            
         }
     }) ;
      logout.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              login sc = new login() ;
          }
      }) ;
        button3.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              index sc = new index() ;
          }
      }) ;
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
}
     
