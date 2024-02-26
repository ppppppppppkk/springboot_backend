package ezenweb.controller;

import example.day05.Member;
import ezenweb.model.dto.LoginDto;
import ezenweb.model.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    //1. v <---> c HTTP 통신 방식 설계
    //2. controller mapping 함수 선언하고 통신 체크(API Tester)
    //3. Controller request 변수 매개변수 매핑
        //----------Dto, Service-------
    //4. 응답 : 1. 뷰 반환 text/html; vs 2. 데이터 : @ResponseBody JSON APPlication

    //1.======== 회원가입 처리 요청===========
    @PostMapping("/member/signup")
    @ResponseBody   // JSON
    public boolean doPostsignup(MemberDto memberDto){
        System.out.println("Controller signup");
        System.out.println("memberDto = " + memberDto);
        boolean result = true; //dao처리
        return result;    //dao 요청후 응답 결과를 보내기
    }

    //* Http요청 객체
    @Autowired
    private HttpServletRequest request;

    //2. ==========로그인 처리 요청==========
    @PostMapping("/member/login")
    @ResponseBody
    public boolean doPostlogin(LoginDto logindto){
        boolean result = true; //dao 처리

        //로그인 성공시 (세션)
            // 세션 :톰캣서버에 *브라우저 마다의 메모리 할당
            // 세션 객체 타입 : Object( 여러가지의 타입을을 저장할려고)
            //1. Http요청 객체 호출. HttpServletRequest
            //2. Http세션 객체 호출  request.getSession();
            //3. Http세션 데이터 저장 .setAttribute("세션명", "값")    -- 자동형변환
            //-  Http 세션 데이터 호출 .getAttribute("세션속성명")      -- 강제형변환
        // .invalidate();//현재 요청 보낸 브라우저의 모든 세션 초기화
        request.getSession().setAttribute("loginDto",3); //logint Dto : 3
                                                                    // 키 : 값


        return result;      //dao 요청후 응답 결과를 보내기
    } // f end

    //2-2========================== 로그인 정보 확인 요청====================
    @GetMapping("/member/login/check")
    @ResponseBody
    public int doGetLoginCheck(){
        // * 로그인 여부 확인 =  세션이 있다 없다 확인
            // 1-> http 요청 객체 호출, 2-> http세션 객체 호출 3-> http 세선 데이터 호출
        //null 형변환이 불가능하기 때문에 유효성 검사
        int loginDto = 0;
        Object sessionObj =  request.getSession().getAttribute("loginDto");
        if(sessionObj != null){
             loginDto = (Integer)sessionObj;
        }
        //만약에 로그인 했으면(세션에 데이터가 있으면) 강제형 변환을 통해 데이터 호출 아니면 0
        return loginDto;
    }

//2-3========================== 로그인 로그ㅏ웃 /세션 초기화====================
@GetMapping("/member/logout")
@ResponseBody
public boolean doGetloginOut(){


       //로그인 관련 세션 초기화
        //1. 모든 세션 초기화( 쇼핑몰 = 장바구니) 모든 세션의 속성이 초기화 -> 로그인 세션 외 다른 세션도 고려
    request.getSession().invalidate();//현재 요청 보낸 브라우저의 모든 세션 초기화
        //2. 특정 세션속성 초기화 => 동일한 세션 속성명에 null 대입한다
  //  request.getSession().setAttribute("loginDto", null);
        return true;
    }


    //1-2 회원가입 페이지 요청
    @GetMapping("member/signup")
    public String viewSignup(){
        System.out.println("회원가입테스트");
        return "ezenweb/signup";
    }


    //2-2 로그인 페이지 요청
    @GetMapping("member/login")
    public String viewLogin(){
        System.out.println("로그인테스트");
        return "ezenweb/login";
    }

    //=========================================================
    //3-1 회원수정 매핑2개 수정 1
    @GetMapping("member/{no}/update")
    public String update(@PathVariable long no , Model model){
        System.out.println("no = " + no);


        return "";

    }

    //3-2. 회원 수정 매핑2개 수정 2
    @PostMapping("member/edit")


    public String edit(){
        System.out.println("컨트롤러 수정 테스트");
    return "";
    }



    //4. 회원탈퇴 매핑1개
    @GetMapping("member/delete")
    public String delete(@PathVariable int no){
        System.out.println("컨트롤러 삭제 테스트");
        return "redirect:/member";
    }

}
