package boardmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;




@Controller
public class MemberMybatisController {
	
	@Autowired 
	@Qualifier("boardmembermapperservice")//mapper 방식
	MemberService memberservice;
	
	
	@GetMapping("/boardlogin")
	public String loginform() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	public String loginin(String id,int pw, HttpServletRequest request) {
		MemberDTO dto = memberservice.oneMember(id);
		if(dto != null && dto.getPw()==pw) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionid",id);
		}
		return "board/start";
	}
	
	@RequestMapping("/boardlogout")
	public String logout(HttpSession session) {
		if(session.getAttribute("sessionid") != null) {
			session.removeAttribute("sessionid");
		}
		return "board/start";
	}

	
}
