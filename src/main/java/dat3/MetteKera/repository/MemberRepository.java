package dat3.MetteKera.repository;

import dat3.MetteKera.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String > {
}
