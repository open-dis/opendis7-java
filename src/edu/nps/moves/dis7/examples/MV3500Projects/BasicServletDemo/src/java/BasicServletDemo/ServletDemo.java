package BasicServletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Simple Hello World Servlet in a most stripped down form (no web.xml)
 *
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=me.ServletDemo"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
@WebServlet(value = "/"
//name = "ServletDemo",
//        urlPatterns = {"/"},
//        loadOnStartup = 1, 
//        asyncSupported = true
        )
public class ServletDemo extends HttpServlet {
  
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello World";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type + encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

} // end class file ServletDemo.java
