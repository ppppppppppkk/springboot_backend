package example.day11._1Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void  doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException  {
        System.out.println("TestServlet.doGet");
        String id = req.getParameter("id");
        System.out.println("id = " + id);

        int type = Integer.parseInt( req.getParameter("type"));
        System.out.println("type = " + type);

        //응답
        resp.setContentType("application/json");
        resp.getWriter().print("{ \"msg\" :\"서블릿이 보내온 메시지 \"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet.doPost");
        resp.setContentType("text/html");
        resp.getWriter().println("{ msg : doPost테스트 }");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet.doPut");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet.doDelete");
    }
}
