import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class MyLoginServlet2 extends HttpServlet {
    private Connection conn ;
    private PreparedStatement ps;
    private ServletContext ctxt;
    private ServletConfig cfg;

  public void init() throws ServletException{
      try {
          ctxt =  super.getServletContext();
          cfg = super.getServletConfig();
          String url = ctxt.getInitParameter("url");
          String username = ctxt.getInitParameter("username");
          String password = ctxt.getInitParameter("password");
          String query = cfg.getInitParameter("query");
          conn = DriverManager.getConnection(url , username , password);
          System.out.println("Connected succesfully");
          ps = conn.prepareStatement(query);
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
               pw.println("<a href='signin.html'><b>Try again!</b></a><br>");
               pw.println("<a href='signup.html'><b>New user!</b></a>");

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