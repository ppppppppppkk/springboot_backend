package book.dao;

import book.dto.ArticleForm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component // 스프링 컨테이너에 해당 클래스를 빈(객체) 등록
public class ArticleDao {
    // ---------- JDBC DB연동 ----------//
    // 1. DB연동 필요한 인터페이스( 구현객체 => 각 회사(mysql com.mysql.cj.jdbc패키지내 Driver클래스 ) ) 필드 선언
    private Connection conn; // DB연동 결과 객체를 연결 , 기재된 SQL Statement객체 반환.
    private PreparedStatement ps;  // 기재된 SQL에 매개변수 할당 , SQL 실행
    private ResultSet rs;          // select 결과 여러개 레코드를 호출
    public ArticleDao(){         // db연동를 생성자에서 처리
        try {
            // 1. mysql JDBC 호출 ( 각 회사별  상이 , 라이브러리 다운로드 )
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 해당 db서버의 주소와 db연동
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb", "root", "1234");
        }catch (Exception e ){   System.out.println(e); }
    }
    // ---------- ---------- ----------//
    // ---------- SQL 이벤트  ----------//
    // 1. 글쓰기 처리
    public ArticleForm createArticle( ArticleForm form ){
        System.out.println("ArticleDao.createArticle");
        System.out.println("form = " + form);
        //1. 세이브 성공시 반환할 Dto
        ArticleForm saved = new ArticleForm();

        try{      // 0. try{}catch (Exception e ){}
            String sql ="insert into article( title , content ) values( ? , ? )"; // 1.

            //1.SQL 기재 할때 자동으로 생성된 키 호출 선언
            //2.rs = ps.getGeneratedKeys() 이용한 생성된 키 반환
            //3.rs.next()  ---> rs.get(1) : 방금 생성된 키 반환
            ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS); // 2.
            ps.setString( 1 , form.getTitle() ); // 3.
            ps.setString( 2 , form.getContent() );
            // 4.
            int count = ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if( rs.next() ){
                System.out.println("방금 생성된 pk (id)"+rs.getLong(1));
                Long id = rs.getLong(1);
               saved.setId(id);
               saved.setTitle(form.getTitle() );
               saved.setContent(form.getContent());
                return saved;
            }
            // 5.
            // if( count == 1 ) return ;
        }catch (Exception e ){  System.out.println(e);  }
        return saved;
    }

    // ---------- ---------- ----------//

    //2. 개별 글 조회
    public ArticleForm show(Long id){
        try{

            String sql = "select * from article where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,id);

            rs  = ps.executeQuery();
            if( rs.next() ){
                ArticleForm form = new ArticleForm(rs.getLong(1),rs.getString(2),rs.getString(3));
            return form;
            }

        }catch(Exception e){
            System.out.println("e = " + e);
        }
        return null;
    }


    //------------------------------------------------------
       // 3. 모든글 조회
    public List<ArticleForm> index(){
        List<ArticleForm> list = new ArrayList<>();

        try{
            String sql = "select * from article";
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){

                ArticleForm form = new ArticleForm(rs.getLong(1),rs.getString(2),rs.getString(3));

                list.add(form);
            }
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return list;
    }
    //--------------------------------------------------------
    // 4. id 해당하는 게시물 정보 호출 , 매개변수 :id , 리턴 : dto 수정 1단계
    public ArticleForm findById(Long id){
        try{
            String sql = "select * from article where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                return new ArticleForm(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3)
                );

            }
        }catch (Exception e){System.out.println("e = " + e);}
        return null;
    }
    //-------------------------------------------
    //5. 해당 id 수정 처리 수정 2단계
    public ArticleForm update(ArticleForm form){
        try {
            String sql = "update article set title = ?, content = ? where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setLong(3,form.getId());
            ps.setString(1,form.getTitle());
            ps.setString(2,form.getContent());
            int count = ps.executeUpdate();
            if( count == 1){
                return form;
            }

        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return null;
    }
    //=====================================================
    //6. 삭제
    public boolean delete(long id){
        try {
            String sql = "delete from article where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,id);
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }

}


















