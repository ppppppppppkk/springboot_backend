package ezenweb.model.dto;

import lombok.*;
import org.springframework.scheduling.support.SimpleTriggerContext;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class MemberDto {

    private int no;     //회원번호
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private String img;

}
