import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class MyLoginServlet3 extends HttpServlet {
    private PreparedStatement ps;
    public void init() throws ServletException{
          ServletContext ctxt =  super.getServletContext();
          ServletConfig cfg = super.getServletConfig();
          String query = cfg.getInitParameter("query");
          Connection conn =(Connection) ctxt.getAttribute("connObj");
          System.out.println("Connected succesfully");
        try {
            if(conn == null){
                throw new SQLException();
            }
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
               resp.sendRedirect("signin.html");
           }
       }catch(SQLException ex){
           pw.println("<h2> Login failed ! Invalid Credentials.</h2>");
           System.out.println("Exception in doPost:"+ex);
       }
       
       finally{
           pw.println("</body>");
           pw.println("</html>");
           pw.close();
       }
   }

}