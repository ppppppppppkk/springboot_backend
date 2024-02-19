package ezenweb.controller;

import example.day05.Member;
import ezenweb.model.dto.LoginDto;
import ezenweb.model.dto.MemberDto;
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


    //2. ==========로그인 처리 요청==========
    @PostMapping("/member/login")
    @ResponseBody
    public boolean doPostlogin(LoginDto logindto){
        System.out.println("Controller login");
        System.out.println("logindto = " + logindto);
        boolean result = true; //dao 처리
        return result;      //dao 요청후 응답 결과를 보내기
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
