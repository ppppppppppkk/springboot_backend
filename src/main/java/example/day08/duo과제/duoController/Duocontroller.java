package example.day08.duo과제.duoController;

import example.day08.duo과제.duoDao.DuoDao;
import example.day08.duo과제.duoDto.DuoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Duocontroller {

    @Autowired
    DuoDao duoDao;

    @GetMapping("/Duo/board")

        public String DuoCreate(DuoDto duoDto){
        System.out.println("테스트");
        System.out.println(duoDto);
        return "duoweb/duo";
    }

    @PostMapping("/Duo/boardlist")
    @ResponseBody
    public boolean boardlist(DuoDto duoDto){

        System.out.println("boardlist 테스트");
        boolean result = duoDao.DuoCreate(duoDto);

        return result;
    }
    @GetMapping("/Duo/show")
    @ResponseBody
    public List<DuoDto> show( Model model ){
        List<DuoDto> result = duoDao.show();


        System.out.println("showController"+result);
        return result;

    }




}
