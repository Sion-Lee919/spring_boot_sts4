package boardmapper;

import java.util.List;

public interface BoardService {
	String registerBoard(BoardDTO dto);
	List<BoardDTO> pagingList(int pagenum);
	int totalCount();
	BoardDTO boarddetail(int seq);
	int count(int seq);
	int del(int seq);
	int update(BoardDTO dto);
}
