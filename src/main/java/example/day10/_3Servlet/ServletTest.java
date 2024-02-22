package example.day10._3Servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/team4") // web.xml에 해당 서블릿 등록
public class ServletTest extends HttpServlet {
    // HttpServlet 클래스로부터 상속받으면 다양한 HTTP 관련 메소드 사용

    @Override// 1. [최초 요청 1번 실행] 해당 서블릿 객체가 생성 되었을 때 실행되는 메소드
    public void init(ServletConfig config) throws ServletException {
        System.out.println("ServletTest.init");
        //DB 연동 미리 해놓거나 해놓을 수 있음,, Dao로 가서 DB연동만 해놓기정도.?
        super.init(config);
    }

    @Override// 2. [요청마다 실행] 해당 서블릿으로부터 HTTP 서비스가 실행되었을때 실행되는 메소드
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest.service");
        super.service(req, resp);
    }

    @Override// 3. [HTTP method에 따라] HTTP 서비스 요청중에 HTTP method 방식이 get이면 실행되는 메소드
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest.doGet");
        System.out.println("get 메소드 실행");
        resp.setContentType("text/html");
        resp.getWriter().println("get 메소드 실행"); // get 메소드 실행.text/html
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest.doPost");
        System.out.println("post 메소드 실행");
        resp.setContentType("text/html");
        resp.getWriter().println("post 메소드 실행");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest.doPut");
        System.out.println("put 메소드 실행");
        resp.setContentType("text/html");
        resp.getWriter().println("put 메소드 실행");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest.doDelete");
        System.out.println("delete 메소드 실행");
        resp.setContentType("text/html");
        resp.getWriter().println("delete 메소드 실행");
    }

    @Override// 4. [서버가 종료될 때 1번 실행] 해당 서블릿 객체가 삭제 되었을 때,사라졌을 때 실행되는 메소드.
    public void destroy() {
        System.out.println("ServletTest.destroy");
        super.destroy();
    }
}