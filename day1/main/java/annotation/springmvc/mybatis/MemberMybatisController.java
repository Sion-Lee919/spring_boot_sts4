package annotation.springmvc.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class MemberMybatisController {
	
	@Autowired 
	//@Qualifier("memberServiceImpl")//dao방식
	@Qualifier("memberMapperServiceImpl")//mapper 방식
	MemberService memberservice;
	
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = memberservice.memberList();
		int membercount = memberservice.memberCount();
		mv.addObject("memberlist",list);
		mv.addObject("membercount",membercount);
		mv.setViewName("mybatis/memberlist");

		
		return mv;
	}
	
	@RequestMapping("/membersearchlist")
	public ModelAndView memberlist(String item, String searchword) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(item.equals("이름검색")) {
		map.put("colname", "name");
		map.put("colvalue", "%"+searchword+"%");
		}
		else if(item.equals("폰번호검색")) {
			map.put("colname", "phone");
			map.put("colvalue", "%"+searchword+"%");
			}
		else if(item.equals("이메일검색")) {
			map.put("colname", "email");
			map.put("colvalue", "%"+searchword+"%");
			}
		else if(item.equals("아이디검색")) {
			map.put("colname", "id");
			map.put("colvalue", "%"+searchword+"%");
			}
		List<MemberDTO> searchlist = memberservice.memberSearchList(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",searchlist);
		mv.setViewName("mybatis/memberlist");
		
		return mv;
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "mybatis/loginform";
	}
	
	@PostMapping("/login")
	public String loginin(String id,int pw, HttpServletRequest request) {
		MemberDTO dto = memberservice.oneMember(id);
		if(dto != null && dto.getPw()==pw) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionid",id);
		}
		return "mybatis/start";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("sessionid") != null) {
			session.removeAttribute("sessionid");
		}
		return "mybatis/start";
	}
	
	
}
