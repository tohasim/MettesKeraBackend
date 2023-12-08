package dat3.MetteKera.service;

import dat3.MetteKera.dto.MemberRequest;
import dat3.MetteKera.dto.MemberResponse;
import dat3.MetteKera.repository.MemberRepository;
import dat3.MetteKera.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<MemberResponse> getMembers(){
        List<Member> memberList = repository.findAll();
        return memberList.stream().map(MemberResponse::new).collect(Collectors.toList());
    }

    public MemberResponse addMember(MemberRequest request){
        Member member = MemberRequest.getMemberEntity(request);
        if (repository.existsById(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dette brugernavn er brugt");

        }
        member = repository.save(member);
        return new MemberResponse(member);
    }
}
