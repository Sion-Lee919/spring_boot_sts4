 package annotation.springmvc.mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenberMain2 {

	public static void main(String[] args) throws IOException ,SQLException{
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");

		MemberService service = factory.getBean("memberServiceImpl", MemberService.class);
		
		System.out.println("==회원리스트==");
		List<MemberDTO> list = service.memberList();
		for(MemberDTO dto : list) {
			System.out.println(dto.getId()+ " : " + dto.getName()+ " : "+ dto.getEmail());
		}
		System.out.println("총회원수 = "+list.get(list.size()-1).getPw());
		
		
		/*
		System.out.println("==한명의 회원정보==");
		MemberDTO dto = service.oneMember("q1");
		System.out.println(dto.getId()+ " : " + dto.getName());
		
		MemberDTO dto2 = new MemberDTO();
		dto2.setId("mybatis4");
		dto2.setName("박길동");
		dto2.setPw(4444);
		dto2.setPhone("010-1122-3344");
		dto2.setEmail("ss@nn.com");	
		String result = service.registerMember(dto2);
		System.out.println("가입결과=" + result);
		//session.commit();
		
	
		
		MemberDTO dto3 = new MemberDTO();
		dto3.setId("mybatis4");
		dto3.setName("박길동");
		dto3.setPw(44444);
		dto3.setPhone("010-1332-3344");
		dto3.setEmail("s1s@n1n.com");		
		String result2 = service.modifyMember(dto3);
		System.out.println("수정결과=" + result2);
		
		
		String result3 = service.deleteMember("mybatis4");
		System.out.println("탈퇴결과=" + result3);*/
		
		/*
		List<MemberDTO> list = service.memberList("12");
		for(MemberDTO dto : list) {
			System.out.println(dto.id + ", "+dto.regdate);
		}*/
		
		/*
		ArrayList<Integer> mypage=new ArrayList();
		mypage.add(4);
		mypage.add(6);
		
		List<MemberDTO>paginglist = service.memberPagingList(mypage);
		for(MemberDTO dto : paginglist) {
			System.out.println(dto.id + ", "+dto.name+ "// "+ dto.getId()+ " : " + dto.getName());
		}*/
		
		/*
		HashMap<String,String> map = new HashMap<String, String>();
			map.put("colname", "id");
			map.put("colvalue", "q%");
			List<MemberDTO> searchlist = service.memberSearchList(map);
			for(MemberDTO dto : searchlist) {
				System.out.println(dto.id + ", "+dto.name+ "// "+ dto.getId()+ " : " + dto.getName());
			}*/
		
		/*MemberDTO dto = new MemberDTO();
		//dto.setId("q");
		//dto.setName("홍");
		dto.setEmail("e");
		List<MemberDTO> searchlist2 = service.memberSearchList(dto);
		for(MemberDTO dto2 : searchlist2) {
			System.out.println(dto2.getId()+ " : " + dto2.getName()+ " : " + dto2.getPhone()+ " : " + dto2.getEmail()+ " : " + dto2.getRegdate());
		}	*/
		
		/*MemberDTO dto = new MemberDTO();
		dto.setId("q");
		dto.setPw(12);
		
		
		MemberDTO resultdto = session.selectOne("totalsql", dto);
		System.out.println(resultdto.getId()+ " : " + resultdto.getName()+ " : " + resultdto.getPhone()+ " : " + resultdto.getEmail()+ " : " + resultdto.getRegdate());
		*/	
	}

}
