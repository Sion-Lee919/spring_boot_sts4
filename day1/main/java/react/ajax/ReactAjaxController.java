package react.ajax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ReactAjaxController {
	
	@CrossOrigin(origins="*")
	@RequestMapping("/helloajax")
	//@ResponseBody @RestController써서 안써도됨
	public LoginDTO test() {
		return new LoginDTO("boot id",1234);
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@GetMapping("/helloajaxparam")
	public LoginDTO test(String id, int pw) {
		return new LoginDTO(id,pw);
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@PostMapping("/helloajaxparam")
	public LoginDTO test(@RequestBody LoginDTO dto) {
		System.out.println("포스트 전달받음"+dto.id +":"+dto.pw);
		return dto;
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@GetMapping("/helloajaxarray")
	public int[] testarray(int [] ids) {//ids=1&ids=5&ids=9
		//ids[]=1&ids[]=5&ids[]=9 로 넘어와짐
		for(int i=0; i < ids.length; i++) {
			ids[i]=ids[i]*10;
				System.out.println(ids[i]);
		}
		return ids;
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@PostMapping("/helloajaxobjectarray")
	public PlayDTO testplayer(@RequestBody Map<String, Object> parameters) throws Exception{
		String json = parameters.get("playerArray").toString();
		ObjectMapper mapper = new ObjectMapper();
		List<PlayDTO> playerList = mapper.readValue(json, new TypeReference<ArrayList<PlayDTO>>() {});
		for(PlayDTO dto :playerList) {
			if(dto.player.equals("son")) {
			return new PlayDTO(dto.player,dto.goal,"한국","손흥민");
			}
		}
		return new PlayDTO("알수없음",0,"국적모름","이름모름");
	}
	
}

class LoginDTO{
	String id;
	int pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public LoginDTO(String id, int pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pw=" + pw + "]";
	}
	
}

class PlayDTO{
	String player;
	int goal;
	String fullName;
	String nation;
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public PlayDTO(String player, int goal, String fullName, String nation) {
		super();
		this.player = player;
		this.goal = goal;
		this.fullName = fullName;
		this.nation = nation;
	}
	public PlayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PlayDTO [player=" + player + ", goal=" + goal + ", fullName=" + fullName + ", nation=" + nation + "]";
	}
	
}