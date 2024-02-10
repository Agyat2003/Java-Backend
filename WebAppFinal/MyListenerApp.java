import javax.servlet.*;
import java.sql.*;
public class MyListenerApp implements ServletContextListener{
    Connection conn ;
    public void contextInitialized(ServletContextEvent ev){
        ServletContext ctxt = ev.getServletContext();
        String url = ctxt.getInitParameter("url");
        String username = ctxt.getInitParameter("username");
        String password = ctxt.getInitParameter("password");

        try{
           conn = DriverManager.getConnection(url , username , password);
        }catch(SQLException ex){
            conn = null;
            throw new RuntimeException(ex);
        }
       finally {
            ctxt.setAttribute("connObj",conn);
        }
        System.out.println("Context Initialized Executed");

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){

        }
    }
    public void contextDestroyed(ServletContextEvent ev){
        try{
            if(conn != null)
            conn.close();
        }catch(SQLException ex){
            System.out.println("Error in closing connection");
        }
        System.out.println("Context Destroyed Executed");
    }
}
 