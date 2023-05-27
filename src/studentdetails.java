// JDialog.setDefaultLookAndFeelDecorated(true);
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

        
// Main Class
public class studentdetails extends JFrame
{
    private JFrame frame ;
    private JTable table ;
    
    // Main Methods
    public static void main(String[]args)
    {

     studentdetails objj = new studentdetails() ;   
    }
    
    // Constructor
    public studentdetails()
    {
     JDialog.setDefaultLookAndFeelDecorated(true);
     
     JDialog.setDefaultLookAndFeelDecorated(true);
     frame = new JFrame() ;
     setSize(900,600) ;
     setLocationRelativeTo(null); 
     
     // JPanel
     JPanel panel = new JPanel() ;
     panel.setLayout(null);
     panel.setBackground(Color.decode("#5E2B0F")) ;
     add(panel) ;
     
     JButton logout = new JButton("LOGOUT") ;
     logout.setBounds(770,30,90,23);
     logout.setForeground(Color.white) ;
     logout.setBackground(Color.decode("#5E2B0F")) ;
     Font font2 = new Font("TimesNewRoman",Font.PLAIN,10) ;
     logout.setFont(font2) ;
     logout.setBorder(BorderFactory.createEmptyBorder());
     panel.add(logout) ;
     
     table = new JTable() ;
     JScrollPane jsp = new JScrollPane(table) ;
     jsp.setBounds(10,54,870,400) ;
     panel.add(jsp) ;
     
     try
     {
        conn sc = new conn() ;
        String query = "select * from addstudents" ;
        PreparedStatement psmt = sc.c.prepareStatement(query) ;
        ResultSet rs = psmt.executeQuery() ;
        table.setModel(DbUtils.resultSetToTableModel(rs)) ;
     }
     catch(Exception e)
     {
         
     }
      
      JLabel label = new JLabel("SEARCH") ;
      label.setBounds(20,470,100,50) ;
      label.setForeground(Color.white) ;
      Font font = new Font("TimesNewROman",Font.BOLD,20) ;
      label.setFont(font) ;
      panel.add(label) ;
      
      JTextField field = new JTextField() ;
      field.setBounds(110,480,120,30) ;
      panel.add(field) ;
      
      JButton button = new JButton("SEARCH") ;
      button.setBounds(250,480,90,30) ;
      button.setBackground(Color.white) ;
      panel.add(button) ;
      
      JButton button2 = new JButton("DELETE") ;
      button2.setBounds(250,520,90,30) ;
      button2.setBackground(Color.white) ;
      panel.add(button2) ;
      
      JButton button3 = new JButton("ADD STUDENTS") ;
      button3.setBounds(350,480,130,30) ;
      button3.setBackground(Color.white) ;
      panel.add(button3) ;
      
     JButton button4 = new JButton("BACK") ;
      button4.setBounds(350,520,130,30) ;
      button4.setBackground(Color.white) ;
      panel.add(button4) ;
     
      button.addActionListener(new ActionListener()
      {
         
       @Override
       public void actionPerformed(ActionEvent ae)
         {
            
            try
            {
                conn obj = new conn() ;
               // JOptionPane.showMessageDialog(null,"You Clicked Search Button") ;
               String sql = "select * from addstudents where concat(ID,NAME) like ?";
		PreparedStatement st = obj.c.prepareStatement(sql);
		st.setString(1, "%" + field.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();
            }
            
            
          catch(Exception e)
          {
              
          }
         }
      });
      
       button2.addActionListener(new ActionListener()
      {
       @Override
       public void actionPerformed(ActionEvent ae)
         {
             
             try
             {
             int num = Integer.parseInt(field.getText().toString()) ;
             conn obj = new conn() ;
             String sql = "DELETE FROM addstudents where ID =?" ;
             PreparedStatement pstmt = obj.c.prepareStatement(sql) ;
             pstmt.setInt(1,num) ;
             pstmt.executeUpdate() ;
             
             }
             catch(Exception e)
             {
                 System.out.println(e) ;
             }
             dispose() ;
             studentdetails sccc = new studentdetails() ;
             JOptionPane.showMessageDialog(null,"SuccessFully Deleted ") ;
             
         }
      });
       
       button3.addActionListener(new ActionListener()
      {
       @Override
       public void actionPerformed(ActionEvent ae)
         {
          dispose();
          Addstudent sc = new Addstudent() ;
         }
      });
        
        button4.addActionListener(new ActionListener()
      {
       @Override
       public void actionPerformed(ActionEvent ae)
         {
          dispose();
          index sc = new index() ;
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
      
         
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
        }}