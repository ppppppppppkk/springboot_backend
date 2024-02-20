package ezenweb.model.dao;

import ezenweb.model.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Component
public class MemberDao {
    private Connection conn; // DB연동 결과 객체를 연결 , 기재된 SQL Statement객체 반환.
    private PreparedStatement ps;  // 기재된 SQL에 매개변수 할당 , SQL 실행
    private ResultSet rs;          // select 결과 여러개 레코드를 호출
    public MemberDao() {         // db연동를 생성자에서 처리
        try {
            // 1. mysql JDBC 호출 ( 각 회사별  상이 , 라이브러리 다운로드 )
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 해당 db서버의 주소와 db연동
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring1", "root", "1234");
            System.out.println("Db연동성공");
        } catch (Exception e) {
            System.out.println("DB연동실패");
            System.out.println(e);
        }

    }

    public boolean doPostsignup( MemberDto memberDto ){

    try {
        String sql = "insert into springtest1(id,pw,name,email,phone,img) values(?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);

        ps.setString(1,memberDto.getId());
        ps.setString(2,memberDto.getPw());
        ps.setString(3,memberDto.getName());
        ps.setString(4,memberDto.getEmail());
        ps.setString(5,memberDto.getPhone());
        ps.setString(6,memberDto.getImg());

        int count = ps.executeUpdate();

        if(rs.next() ) return true;

    }catch (Exception e){
        System.out.println("e = " + e);
    }
    return false;
    }

//
//    //-------------------------------------------------------
//    //회원 수정 no 가지고 오기
//    public MemberDto findbyNo(Long no){
//        try{
//            String sql = "select * from 테이블명 where no = ?";
//            ps = conn.prepareStatement(sql);
//            ps.setLong(1,no);
//            rs = ps.executeQuery();
//            if(rs.next()){
//                return new MemberDto(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3)
//                );
//
//            }
//        }catch (Exception e){System.out.println("e = " + e);}
//        return null;
//    }

}
