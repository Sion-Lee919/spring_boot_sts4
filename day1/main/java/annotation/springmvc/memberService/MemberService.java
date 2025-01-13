package annotation.springmvc.memberService;

public interface MemberService {
	void registerMember();
	
	String registerMember(MemberDTO dto);
}
