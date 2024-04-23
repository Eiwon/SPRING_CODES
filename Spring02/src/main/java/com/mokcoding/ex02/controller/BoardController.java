package com.mokcoding.ex02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mokcoding.ex02.domain.BoardVO;
import com.mokcoding.ex02.service.BoardService;
import com.mokcoding.ex02.util.PageMaker;
import com.mokcoding.ex02.util.Pagination;

import lombok.extern.log4j.Log4j;

@Controller // #Component
// - 클라이언트(JSP 페이지 등)와 service를 연결하는 역할
@RequestMapping(value = "/board") // URL : /ex02/board
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/list")
	public void list(Model model, Pagination pagination) {
		log.info("list()");
		log.info("pagination = " + pagination);
		List<BoardVO> boardList = boardService.getPagingBoards(pagination);
		int totalCount = boardService.getTotalCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPagination(pagination);
		pageMaker.setTotalCount(totalCount);
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("boardList" , boardList);
	} // end list
	
	// register.jsp 페이지 호출
	@GetMapping("/register")
	public void registerGET() {
		log.info("registerGET()");
	} // end registerGET
	
	
	@PostMapping("/register")
	public String registerPOST(BoardVO boardVO, RedirectAttributes reAttr) {
		log.info("registerPOST()");
		log.info("boardVO = " + boardVO.toString());
		int result = boardService.createBoard(boardVO);
		log.info(result + "행 등록");
		return "redirect:/board/list";
	} // end registerPOST
	
	// 특정 게시글 조회(게시글 번호를 입력받아 board 데이터 조회하여 detail.jsp로 전송)
	@GetMapping("/detail")
	public void detail(Model model, Integer boardId) {
		log.info("detail()");
		BoardVO boardVO = boardService.getBoardById(boardId);
		model.addAttribute("boardVO", boardVO);
	} // end detail
	
	// update.jsp 페이지 호출(게시글 번호를 입력받아 데이터 조회하여 modify.jsp로 전송)
	@GetMapping("/modify")
	public void modifyGET(Model model, Integer boardId) {
		log.info("updateGET()");
		BoardVO boardVO = boardService.getBoardById(boardId);
		model.addAttribute("boardVO", boardVO);
	} // end modifyGET
	
	// modify.jsp에서 데이터를 전송받아 게시글 데이터 수정
	@PostMapping("/modify")
	public String modifyPOST(BoardVO boardVO, RedirectAttributes reAttr) {
		log.info("modifyPOST()");
		int result = boardService.updateBoard(boardVO);
		log.info(result + "행 수정");
		return "redirect:/board/list";
	} // end modifyPOST
	
	// detail.jsp에서 boardId를 전송받아 게시글 데이터 삭제
	@PostMapping("/delete")
	public String delete(Integer boardId, RedirectAttributes reAttr) {
		log.info("delete()");
		int result = boardService.deleteBoard(boardId);
		log.info(result + "행 삭제");
		return "redirect:/board/list";
	} // end delete
	
	
}



