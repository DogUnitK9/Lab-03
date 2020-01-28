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
        var iUser = req.getParameter("user");
        var iPass = req.getParameter("pass");
        for (int i = 0; i < Main.users.size(); i++){
            var user = Main.users.get(i).user;
            var pass = Main.users.get(i).pass;
            var name = Main.users.get(i).name;
            if( iUser.equals(name) || iPass.equals(pass)){
                var sess = req.getSession();
                sess.setAttribute("name", name );
                pw.printf("Logged in "+name + " as user: " + user);
            } 
            else {
                pw.printf("Invalid User/pass");
        }
        }
    }

}