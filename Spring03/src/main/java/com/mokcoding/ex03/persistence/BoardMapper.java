package com.mokcoding.ex03.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	// 댓글 수 변경
	public int updateReplyCount(
			@Param("amount") int amount, @Param("boardId") int boardId);
	// @Param : 자바 객체의 속성을 mapper에 매핑
}
