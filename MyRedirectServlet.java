import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class MyRedirectServlet extends HttpServlet
{
  public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
      String useragent = req.getHeader("user-agent");
      if (useragent.indexOf("Chrome") != -1) {
          resp.sendRedirect("https://www.google.com");
      } else if (useragent.indexOf("Firefox") != -1) {
          resp.sendRedirect("https://www.mozilla.org");
      } else {
          resp.sendRedirect("https://scalive.in");
      }
  }
}