package example.day08.duo과제.duoDao;

import book.dto.ArticleForm;
import example.day08.duo과제.duoDto.DuoDto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DuoDao {
    private Connection conn; // DB연동 결과 객체를 연결 , 기재된 SQL Statement객체 반환.
    private PreparedStatement ps;  // 기재된 SQL에 매개변수 할당 , SQL 실행
    private ResultSet rs;

    public DuoDao(){         // db연동를 생성자에서 처리
        try {
            // 1. mysql JDBC 호출 ( 각 회사별  상이 , 라이브러리 다운로드 )
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 해당 db서버의 주소와 db연동
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Duoboard", "root", "1234");
        }catch (Exception e ){   System.out.println(e); }
    }

    public boolean DuoCreate(DuoDto duoDto){
        System.out.println("duoDto = " + duoDto);

        DuoDto saved = new DuoDto();
        System.out.println("saved");
        try{
            String sql ="insert into DuoBoard1( name , title , content ) values( ? , ? , ? )";

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,duoDto.getName());
            ps.setString(2,duoDto.getTitle());
            ps.setString(3,duoDto.getContent());

            int count = ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if(rs.next()){
                System.out.println("방금 생성된 pk(no) = " + rs.getLong(1));
                Long no = rs.getLong(1);
                saved.setNo(no);
                saved.setName(saved.getName());
                saved.setTitle(saved.getTitle());
                saved.setContent(saved.getContent());
                return true;
            }

        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }


    public List<DuoDto> show(){
        List<DuoDto> list = new ArrayList<>();

        try{
            String sql = "select * from DuoBoard1";
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){

                DuoDto form = new DuoDto(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4));

                list.add(form);
                System.out.println("form = " + form);
                return list;
            }
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return list;
    }










}
