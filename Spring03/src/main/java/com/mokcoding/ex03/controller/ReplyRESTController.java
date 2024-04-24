package com.mokcoding.ex03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mokcoding.ex03.domain.ReplyVO;
import com.mokcoding.ex03.service.ReplyService;

import lombok.extern.log4j.Log4j;

//* RESTful url과 의미
///reply (POST) : 댓글 추가(insert)
///reply/all/숫자 (GET) : 해당 글 번호(boardId)의 모든 댓글 검색(select)
///reply/숫자 (PUT) : 해당 댓글 번호(replyId)의 내용을 수정(update)
///reply/숫자 (DELETE) : 해당 댓글 번호(replyId)의 댓글을 삭제(delete)

@RestController
@RequestMapping("/reply")
@Log4j
public class ReplyRESTController {

	@Autowired
	private ReplyService replyService;

	@PostMapping
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO replyVO){
		log.info("createReply()");
		int result = replyService.createReply(replyVO);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end createReply
	
	@GetMapping("/all/{boardId}")
	public ResponseEntity<List<ReplyVO>> readAllReply(
			@PathVariable("boardId") int boardId){
		log.info("readAllReply()");
		log.info("boardId = " + boardId);
		List<ReplyVO> list = replyService.getAllReply(boardId);
		return new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
		// JSON으로 자동 변환
	} // end readAllReply
	
	@PutMapping("/{replyId}")
	public ResponseEntity<Integer> updateReply(
			@PathVariable("replyId") int replyId,
			@RequestBody String replyContent){
		log.info("updateReply()");
		int result = replyService.updateReply(replyId, replyContent);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end updateReply
	
	@DeleteMapping("/{replyId}/{boardId}")
	public ResponseEntity<Integer> deleteReply(
			@PathVariable("replyId") int replyId, @PathVariable("boardId") int boardId){
		log.info("deleteReply()");
		int result = replyService.deleteReply(replyId, boardId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	} // end deleteReply
	
}


