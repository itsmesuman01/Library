import javax.swing.* ;  
import java.awt.* ;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate ;
import java.util.Calendar;
        
// Main Class
public class bookissue extends JFrame
{
    private JFrame frame ;
    private LocalDate date ;
    private JComboBox ccc ;
    private int myNums, dates, month, day, newDay, newDay2, newmonth ;
    private String sname, sname2 ;
    // Main Methods
    public static void main(String[]args)
    {
     bookissue obj = new bookissue() ;   
    }
    
    // Constructor
    public bookissue()
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
     
     String timeperiod[]={"-","7","15","30"} ;
     ccc = new JComboBox(timeperiod) ;
     ccc.setBounds(253,260,80,25) ;
     ccc.setBackground(Color.white) ;
     panel.add(ccc) ;
     
     JButton button0 = new JButton("Submit") ;
     button0.setBounds(253,300,80,25) ;
     button0.setBackground(Color.white) ;
     panel.add(button0) ;
     
     JButton button3 = new JButton("Back") ;
     button3.setBounds(253,340,80,25) ;
     button3.setBackground(Color.white) ;
     panel.add(button3) ;
     
     JLabel label = new JLabel("BOOK ISSUE") ;
     label.setBounds(230,10,150,30) ;
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

     JButton button2 = new JButton("Click") ;
     button2.setBounds(100,150,70,20) ;
     button2.setBackground(Color.white) ;
     panel3.add(button2) ;
     
     button.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
             try
             {
                       conn obj = new conn() ;
                        PreparedStatement sa = obj.c.prepareStatement("select ID,NAME from addstudents where ID=? ");
                        int id = Integer.parseInt(field.getText()) ;
                        sa.setInt(1,id) ;
                        ResultSet rs = sa.executeQuery() ;
                        if(rs.next()==false)
                        {
                            JOptionPane.showMessageDialog(null,"No Record Found") ;
                            field2.setText("") ;
                            
                            
                        }
                        else
                        {
                            sname = rs.getString("name") ;
                            field2.setText(sname) ;
                        }
             }
             catch(Exception ee)
             {
                 System.out.println(ee);
             }
             
             
         }
      });
     
     button2.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
             try
             {
                       conn obj = new conn() ;
                        PreparedStatement sa = obj.c.prepareStatement("select ID,NAME,PUBLISHER from addbooks where ID=? ");
                        int id = Integer.parseInt(field4.getText()) ;
                        sa.setInt(1,id) ;
                        ResultSet rs = sa.executeQuery() ;
                        if(rs.next()==false)
                        {
                            JOptionPane.showMessageDialog(null," No Record Found ") ;
                            field5.setText("") ;
                        }
                        else
                        {
                            sname2 = rs.getString("name") ;
                            field5.setText(sname2) ;
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
                 String myData = String.valueOf(ccc.getSelectedItem()) ;
                 myNums = Integer.parseInt(myData) ;
                 
                 Calendar cal = Calendar.getInstance() ;
                 dates = cal.get(Calendar.YEAR) ;
                 month = 1+ cal.get(Calendar.MONTH) ;
                 day = cal.get(Calendar.DAY_OF_MONTH) ;
                 newDay = myNums+day ;
                 
                 if(newDay > 31)
                 {
                     newDay2 = 31-newDay ;
                     newmonth = 1+month ; 
                 }
                 else
                 {
                 }
                 
                 conn sc = new conn() ;
                 String sql = "insert into bookissue(SID,SNAME,BID,BNAME,DATE,EXPIRY) value(?,?,?,?,?,?)" ;
                 PreparedStatement st = sc.c.prepareStatement(sql) ;
                 st.setString(1, field.getText());
                 st.setString(2, field2.getText());
	         st.setString(3, field4.getText());
	         st.setString(4, field5.getText());
                 st.setString(5, dateString) ;
                 
                 if(newDay <= 31)
                 {
                    String talu = dates+"-"+month+"-"+newDay ;
                    st.setString(6, talu);
                 }
                 else
                 {
                    String talus = dates+"-"+newmonth+""+newDay2 ;
                    st.setString(6, talus);
                 }
                 
               int i = st.executeUpdate();
	       if (i > 0)
               {
                JOptionPane.showMessageDialog(null, " Successfully Issued ");
                
                 String log = sname+" Issue The Book "+sname2 ;
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
                ccc.setSelectedItem("-") ;
             } 
             catch(Exception e)
             {
                System.out.println(e) ; 
             }
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
     
