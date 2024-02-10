import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Arrays;


public class MyUserDataServlet extends HttpServlet
{
  public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
   {
     resp.setContentType("text/html");
     PrintWriter pw =resp.getWriter();
     String  userName = req.getParameter("username");
     String  gender = req.getParameter("gender");
     String[] hb = req.getParameterValues("hobbies");
     //Html Starts From here
     pw.println("<html>");
     pw.println("<head><title>User data Servlet</title>");
     pw.println("</head><body>");
     //table start here
     pw.println("<h2> User Name : "+userName+"</h2><br>");
     pw.println("<h2> Gender : "+gender+"</h2><br>");
     String st = Arrays.toString(hb);
     pw.println("<h2> Hobbies : "+st.substring(1,st.length()-1)+"</h2><br>");
     pw.println("</body>");
     pw.println("</html>");
     pw.close();
   }
}