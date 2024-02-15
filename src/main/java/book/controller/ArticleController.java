package book.controller;

import book.dao.ArticleDao;
import book.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Locale;

// 1.스프링 컨테이너(메모리 저장소)에 빈(객체/힙) 등록
// 2.스프링이 해당 클래스를 사용할수 있다.
// 3.모든 클라이언트 요청은 컨트롤러로 들어온다.
@Controller
@Slf4j // 자바에서 간단한 로그 처리
public class ArticleController {

    @Autowired // 스프링 컨테이너에 등록된 빈 주입한다.
    ArticleDao articleDao;

    // 1. 글쓰기 페이지 반환
    @GetMapping("/articles/new") // HTTP 요청 경로 : GET방식 : localhost:80/articles/new
    public String newArticleForm(){
        return "articles/new";   // .확장자 빼고 resources/templates 부터 경로 작성
    } // m end
    // 2. 글쓰기 처리
        // 1. <form action="/articles/create" method="post">
        // 2. 입력태그 속성의 name과 DTO 필드의 필드명 일치하면 자동 연결/대입 된다.
        // 3. public 생성자 필요

    @PostMapping("/articles/create")    // HTTP 요청 경로 : POST방식 : localhost:80/articles/create
    public String createArticle( ArticleForm form ){
        // soutm : 메소드명 출력
        System.out.println( new Date() );
        System.out.println("ArticleController.createArticle");
        // soutp : 메소드 매개변수 출력
        System.out.println("form = " + form);

        // ( 디버그 ) 로그
        log.debug( form.toString() );

        // ( 경고 ) 로그
        log.warn( form.toString() );

        // ( 에러 ) 로그
        log.error( form.toString() );

        // ( 정보 ) 로그
        log.info( form.toString() ); // 자동완성 : 메누 -> 파일 -> 설정 -> 플러그인 -> 마켓플레이스 -> Lombok 설치

        // DAO에게 요청하고 응답 받기.
        ArticleForm saved = articleDao.createArticle( form );

        return "redirect:/articles/"+saved.getId() ;
    } // m end

    //p.156 조회

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        System.out.println("id = " + id);
        //model.addAttribute("키","값");
        ArticleForm form = articleDao.show(id);
        System.out.println("form = " + form);

        model.addAttribute("article",form);
        model.addAttribute("name","유재석");

        return "articles/show";
    }

        //전체 조회
    @GetMapping("/articles")
    public String index(Model model){

        List<ArticleForm> result = articleDao.index();
        model.addAttribute("articleList", result);

        return "articles/index";

    }
        //p.202 수정 1단계
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id , Model model){
        System.out.println("id = " + id);
        //1. DAO에게 요청하고 응답 받기
        ArticleForm form = articleDao.findById(id);
        //2. 응답결과 뷰 템플릿에게 보낼 준비 model
        model.addAttribute("article", form);
        //3. 뷰 페이지 설정

        return "articles/edit";
    }
    //@PathVariable : 요청한HTTP URL 경로상의 매개변수 대입
        // URL : /articles/{매개변수명}/edit

        //p.214 수정 처리 2단계
    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        // * form 입력 데이터를 Dto 매개변수로 받을때
            // form 입력상자의 name 과 Dto의 필드명 동일
            // Dto의 필드 값을 저장할 생성자 필요

        // 2.DAO 에게 요청하고 응답받기
        ArticleForm updated = articleDao.update(form);
        // 3. 수정 처리된 상태페이지로 이동
        return "redirect:/articles/"+updated.getId();
    }

    //=======================================
    // 삭제 단계
    //p.234
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable long id){
        System.out.println("id = " + id);
        // 1. 삭제할 대상
        // 2. dao 삭제 요청하고 응답받기
        boolean result = articleDao.delete(id);
        //3. 결과 페이지로 리다이렉트 하기


        return "redirect:/articles";
    }



}
/*

    @어노테이션
        1. 표준 어노테이션 : 자바에서 기본적으로 제공
            @Override : 메소드 재정의
            등등
       2. 메타 어노테이션 : p.64
            - 소스코드에 추가해서 사용하는 메타 데이터
            - 메타 데이터 : 구조화된 데이터
            - 컴파일(실행) 또는 실행 했을때 코드를 어떻게 처리 해야 할지 알려주는 정보
            @SpringBootApplication
                - 1. 내장 서버(톰캣) 지원
                - 2. 스프링 MVC 패턴 내장
                    view : resources
                    controller : @Controller , @RestController
                        service : @Service
                    model(dao) :  @Repository
                        entity(db table) : @Entity
                        그외 별도 : @Component
                        설정 클래스 : @Configuration
                - 3. 컴포넌트(module) 스캔 : MVC 클래스 스캔
                    동일 패키지내 혹은 하위패키지 스캔
            @Controller
            @GetMapping


        - 다른 클래스의 함수를 호출하는방법
        [ MVC패턴은 클래스들이 분업하기 때문에 서로 다른 클래스들끼리 데이터 주고(매개변수)받는다(리턴). *상호작용 특징 ]

        // 1. 해당 함수가 인스턴스(static없으면) 멤버이면
        ArticleDao articleDao = new ArticleDao();
        articleDao.createArticle();
        // 2. 해당 함수가 인스턴스(static없으면) 멤버이면
        new ArticleDao().createArticle();
        // 3. 해당 함수가 정적(static) 멤버이면
        ArticleDao.createArticle();
        // 4. 해당 클래스가 싱글톤( 프로그램내 무조건 하나의 객체만 갖는 패턴)
        ArticleDao.getInstance().createArticle();
        // 5. 스프링 컨테이너(JVM만들어진 메모리 저장소) 등록 빈(객체) 된 경우
        @Autowired
        ArticleDao articleDao;

 */
