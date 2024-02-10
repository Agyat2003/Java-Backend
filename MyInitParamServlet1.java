import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class MyInitParamServlet1 extends HttpServlet {

 protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
   {
       ServletConfig cfg = super.getServletConfig();
       String email = cfg.getInitParameter("email");
       String contact = cfg.getInitParameter("contactno");
       resp.setContentType("text/html");
       PrintWriter pw=resp.getWriter();
       pw.println("<html><head><title>Contact Details</title></head>");
       pw.println("<body>");
       pw.println("<h2>These Are Contact Details:</h2>");
       pw.println("<p>Email id :"+email+"</p>");
       pw.println("<p>Contact No:"+contact+"</p>");
       pw.println("</body>");
       pw.println("</html>");
       pw.close();
  }
}
 