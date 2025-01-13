package annotation.springmvc.ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import annotation.springmvc.memberService.MemberDTO;

@Controller
public class AjaxAdminController {
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 
			 
			@RequestMapping("/ajaxadminstart") 
			public String start(){ 
			return "ajax/admin"; 
			} 
			
			@RequestMapping(value="/ajaxadminlist", produces = {"application/json;charset=utf-8"}) 
			public @ResponseBody ArrayList<MemberDTO>  ajaxlist(String id, int pw) { 
			
			if(id.equals("admin") && pw == 1111) { 
				for(int i = 1; i <= 10; i++ ) { 
					MemberDTO dto = new MemberDTO(); 
					dto.setId("ajax" + i);  
					dto.setPw(i * 1000);  
					dto.setName("홍길동" + i); 
					dto.setPhone("010-1234-456" + i); 
					dto.setEmail("hong" + i + "@gil.dong"); 
					dto.setRegdate("2025-01-07"); 
					list.add(dto); 
				} 
			} 
			return list; 
			}
			
			@ResponseBody 
			@RequestMapping("/getpw/{id}") 
			public String getpw(@PathVariable("id") String id) {
				String pwpw="";
				for (MemberDTO item : list) {
				    if (id.equals(item.getId())) {
				    	pwpw = String.valueOf(item.getPw());
				    	pwpw = pwpw.substring(0,2)+"*".repeat(pwpw.length()-2);
				    	return "{\"pw\":\""+pwpw+"\"}";
				    }
				}
				  		pwpw="{\"해당아이디없음\"}";
				    	return pwpw;

				
				
				
				
			}
			/*String getpw( ...... ){ 
			list 내부에 id 존재하는지 판단하여 
			존재하면 {pw: pw값(10***) } 리턴 
			존재하지 않으면 {pw:해당아이디없음} 리턴*/
			
}
