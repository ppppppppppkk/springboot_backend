package example.day11._2Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class RestController1 {

    //HTTP 이용한 매개변수 보내는 방법
        // 1. 경로상의 변수 http://localhost/day11/bl/안녕
        // 2. 쿼리스트링 변수 : http://localhost/day11/bl?key=value


    //1. Get
    @RequestMapping(value = "/day11/bl" , method = RequestMethod.GET)
    public void getbl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.getbl");
        //요청
        String sendMSG = req.getParameter("sendMSG");
        System.out.println("sendMSG = " + sendMSG);
        //응답
        resp.setContentType("text/html");
        resp.getWriter().print("클라이언트에게 안녕 GET");

    }
    //2. Post
    @RequestMapping(value = "/day11/bl" , method = RequestMethod.POST)
    public void postbl(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.postbl");

        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);
        resp.setContentType("text/html");
        resp.getWriter().println("안녕 클라이언트 POST");


    }
    //3. Put
    @RequestMapping(value = "/day11/bl" , method = RequestMethod.PUT)
    public void putbl( HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.putBl");
        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);
        resp.setContentType("text/html");
        resp.getWriter().println("안녕 클라이언트 PUT");
    }

    //4. delete
    @RequestMapping(value = "/day11/bl" , method = RequestMethod.DELETE)
    public void deletebl(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.deletebl");
        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);
        resp.setContentType("text/html");
        resp.getWriter().println("안녕 클라이언트 delete");
    }

}
