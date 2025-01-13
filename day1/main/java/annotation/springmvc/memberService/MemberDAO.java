package annotation.springmvc.memberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Autowired
	@Qualifier("dto1")
	MemberDTO dto;
	
	MemberDAO(){}
	
	MemberDAO(MemberDTO dto){
		this.dto = dto;
	}
	
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}
	
	public void insertMember() {
		System.out.println(dto.getId()+" 회원님 정상적으로 회원가입되셨습니다.");
	}
	
	public void insertMember(MemberDTO dto) {
		System.out.println(dto.getId()+" 회원님 정상적으로 회원가입되셨습니다.");
	}
	
	
	public boolean selectMember() {
		if(dto.getId().equals("spring") && dto.getPw()==1111) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean selectMember(MemberDTO dto) {
		if(dto.getId().equals("spring") && dto.getPw()==1111) {
			return true;
		}
		
		else {
			return false;
		}
	}
}
