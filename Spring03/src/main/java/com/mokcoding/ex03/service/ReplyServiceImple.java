package com.mokcoding.ex03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokcoding.ex03.domain.ReplyVO;
import com.mokcoding.ex03.persistence.BoardMapper;
import com.mokcoding.ex03.persistence.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImple implements ReplyService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	@Transactional(value = "transactionManager") // transactionManager가 관리
	public int createReply(ReplyVO replyVO) {
		log.info("createReply()");
		int insertResult = replyMapper.insert(replyVO);
		log.info(insertResult + "행 댓글 추가");
		
		int updateResult = boardMapper.updateReplyCount(1, replyVO.getBoardId());
		log.info(updateResult + "행 게시판 수정");
		return 1;
	}

	@Override
	public List<ReplyVO> getAllReply(int boardId) {
		log.info("getAllReply()");
		return replyMapper.selectListByBoardId(boardId);
	}

	@Override
	public int updateReply(int replyId, String replyContent) {
		log.info("updateReply()");
		ReplyVO replyVO = new ReplyVO();
		replyVO.setReplyId(replyId);
		replyVO.setReplyContent(replyContent);
		return replyMapper.update(replyVO);
	}

	@Override
	@Transactional(value = "transactionManager")
	public int deleteReply(int replyId, int boardId) {
		log.info("deleteReply()");
		int deleteResult = replyMapper.delete(replyId);
		log.info(deleteResult + "행 댓글 삭제");
		int updateResult = boardMapper.updateReplyCount(-1, boardId);
		log.info(updateResult + "행 게시판 수정");
		
		return 1;
	}
	
}
