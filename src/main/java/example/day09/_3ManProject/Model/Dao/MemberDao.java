package example.day09._3ManProject.Model.Dao;

import example.day09._3ManProject.Model.Dto.MemberDto;
import example.day09._3ManProject.Model.Dto.PayDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public  MemberDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/memberdb",
                    "root", "1234"
            );
        }catch (Exception e ){
            System.out.println("e = " + e);
        }
    }



    //1. 등록

    public boolean doCreate(MemberDto memberDto){
        try {
            String sql= "insert into member(mname,mphone) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,memberDto.getMname());
            ps.setString(2,memberDto.getMphone());
            ps.executeUpdate(); return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    //2. 전체호출

    public List<MemberDto> doRead(){
        List <MemberDto> list = new ArrayList<>();
        try {
            String sql= "select * from member";
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                MemberDto memberDto =new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(memberDto);
            }

        }catch (Exception e){
            System.out.println(e);
        }

        return list;}

    //3. 수정
    public boolean doUpdate(int mno,String mphone){
        try {
            String sql ="update member set mphone= ? where mno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, mphone);
            ps.setInt(2,mno);
            ps.executeUpdate(); return true;

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    //4. 삭제

    public  boolean doDelete(int mno){
        try {
            String sql="delete from member where mno=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ps.executeUpdate(); return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    //5. 급여 내역 호출
    public List<PayDto> doPread(int mno){
        List<PayDto> list =new ArrayList<>();
        try {
            String sql="select * from pay where mno=? order by pno desc";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,mno);
            rs=ps.executeQuery();
            while (rs.next()){
                list.add(new PayDto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4))
                );
            }

        }catch (Exception e){
            System.out.println(e);
        }

        return list;
    }




    //6. 급여 등록
    public boolean doPay(int mno, PayDto dto){
        try {
            String sql= "insert into pay(payreason, pay, mno) values(?,?,?)";
            ps =conn.prepareStatement(sql);
            ps.setString(1,dto.getPayreason());
            ps.setInt(2,dto.getPay());
            ps.setInt(3,mno);
            ps.executeUpdate(); return true;

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
