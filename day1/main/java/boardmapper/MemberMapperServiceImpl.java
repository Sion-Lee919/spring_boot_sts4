package boardmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardmembermapperservice")
public class MemberMapperServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mapper;

	@Override
	public MemberDTO oneMember(String id) {
		return mapper.oneMember(id);
	}

	
}
