import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class MyServletOne emplements HttpServlet{

 protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
   {
       ServletContext ctxt = super.getServletContext();
       String email = ctxt.getInitParameter("email");
       String contact = ctxt.getInitParameter("contactno");
       resp.setContentType("text/html");
       PrintWriter pw=resp.getWriter();
       pw.println("<html><head><title>Contact Details</title></head>");
       pw.println("<body>");
       pw.println("<p>Details from Servlet one</p>");
       pw.println("<h2>These Are Contact Details:</h2>");
       pw.println("<p>Email id :"+email+"</p>");
       pw.println("<p>Contact No:"+contact+"</p>");
       pw.println("</body>");
       pw.println("</html>");
       pw.close();
  }
}
 