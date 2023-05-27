import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
import net.proteanit.sql.DbUtils;

public class log extends JFrame
{
    private JFrame frame ;
    private JTable table ;
    private JButton button ;
    public static void main(String[]args)
    {
        log sc = new log() ;
    }
    public log()
    {   
        frame  = new JFrame() ;
        setLayout(null) ;
        setSize(400,400) ;
        
        table = new JTable() ;
        
        JScrollPane jsp = new JScrollPane(table) ;
        jsp.setBounds(05,05,375,320) ;
        add(jsp) ;
        
        try
        {
            conn sc = new conn() ;
            String query = "select * from log" ;
            PreparedStatement stmt = sc.c.prepareStatement(query) ;
            ResultSet rs = stmt.executeQuery() ;
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
         System.out.println(e) ;
        }
        
        button = new JButton("Back") ;
        button.setBounds(140,330,100,20) ;
        button.setForeground(Color.black) ;
        button.setBackground(Color.white) ;
        add(button) ;
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
              dispose() ;
              index sc = new index() ;
            }
        }) ;
        
        setDefaultCloseOperation(frame.EXIT_ON_CLOSE) ;
        setVisible(true) ;
    }
}