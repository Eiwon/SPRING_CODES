package com.mokcoding.ex03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mokcoding.ex03.domain.BoardVO;
import com.mokcoding.ex03.service.BoardService;
import com.mokcoding.ex03.util.PageMaker;
import com.mokcoding.ex03.util.Pagination;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	@GetMapping("/list")
	public void list(Pagination pagination, Model model) {
		List<BoardVO> list = boardService.getBoardPage(pagination);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPagination(pagination);
		pageMaker.setTotalCount(boardService.getTotalCount());
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", list);
	}
	
	
	@GetMapping("/detail")
	public void detail(int boardId, Model model) {
	   log.info("detail()");
	   
	   BoardVO boardVO = boardService.getBoardById(boardId);
	   model.addAttribute("boardVO", boardVO);
	   
	} // end detail
	
	
}
