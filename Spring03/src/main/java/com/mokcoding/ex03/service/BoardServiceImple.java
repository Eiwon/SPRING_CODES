package com.mokcoding.ex03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mokcoding.ex03.domain.BoardVO;
import com.mokcoding.ex03.persistence.BoardMapper;
import com.mokcoding.ex03.util.Pagination;

@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public int registerBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardMapper.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(int boardId) {
		return boardMapper.deleteBoard(boardId);
	}

	@Override
	public List<BoardVO> getBoardPage(Pagination pagination) {
		return boardMapper.selectBoardPage(pagination);
	}

	@Override
	public BoardVO getBoardById(int boardId) {
		return boardMapper.selectBoardById(boardId);
	}

	@Override
	public int getTotalCount() {
		return boardMapper.getTotalCount();
	}
	
	
	
	
}
