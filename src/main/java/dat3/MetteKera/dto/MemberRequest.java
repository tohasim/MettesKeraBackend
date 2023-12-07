package dat3.MetteKera.dto;


import dat3.MetteKera.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    String username, email, password, zip;

    public MemberRequest(Member member) {
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.password = member.getPassword();
    }

    public static Member getMemberEntity(MemberRequest request){
        return new Member(request.getUsername(), request.getEmail(), request.getPassword(), request.getZip());
    }
}
