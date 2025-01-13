package boardmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
	int insertBoard(BoardDTO dto);
	List<BoardDTO> pagingList(int pagenum []);
	int totalCount();
	BoardDTO boarddetail(int seq);
	int count(int seq);
	int del(int seq);
	int update(BoardDTO dto);
}
