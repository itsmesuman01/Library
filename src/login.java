import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.net.URI;
import java.util.* ;
import java.time.* ;
import java.text.* ;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.Statement ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.ResultSetMetaData ;
        
// Main Class
public class login extends JFrame implements ActionListener,Runnable
{
    private JFrame frame ;
    private String uname, pwd, skey ;
    private int svar=0, svar2=0 ;
    private int date, month, day ;
    private JLabel datelabel, datelabel2 ;
    private JButton hyperlink ;
    // Main Methods
    public static void main(String[]args)
    {
     login obj = new login() ;
    }
    
    // Constructor
    public login()
    {
        
     // Clock() ;
     JDialog.setDefaultLookAndFeelDecorated(true);
     ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\LMS\\image\\book.jpg") ;
     
     frame = new JFrame() ;
     setSize(600,600) ;
     setLocationRelativeTo(null); 
     
     // JPanel
     JPanel panel = new JPanel() ;
     panel.setLayout(null) ;
     panel.setBackground(Color.decode("#5E2B0F")) ;
     
     Font font3 = new Font("calibri",Font.ITALIC,15) ;
     
     datelabel = new JLabel() ;
     datelabel.setBounds(10,10,250,23) ;
     datelabel.setForeground(Color.white) ;
     datelabel.setFont(font3) ;
     panel.add(datelabel) ;
     
     datelabel2 = new JLabel() ;
     datelabel2.setBounds(10,30,250,23) ;
     datelabel2.setForeground(Color.white) ;
     datelabel2.setFont(font3) ;
     panel.add(datelabel2) ;
     
     JButton exit = new JButton("EXIT") ;
     exit.setBounds(470,30,90,23);
     exit.setForeground(Color.white) ;
     exit.setBackground(Color.decode("#5E2B0F")) ;
     Font font2 = new Font("TimesNewRoman",Font.PLAIN,10) ;
     exit.setFont(font2) ;
     exit.setBorder(BorderFactory.createEmptyBorder());
     panel.add(exit) ;
     
     hyperlink = new JButton("© Develop By Suman Pandey") ;
     hyperlink.setBounds(420,530,150,23);
     hyperlink.setForeground(Color.white) ;
     hyperlink.setBackground(Color.decode("#5E2B0F")) ;
     Font font4 = new Font("TimesNewRoman",Font.PLAIN,10) ;
     hyperlink.setFont(font2) ;
     hyperlink.setBorder(BorderFactory.createEmptyBorder());
     panel.add(hyperlink) ;
     
     hyperlink.addActionListener(this) ;
     
     // JPanel 2
     JPanel panel2 = new JPanel() ;
     panel2.setBounds(80,80,400,400) ;
     panel2.setBackground(Color.decode("#5E2B0F"));
     
     // Image adding code
     
     JLabel imagelabel = new JLabel(icon) ;
     imagelabel.setBounds(0,0,400,420);
     panel2.add(imagelabel) ;
     
     
     JLabel labelhead = new JLabel("LOGIN") ;
     labelhead.setBounds(230,100,250,50) ;
     labelhead.setForeground(Color.white) ;
     Font font = new Font("Calibri",Font.BOLD,40);
     labelhead.setFont(font) ;
     
     
     JButton sbutton = new JButton("");
     sbutton.setBounds(10,10,10,10) ;
     sbutton.setBackground(Color.white);
     sbutton.setVisible(false) ;
     panel2.add(sbutton) ;
     
     JButton sbutton2 = new JButton("");
     sbutton2.setBounds(395,380,10,10) ;
     sbutton2.setBackground(Color.white);
     sbutton2.setVisible(false) ;
     panel2.add(sbutton2) ;
     
     // Components
     
     JLabel label = new JLabel("Username") ;
     label.setBounds(150, 150, 100,100) ;
     label.setForeground(Color.white) ;
     
     JTextField field = new JTextField() ;
     field.setBounds(230,185,160,30) ;
     
     JLabel label2 = new JLabel("Password") ;
     label2.setBounds(150, 210, 100,100) ;
     label2.setForeground(Color.white) ;
     
     JPasswordField field2 = new JPasswordField() ;
     field2.setBounds(230,245,160,30) ;
     
     JButton button = new JButton("LOGIN") ;
     button.setBounds(265, 280, 90, 30) ;
     button.setBackground(Color.white) ;
     
     JButton button3 = new JButton("Pass ?") ;
     button3.setBounds(375, 450,100,20) ;
     button3.setForeground(Color.black) ;
     button3.setBackground(Color.white) ;
     
     JButton button2 = new JButton("SignUp ") ;
     button2.setBounds(375, 420,100,20) ;
     button2.setForeground(Color.black) ;
     button2.setBackground(Color.white) ;
     button2.setVisible(false) ;
     
      button.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              try
              {
                  conn sc = new conn() ;
                  String query="select * from register" ;
                  PreparedStatement pp = sc.c.prepareStatement(query) ;
                                ResultSet rs = pp.executeQuery() ; 
                                ResultSetMetaData rsmd = rs.getMetaData() ;
                            
                            // Display Row
                            
                            while(rs.next())
                            {
                             uname= rs.getString(2) ;
                             pwd = rs.getString(4) ;
                             skey = rs.getString(6) ;
                            }
                        sc.c.close() ;
                        pp.close();
              }
              catch(Exception e)
              {
                  
              }
             
              String l1 = field.getText() ;
              String l2 = field2.getText() ;
              
              if((l1.equals("")) || (l2.equals("") ))
              {
               JOptionPane.showMessageDialog(null,"Something is missing ") ;
              }
              else if((uname.equals(l1)) && (!pwd.equals(l2) ))
              {
               JOptionPane.showMessageDialog(null," Wrong Username and Password ") ;
               
               field2.setText("");
              }
               
              else if((!uname.equals(l1)) && (pwd.equals(l2) ))
              {
               JOptionPane.showMessageDialog(null,"Wrong Username and Password ") ;
               field.setText("") ;
               field2.setText("" );
              }
              else if((!uname.equals(l1)) && (!pwd.equals(l2) ))
              {
                      if( (l1.equals("0123456789"))&&(l2.equals("0123456789"))||(l1.equals(skey))&&(l2.equals(skey)) )
                        {
                      
                        }
                      else
                          {
                           JOptionPane.showMessageDialog(null,"Wrong Username and Password ") ;
                           field.setText("") ;
                           field2.setText("" );
                          }
    
              }
              else if ((uname.equals(l1)) && (pwd.equals(l2) ))
              {
                  
                  field.setText("") ;
                  field2.setText("" );
                  frame.dispose();
                  index sc = new index() ;
              }
              if( (l1.equals("0123456789"))&&(l2.equals("0123456789"))||(l1.equals(skey))&&(l2.equals(skey)) )
              {
                  button2.setVisible(true) ;
              }
          }
          
      }) ;
     
     button2.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              Register sc = new Register() ;
          }
          
      }) ;
     button3.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              showchange sc = new showchange() ;
          }
          
      }) ;
     sbutton.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              svar ++ ;
          }
          
      }) ;
     sbutton2.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              svar2 ++ ;
              if((svar==5)&&(svar2==2))
              {
               // button2.setVisible(true) ;
              }
          }
          
      }) ;
     exit.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
          }
      }) ;
     
     // Adding to JFrame
     add(labelhead);
     add(label) ;
     add(field) ;
     add(label2) ;
     add(field2) ;
     add(button) ;
     add(button3) ;
     add(button2) ;
     add(panel2) ;
     add(panel) ;
     
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
    public void Clock()
    {
        Thread thread = new Thread(this) ;
        thread.start() ;    
    }
    @Override
    public void run()
    {
        try
        {
        while(true)
        {
            Calendar cal = Calendar.getInstance() ;
            date = cal.get(Calendar.HOUR_OF_DAY) ;
            month = cal.get(Calendar.MINUTE) ;
            day = cal.get(Calendar.SECOND) ;
            
            SimpleDateFormat myFormat = new SimpleDateFormat("YYYY-M-dd") ;
            SimpleDateFormat myFormat2 = new SimpleDateFormat("hh-mm-ss") ;
            Date date = cal.getTime() ;
            String time = myFormat.format(date) ;
            String time2 = myFormat2.format(date) ;
            datelabel.setText(time) ;
            datelabel2.setText(time2) ;
            

        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== hyperlink)
                {

           try
             {
           Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=100027485835559")) ;
             }
           catch(Exception e)
           {
               System.out.println(e);
           }
         
      }
     }
    }
