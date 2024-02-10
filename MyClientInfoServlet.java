import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class MyClientInfoServlet extends HttpServlet
{
  public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
   {
     resp.setContentType("text/html");
     PrintWriter pw =resp.getWriter();
     String compName = req.getRemoteHost();
     String compAddress = req.getRemoteAddr();
     //Html Starts From here
     pw.println("<html>");
     pw.println("<head><title>Client Details Servlet</title>");
     pw.println("<style>table,tr,td{ background-color: black;color:white;}</style></head>");
     pw.println("<body>");
     //table start here
     pw.println("<h2>Client Computer Name : "+compName+"</h2>");
     pw.println("<h2>Client Computer ip : "+compAddress+"</h2>");
     pw.println("<table border='2'>");
     pw.println("<tr><th>Header Names</th><th> Header Values </th></tr>");
     Enumeration en = req.getHeaderNames();
     while(en.hasMoreElements()){
       String headerName = (String)en.nextElement();
       String headerValue = req.getHeader(headerName);
       pw.println("<tr><td>"+ headerName +"</td><td>"+ headerValue +"</td></tr>");
   }
     pw.println("</table>");
     pw.println("</body>");
     pw.println("</html>");
     pw.close();
   }
}