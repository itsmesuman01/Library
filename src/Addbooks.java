import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
import java.time.LocalDate ;
        
// Main Class
public class Addbooks extends JFrame
{
    private JFrame frame ;
    private LocalDate date ;
    // Main Methods
    public static void main(String[]args)
    {
     Addbooks obj = new Addbooks() ;   
    }
    // Constructor
    public Addbooks()
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
     
     JLabel label0 = new JLabel("Book ID") ;
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
                        String query="select * from addbooks" ;
                        PreparedStatement st = obj.c.prepareStatement(query);
                                ResultSet rs = st.executeQuery(query) ; 
                                ResultSetMetaData rsmd = rs.getMetaData() ;
                                int id;
                                 while(rs.next())
                                      {
                                       
                                       id = Integer.parseInt(rs.getString(1)) ;
                                       
                                       
                                       int ide = id+1 ;
                                       
                                       slabel.setText(String.valueOf(ide));
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
     
     JLabel label2 = new JLabel("ISBN") ;
     label2.setBounds(150, 165, 100,100) ;
     label2.setForeground(Color.white) ;
     
     JTextField field2 = new JTextField() ;
     field2.setBounds(230,200,160,20) ;
     
     JLabel label3 = new JLabel("Publisher") ;
     label3.setBounds(150, 200, 100,100) ;
     label3.setForeground(Color.white) ;
     
     JTextField field3 = new JTextField() ;
     field3.setBounds(230,235,160,20) ;
     
     JLabel label4 = new JLabel("Edition") ;
     label4.setBounds(150, 235, 100,100) ;
     label4.setForeground(Color.white) ;
     
     String select[]={"-","1st","2nd","3rd","4th","5th","6th","7th","8th","9th"} ;
     JComboBox box = new JComboBox(select) ;
     box.setBounds(230, 275, 160,20) ;
     
     JLabel label5 = new JLabel("Pages") ;
     label5.setBounds(150, 270, 100, 100) ;
     label5.setForeground(Color.white) ;
     
     JTextField field4 = new JTextField() ;
     field4.setBounds(230,310,160,20) ;
     
     JLabel label6 = new JLabel("Price") ;
     label6.setBounds(150, 305, 100,100) ;
     label6.setForeground(Color.white) ;
     
     JTextField field5 = new JTextField() ;
     field5.setBounds(230,345,160,20) ;
     
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
                String d= field3.getText() ;
                String e= field4.getText() ;
                String f= field5.getText() ;
             if((b.equals(""))||(c.equals(""))||(d.equals(""))||(e.equals(""))||(f.equals("")))
                {
                    JOptionPane.showMessageDialog(null, "Something is Missing");
                }
             else
             {
             try
             {
               conn sc = new conn();
               String sql="insert into addbooks(ID,NAME,ISBN,PUBLISHER,EDITION,PAGES,PRICE,DATE) values(?,?,?,?,?,?,?,?)" ;
               PreparedStatement st = sc.c.prepareStatement(sql);
               
               String dateString = String.valueOf(date) ;
               
               st.setString(1, slabel.getText());
               st.setString(2, field.getText());
	       st.setString(3, field2.getText());
               st.setString(4, field3.getText());
	       st.setString(5, (String) box.getSelectedItem());
	       st.setString(6, field4.getText());
               st.setString(7, field5.getText());
               st.setString(8, dateString) ;
               int i = st.executeUpdate() ;
	       if (i > 0){
                          JOptionPane.showMessageDialog(null, "Successfully Added");
                 String abcd = field.getText() ;
                 String log = abcd+" Book Is Added Successfully" ;
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
                //field0.setText("");
                field.setText("");
		field2.setText("");
		field3.setText("");
                field4.setText("");
                field5.setText("") ;
           
              }
             catch(Exception ee)
             {
              System.out.println(ee)  ;
             }
          
             dispose() ;
             Addbooks sc = new Addbooks() ;
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
    // frame.add(field0) ;
     add(label) ;
     add(field) ;
     add(label2) ;
     add(field2) ;
     add(label3) ;
     add(label4) ;
     add(box) ;
     add(field3) ;
     add(label5) ;
     add(field4) ;
     add(label6) ;
     add(field5) ;
     add(button) ;    
     add(button2) ;
     
     add(panel2) ;
     add(panel) ;
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
}