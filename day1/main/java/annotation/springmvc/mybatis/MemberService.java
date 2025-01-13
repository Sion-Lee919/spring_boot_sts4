package annotation.springmvc.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


public interface MemberService {
	List<MemberDTO> memberList();
	int memberCount();
	MemberDTO oneMember(String id);
	String registerMember(MemberDTO dto);
	String modifyMember(MemberDTO dto);
	String deleteMember(String id);
	List<MemberDTO> memberList(String month);
	List<MemberDTO> memberPagingList(ArrayList list);
	List<MemberDTO> memberSearchList(HashMap map);
	List<MemberDTO> memberSearchList2(MemberDTO dto);
	MemberDTO login(MemberDTO dto);
}
