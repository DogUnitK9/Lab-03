import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns={"/Home"})
public class Home extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
    resp.setContentType("text/plain");
    var pw = resp.getWriter();
    var sess = req.getSession();
    var name = sess.getAttribute("name");
    if(name == null){
    pw.printf("User is currently not logged in, sign up at http://localhost:2020/srv/SignUp or login at http://localhost:2020/srv/login");
    }
    else{
        pw.printf(name + " is currently logged in, logout at http://localhost:2020/srv/logout");
    }
    }
    }
