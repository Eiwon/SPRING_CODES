package com.mokcoding.ex03.service;

import java.util.List;

import com.mokcoding.ex03.domain.BoardVO;
import com.mokcoding.ex03.util.Pagination;

public interface BoardService {

	public int registerBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(int boardId);
	
	public List<BoardVO> getBoardPage(Pagination pagination);
	
	public BoardVO getBoardById(int boardId);
	
	public int getTotalCount();
	
	public int updateReplyCount(int amount, int boardId);
}
