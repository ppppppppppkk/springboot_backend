package example.day11._2Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController2 {

    //HTTP 이용한 매개변수 보내는 방법
        // 1. 경로상의 변수 http://localhost/day11/bl/안녕
        // 2. 쿼리스트링 변수 : http://localhost/day11/bl?key=value


    //1. Get
    @RequestMapping(value = "/day11/wh" , method = RequestMethod.GET)
    @ResponseBody   //응답 contentType : application/json
    public String getwh(HttpServletRequest req) throws IOException {
        System.out.println("RestController1.getwh");
        //요청
        String sendMSG = req.getParameter("sendMSG");
        System.out.println("sendMSG = " + sendMSG);
        //응답
        return "안녕[클라이언트] GET";

    }
    //2. Post
    @RequestMapping(value = "/day11/wh" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> postwh(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.postwh");

        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);

//        String[] strArray = new String[2];
//        strArray[0] = "안녕";
//        strArray[1] = "클라이언트";
//        List<String> strArray = new ArrayList<>();
//        strArray.add("안녕"); strArray.add("클라이언트");

        Map<String,String> strArray = new HashMap<>();
        strArray.put("안녕Map","클라이언트");

        return strArray;

    }
    //3. Put
    @RequestMapping(value = "/day11/wh" , method = RequestMethod.PUT)
    @ResponseBody
    public int putwh( HttpServletRequest req) throws IOException {

        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);

        return 10;
    }

    //4. delete
    @RequestMapping(value = "/day11/wh" , method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deletewh(HttpServletRequest req ) throws IOException {

        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);

        return true;
    }

}
