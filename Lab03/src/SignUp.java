import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns={"/SignUp"})
public class SignUp extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/plain");
        var pw = resp.getWriter();
        var user = req.getParameter("user");
        var name = req.getParameter("name");
        var pass = req.getParameter("password");
        if( user == null || name == null || pass == null ){
            pw.printf("Missing Parameter: Please login/signup by using ?user=' '&name=' '&password=' ' ");
        } else {
            pw.printf("Signed up "+name + " as user: " + user);
        }
        var Person = new User(user,name,pass);
        Main.users.add(Person);
        
    }

}
