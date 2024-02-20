package example.day08._2인과제.controller;

import example.day04._1리스트컬렉션.Board;
import example.day08._2인과제.BoardDao;
import example.day08._2인과제.BoardDto;
import ezenweb.model.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {

    BoardDao boardDao = new BoardDao();

    // 1. 저장
    @PostMapping("/board/create")
    @ResponseBody
    public boolean create(BoardDto boardDto){               System.out.println("BoardController.create");System.out.println("boardDto = " + boardDto);
        boolean result =  boardDao.create( boardDto );      System.out.println("result = " + result);
        return result;
    }
    // 2. 전체 호출
    @GetMapping("/board/read")
    @ResponseBody
    public List<BoardDto> read( ){                          System.out.println("BoardController.read");
        List<BoardDto> result = boardDao.read();            System.out.println("result = " + result);
        return result;
    }
    // 3. 수정
    @PostMapping("/board/update")
    @ResponseBody
    public boolean update(BoardDto boardDto) {              System.out.println("BoardController.update");System.out.println("boardDto = " + boardDto);
        boolean result = boardDao.update( boardDto );       System.out.println("result = " + result);
        return result;
    }
    // 4. 삭제
    @GetMapping("/board/delete/{bno}")
    @ResponseBody
    public boolean delete( @PathVariable int bno ) {                      System.out.println("BoardController.delete");System.out.println("bno = " + bno);
        boolean result = boardDao.delete( bno );            System.out.println("result = " + result);
        return result;
    }



} // class end