import javax.swing.* ;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate ;
// Main Class
public class Addstudent extends JFrame
{
    private JFrame frame ;
    private LocalDate date ;
    // Main Methods
    public static void main(String[]args)
    {
     Addstudent obj = new Addstudent() ;   
    }
    
    // Constructor
    public Addstudent()
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
     logout.setBounds(470,30,90,23);
     logout.setForeground(Color.white) ;
     logout.setBackground(Color.decode("#5E2B0F")) ;
     Font font2 = new Font("TimesNewRoman",Font.PLAIN,10) ;
     logout.setFont(font2) ;
     logout.setBorder(BorderFactory.createEmptyBorder());
     panel.add(logout) ;
     
     // JPanle 2
     JPanel panel2 = new JPanel() ;
     panel2.setBounds(80,80,417,400) ;
     panel2.setBackground(Color.decode("#84421E"));
     
     // Components
     
     JLabel label0 = new JLabel("Student ID") ;
     label0.setBounds(150, 95, 100, 100) ;
     label0.setForeground(Color.white) ;
     
     JLabel slabel = new JLabel() ;
     slabel.setBounds(230,95,100,100) ;
     slabel.setForeground(Color.white) ;
     add(slabel) ;
     //-------------------------------------------------------------------------
     try
        {
                        conn obj = new conn() ;
                        String query="select * from addstudents" ;
                        PreparedStatement st = obj.c.prepareStatement(query);
                                ResultSet rs = st.executeQuery(query) ; 
                                ResultSetMetaData rsmd = rs.getMetaData() ;
                                int id ;
                                
                                 while(rs.next())
                                      {
                                       id = Integer.parseInt(rs.getString(1)) ;
                                       int idd = id+1 ;
                                       slabel.setText(String.valueOf(idd));
                                      }
                                st.close() ;
                                obj.c.close();
        }
        catch(Exception e)
        {
        }
     JLabel label = new JLabel("Name") ;
     label.setBounds(150, 130, 100,100) ;
     label.setForeground(Color.white) ;
     
     JTextField field = new JTextField() ;
     field.setBounds(230,165,160,20) ;
     
     JLabel label2 = new JLabel("Number") ;
     label2.setBounds(150, 165, 100,100) ;
     label2.setForeground(Color.white) ;
     
     JTextField field2 = new JTextField() ;
     field2.setBounds(230,200,160,20) ;
     
     JLabel label4 = new JLabel("Email") ;
     label4.setBounds(150, 200, 100,100) ;
     label4.setForeground(Color.white) ;
     
     JTextField field4 = new JTextField() ;
     field4.setBounds(230,235,160,20) ;
     
     JLabel label3 = new JLabel("Course") ;
     label3.setBounds(150, 235, 100,100) ;
     label3.setForeground(Color.white) ;
     
     String select1[]={"-","BCA","BBM","BBS","MBS"} ;
     JComboBox box1 = new JComboBox(select1) ;
     box1.setBounds(230, 275, 160,20) ;
     
     JLabel label5 = new JLabel("Year") ;
     label5.setBounds(150, 270, 100, 100) ;
     label5.setForeground(Color.white) ;
     
     String select3[]={"-","First","Second","Third","Fourth"} ;
     JComboBox box2 = new JComboBox(select3) ;
     box2.setBounds(230,310,160,20) ;
     
     JLabel label6 = new JLabel("Semester") ;
     label6.setBounds(150, 305, 100,100) ;
     label6.setForeground(Color.white) ;
     
     String select4[]={"-","1st","2nd","3rd","4th","5th","6th","7th","8th"} ;
     JComboBox box3 = new JComboBox(select4) ;
     box3.setBounds(230,345,160,20) ;

     JButton button = new JButton("Add") ;
     button.setBounds(180, 395, 80,30);
     button.setBackground(Color.white) ;
     
     JButton button2 = new JButton("Back") ;
     button2.setBounds(280, 395, 80,30);
     button2.setBackground(Color.white) ;
     
     button2.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              index sc = new index() ;
          }
          
      }) ;
     
     button.addActionListener(new ActionListener()
     {
         @Override
         public void actionPerformed(ActionEvent ae)
         {
                String b= field.getText() ;
                String c= field2.getText() ;
                String d = field4.getText() ;
                
             if((b.equals(""))||(c.equals(""))||(d.equals("")))
                {
                    JOptionPane.showMessageDialog(null, "Something is Missing");
                }
             else
             {
             try
             {
               String dateString = String.valueOf(date) ;
               conn sc = new conn();
               String sql="insert into addstudents(ID,NAME,NUMBER,EMAIL,COURSE,YEAR,SEMESTER,DATE) values(?,?,?,?,?,?,?,?)" ;
               PreparedStatement st = sc.c.prepareStatement(sql);
               st.setString(1, slabel.getText());
               st.setString(2, field.getText());
	       st.setString(3, field2.getText());
               st.setString(4, field4.getText());
               st.setString(5, (String) box1.getSelectedItem());
	       st.setString(6, (String) box2.getSelectedItem());
               st.setString(7, (String) box3.getSelectedItem());
               st.setString(8,  dateString);
               int i = st.executeUpdate() ;
	       if (i > 0){
                          JOptionPane.showMessageDialog(null, "Successfully Added");
                          String abcd = field.getText() ;
                 String log = abcd+" Is Registered Successfully" ;
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
                // field0.setText("");
                field.setText("");
		field2.setText("");
                field4.setText("") ;
              }
             catch(Exception ee)
             {
              System.out.println(ee)  ;
             }
             dispose() ;
             Addstudent sc = new Addstudent() ;
         }
         }
     });
 logout.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              login sc = new login() ;
          }
      }) ;
     // Adding to JFrame
     add(label0) ;
     add(label) ;
     add(field) ;
     add(label2) ;
     add(field2) ;
     add(label3) ;
     add(label4) ;
     add(field4) ;
     add(box1) ;
     add(label5) ;
     add(box2);
     add(box3) ;
     add(label6) ;
     add(button) ;
     add(button2) ;
     add(panel2) ;
     add(panel) ;
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
}