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
public class MemberResponse {
    String username, email, password;

    public MemberResponse(Member m) {
        this.username = m.getUsername();
        this.email = m.getEmail();
        this.password = m.getPassword();
    }
}
