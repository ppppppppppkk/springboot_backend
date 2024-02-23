package example.day11._2Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/day11")
public class RestController3 {

    //HTTP 이용한 매개변수 보내는 방법
        // 1. 경로상의 변수 http://localhost/day11/bl/안녕
        // 2. 쿼리스트링 변수 : http://localhost/day11/bl?key=value
    //1. Get

       //응답 contentType : application/json
    @GetMapping(value = "/red")
    public String getred(String sendMSG)  {
        System.out.println("RestController1.getred");
        //요청
        System.out.println("sendMSG = " + sendMSG);
        //응답
        return "안녕[클라이언트] GET";

    }
    //2. Post

    @PostMapping(value = "/red")
    public Map<String, String> postred(HttpServletRequest req , HttpServletResponse resp)  {
        System.out.println("RestController1.postred");

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

    @PutMapping(value = "/red")
    public int putwh( HttpServletRequest req) {

        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);

        return 10;
    }

    //4. delete

    @DeleteMapping(value = "/red")
    public boolean deletered(HttpServletRequest req )  {

        String sendMSG = req.getParameter("sengMSG");
        System.out.println("sendMSG = " + sendMSG);

        return true;
    }

}
