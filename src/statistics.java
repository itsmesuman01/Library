import javax.swing.* ;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.* ;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class statistics extends JFrame
{
    private JFrame frame ;
    private JTable table1, table2 ;
    private JButton clear ;
    public static void main (String[]args)
    {
        statistics obj = new statistics() ;
    }
    public statistics() 
    {
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        frame = new JFrame() ;
        setTitle("Statistics") ;
        setSize(900,600) ;
        setLocationRelativeTo(null); 
        
        JPanel panel = new JPanel() ;
        panel.setLayout(null);
        panel.setBackground(Color.decode("#5E2B0F")) ;
        add(panel) ;
        
     JButton logout = new JButton("LOGOUT") ;
     logout.setBounds(770,10,90,23);
     logout.setForeground(Color.white) ;
     logout.setBackground(Color.decode("#5E2B0F")) ;
     Font font2 = new Font("TimesNewRoman",Font.PLAIN,10) ;
     logout.setFont(font2) ;
     logout.setBorder(BorderFactory.createEmptyBorder());
     panel.add(logout) ;
     
     clear= new JButton("CLEAR") ;
     clear.setBounds(780,325,80,15);
     clear.setBackground(Color.white) ;
     panel.add(clear) ;
     clear.addActionListener(new ActionListener()
     {
         @Override
         public void actionPerformed(ActionEvent ae)
         {
            try
            {
             conn sc = new conn() ;
             String query = "delete from bookreturn" ;
             PreparedStatement stmt = sc.c.prepareStatement(query) ;
             long j = stmt.executeUpdate() ;
             if(j>0)
             {
                 dispose() ;
                 statistics scc = new statistics() ;
                 JOptionPane.showMessageDialog(null,"Successfully Cleared") ;
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Nothing Found") ;
             }
            }
            catch(Exception e)
            {
             System.out.println(e) ;
            }
         }
     }) ;
     
     JLabel label = new JLabel("ISSUE BOOK") ;
     label.setBounds(380,40,150,50) ;
     label.setForeground(Color.white) ;
     Font font = new Font("Calibri",Font.BOLD,20);
     label.setFont(font) ;
     panel.add(label);
     
     JLabel label2 = new JLabel("RETURN BOOK") ;
     label2.setBounds(380,290,150,50) ;
     label2.setForeground(Color.white) ;
     label2.setFont(font) ;
     panel.add(label2);
     
     table1 = new JTable() ;
     JScrollPane jsp1 = new JScrollPane(table1) ;
     jsp1.setBounds(10,74,870,190) ;
     panel.add(jsp1) ;
     
     table2 = new JTable() ;
     JScrollPane jsp2 = new JScrollPane(table2) ;
     jsp2.setBounds(10,340,870,190) ;
     panel.add(jsp2) ;
     
     try
     {
        conn sc = new conn() ;
        String query1 = "select * from bookissue" ;
        String query2 = "select * from bookreturn" ;
        PreparedStatement stmt1 = sc.c.prepareStatement(query1) ;
        PreparedStatement stmt2 = sc.c.prepareStatement(query2) ;
        ResultSet rs1 = stmt1.executeQuery() ;
        ResultSet rs2 = stmt2.executeQuery() ;
        table1.setModel(DbUtils.resultSetToTableModel(rs1)) ;
        table2.setModel(DbUtils.resultSetToTableModel(rs2)) ;
     }
     catch(Exception e)
     {
         
     }
     
         logout.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              login sc = new login() ;
          }
      }) ;
     JButton button = new JButton("Back") ;
     button.setBounds(380,535,80,25) ;
     button.setBackground(Color.white) ;
     panel.add(button) ;
     
       button.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              dispose();
              index sc = new index() ;
          }
      }) ;
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true) ;
    }
}