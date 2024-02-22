package example.day09._3ManProject.Model.Dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PayDto {
    public int pno;
    public String payreason;
    public int pay;
    public  String date;
}
