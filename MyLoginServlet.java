import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class MyLoginServlet extends HttpServlet {
    private Connection conn ;
    private PreparedStatement ps;
  public void init() throws ServletException{
      try {
          conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "advjava", "anubhav");
          System.out.println("Connected succesfully");
          ps = conn.prepareStatement("select username from users where userid = ? and password = ?");
          System.out.println("Query set sucessefully");

      }catch(SQLException ex){
          ServletException se = new ServletException(ex.getMessage());
          throw se;
      }
  }
  protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
   {
       String userid = req.getParameter("userid");
       String password = req.getParameter("password");
       resp.setContentType("text/html");
       PrintWriter pw=resp.getWriter();
       try {
           ps.setString(1,userid);
           ps.setString(2,password);
           ResultSet rs = ps.executeQuery();
           
           pw.println("<html>");
           pw.println("<head><title>Login page!</title>");
           pw.println("</head><body>");
           
           if (rs.next()) {
               String userName = rs.getString(1);
               pw.println("<p><b> Hey " + userName + "</b> Welcome in our site!</p><br>");
           } 
           else {
               pw.println("<h2> Login failed ! Invalid Credentials .</h2>");
               pw.println("<a href='login.html'><b>Try again!</b></a>");
           }
       }catch(SQLException ex){
           pw.println("<h2> Login failed ! Invalid Credentials .</h2>");
           System.out.println("Exception in doPost:"+ex);
       }
       
       finally{
           pw.println("</body>");
           pw.println("</html>");
           pw.close();
       }
   }
   public void destroy(){
      try {
          conn.close();
      }catch(SQLException ex){
          System.out.println("Exception in destroy method:"+ex);
      }
   }
}