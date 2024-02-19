package ezenweb.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter@Setter
public class LoginDto {

    private int no;     //회원번호
    private String id;
    private String pw;

}
