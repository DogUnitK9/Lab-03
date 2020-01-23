import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns={"/Login"})
public class Login extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/plain");
        var pw = resp.getWriter();
        var user = req.getParameter("user");
        var name = req.getParameter("name");
        var pass = req.getParameter("password");
        if( user == null || name == null || pass == null ){
            pw.printf("Missing Parameter: Please provide parameter");
        } else {
            var sess = req.getSession();
            sess.setAttribute("user", user );
            pw.printf("Logged in "+name + " as user: " + user);
        }
    }

}