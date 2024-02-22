package example.day09._3ManProject.Controller;

import example.day09._3ManProject.Model.Dao.MemberDao;
import example.day09._3ManProject.Model.Dto.MemberDto;
import example.day09._3ManProject.Model.Dto.PayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberDao memberDao;
    //1. 등록
    @PostMapping("/members/create")
    @ResponseBody
    public boolean doCreate(MemberDto memberDto){
        boolean result = memberDao.doCreate(memberDto);
        return result;
    }

    //2. 전체호출
    @GetMapping("/members")
    @ResponseBody
    public List<MemberDto> doRead(){
        List<MemberDto> result= memberDao.doRead();
        return result;}

    //3. 수정
    @PostMapping("/members/update/{mno}/{mphone}")
    @ResponseBody
    public boolean update(@PathVariable int mno,@PathVariable String mphone){
        boolean result= memberDao.doUpdate(mno, mphone);
        return result;
    }

    //4. 삭제
    @GetMapping("/members/delete/{mno}")
    @ResponseBody
    public  boolean dodelete(@PathVariable int mno){
        boolean result = memberDao.doDelete(mno);
        return result;
    }
    //5. 급여 내역 호출
    @GetMapping("/members/pay/{mno}")
    @ResponseBody
    public List<PayDto> doPread(@PathVariable int mno){
        List<PayDto> result= memberDao.doPread(mno);
        return result;
    }





    //6. 급여 등록
    @PostMapping("/members/pay/{mno}")
    @ResponseBody
    public boolean doPay(@PathVariable int mno, PayDto dto){
        boolean result= memberDao.doPay(mno,dto);
        return result;
    }


}
