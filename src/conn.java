import java.sql.Connection ;
import java.sql.Statement ;
import java.sql.DriverManager ;

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");    
            s =c.createStatement();  
        
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    } 
    public static void main(String args[])
    {
        new conn();
        System.out.println("Database Connected");
    }  
}  
