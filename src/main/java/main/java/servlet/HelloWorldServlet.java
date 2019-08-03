
package main.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name="HelloServlet",urlPatterns = "/hello")

public class HelloWorldServlet extends HttpServlet {

    private String name;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = new PrintWriter(response.getWriter());
        //punem html nostru intr-un string
        out.println("<html><head><title>Hello world title</title></head>");
        out.println("<body> Hello world at " + new Date());
        out.println("</body></html>");
        out.close();
    }


    //name din getParameter e name-ul din name.jsp (ce am eu pe pagina ca si camp de completat)
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        this.name = name;
        //name din set attribute trebuie sa fie aceeasi denumire cu name din result.jsp
        request.setAttribute("name", name);
        //requestdispatcher ma trimite la result.jsp si va afisa Hello + name.
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    public String getName(){
        return name;
    }
}