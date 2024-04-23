package com.mokcoding.ex03.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mokcoding.ex03.domain.BoardVO;
import com.mokcoding.ex03.util.Pagination;

@Mapper
public interface BoardMapper {
	
	public int insertBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(int boardId);
	
	public List<BoardVO> selectBoardPage(Pagination pagination);
	
	public BoardVO selectBoardById(int boardId);
	
	public int getTotalCount();
}
