import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
        
// Main Class
public class index extends JFrame
{
    private JFrame frame ;
    // Main Methods
    public static void main(String[]args)
    {
     index obj = new index() ;   
    }
    
    // Constructor
    public index ()
    {
     JDialog.setDefaultLookAndFeelDecorated(true);
     
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
     Font font2 = new Font("TimesNewRoman",Font.BOLD,10) ;
     logout.setFont(font2) ;
     logout.setBorder(BorderFactory.createEmptyBorder());
     panel.add(logout) ;
     // JPanle 2
     JPanel panel2 = new JPanel() ;
     panel2.setLayout(null) ;
     panel2.setBounds(80,80,417,400) ;
     panel2.setBackground(Color.decode("#84421E"));
     // Components
      Font font = new Font("Calibri",Font.PLAIN,15) ;
      
      JButton b1 = new JButton("Add Books") ;
      b1.setBounds(17,50,150,50);
      b1.setBackground(Color.white) ;
      b1.setForeground(Color.black) ;
      b1.setBorder(BorderFactory.createEmptyBorder());
      b1.setFont(font);
      panel2.add(b1) ;
      
      JButton b2 = new JButton("Books Details") ;
      b2.setBounds(250,50,150,50);
      b2.setBackground(Color.white) ;
      b2.setForeground(Color.black) ;
      b2.setBorder(BorderFactory.createEmptyBorder());
      b2.setFont(font);
      panel2.add(b2) ;
      
      JButton b3 = new JButton("Add Students") ;
      b3.setBounds(17,140,150,50);
      b3.setBackground(Color.white) ;
      b3.setForeground(Color.black) ;
      b3.setBorder(BorderFactory.createEmptyBorder());
      b3.setFont(font);
      panel2.add(b3) ;
      
      JButton b4 = new JButton("Student Details") ;
      b4.setBounds(250,140,150,50);
      b4.setBackground(Color.white) ;
      b4.setForeground(Color.black) ;
      b4.setBorder(BorderFactory.createEmptyBorder());
      b4.setFont(font);
      panel2.add(b4) ;
      
      JButton b5 = new JButton("Book Issue") ;
      b5.setBounds(17,230,150,50);
      b5.setBackground(Color.white) ;
      b5.setForeground(Color.black) ;
      b5.setBorder(BorderFactory.createEmptyBorder());
      b5.setFont(font);
      panel2.add(b5) ;
      
      JButton b6 = new JButton("Book Return ") ;
      b6.setBounds(250,230,150,50);
      b6.setBackground(Color.white) ;
      b6.setForeground(Color.black) ;
      b6.setBorder(BorderFactory.createEmptyBorder());
      b6.setFont(font);
      panel2.add(b6) ;
      
      JButton b7 = new JButton("Statistics") ;
      b7.setBounds(135,320,150,50);
      b7.setBackground(Color.white) ;
      b7.setForeground(Color.black) ;
      b7.setBorder(BorderFactory.createEmptyBorder());
      b7.setFont(font);
      panel2.add(b7) ;
      
      JButton b8 = new JButton("LOG") ;
      b8.setBounds(160,380,100,15);
      b8.setBackground(Color.white) ;
      b8.setForeground(Color.black) ;
      b8.setBorder(BorderFactory.createEmptyBorder());
      Font font3 = new Font("Calibri",Font.PLAIN,10) ;
      b8.setFont(font3);
      panel2.add(b8) ;
      
      b1.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              Addbooks sc = new Addbooks() ;
          }
          
      }) ;
      
      b3.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              Addstudent sc = new Addstudent() ;
          }
          
      }) ;
      
         b2.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              bookdetails sc = new bookdetails() ;
          }
          
      }) ;
         
            b4.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              studentdetails sc = new studentdetails() ;
          }
          
      }) ;
            
              b5.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
               dispose();
               bookissue sc = new bookissue() ;
          }
          
      }) ;
              
                       b6.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
               dispose();
               bookreturn sc = new bookreturn() ;
          }
          
      }) ;
                                b7.addActionListener( new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
               dispose();
               statistics sc = new statistics() ;
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
 b8.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              log sc = new log() ;
          }
      }) ;
     // Adding to JFrame
     
     add(panel2) ;
     add(panel) ;
     
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     setVisible(true) ;
    }
}