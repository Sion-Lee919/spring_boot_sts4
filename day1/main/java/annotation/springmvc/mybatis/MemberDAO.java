package annotation.springmvc.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	//@Qualifier("sqlSession")
	SqlSession session;
	
	
	public List<MemberDTO> memberList(){
		List<MemberDTO> list = session.selectList("a.memberList");
		return list;
	}
	
	public MemberDTO oneMember(String id) {
		return session.selectOne("oneMember","q1");
		
	}
	
	
	public int memberCount() {
		return session.selectOne("memberCount");
	
	}
	
	public int insertMember(MemberDTO dto) {
		return session.insert("insertMemberDTO",dto);
	}
	

	public int updateMember(MemberDTO dto) {
		return session.update("updateMember",dto);
	
	}
	
	public int deleteMember(String id) {
		return session.delete("deleteMember",id);
	
	}
	
	public List<MemberDTO> month(String month) {
		return session.selectList("month",month);
	}
	
	public List<MemberDTO> memberPagingList(ArrayList list){
		return session.selectList("memberPagingList",list);
	}
	
	public List<MemberDTO> memberSearchList(HashMap map){
		return session.selectList("memberSearchlist",map);
	}
	
	public List<MemberDTO> memberSearchList2(MemberDTO dto){
		return session.selectList("memberSearchlist2",dto);
	}
	
}
