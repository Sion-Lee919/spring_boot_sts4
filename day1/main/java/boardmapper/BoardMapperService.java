package boardmapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class BoardMapperService implements BoardService{

	@Autowired
	BoardMapper mapper;
	
	@Override
	public String registerBoard(BoardDTO dto) {
		int result = mapper.insertBoard(dto);
		if (result == 1) return "글쓰기 성공"; 
		else return "글쓰기 실패";
	}

	@Override
	public List<BoardDTO> pagingList( int pagenum) {
		int cnt =5;
		int start = (pagenum-1)*cnt+1;
		int end = pagenum *cnt;
		int array[] = {start,end};
		return mapper.pagingList(array);
	}

	@Override
	public int totalCount() {
		return mapper.totalCount();
	}

	@Override
	public BoardDTO boarddetail(int seq) {
		return mapper.boarddetail(seq);
	}

	@Override
	public int count(int seq) {
		return mapper.count(seq);
	}

	@Override
	public int del(int seq) {
		return mapper.del(seq);
	}

	@Override
	public int update(BoardDTO dto) {
		return mapper.update(dto);
	}
	
	
	
}
