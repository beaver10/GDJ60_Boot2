package com.iu.base.rest;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.BoardVO;
import com.iu.base.board.notice.NoticeService;
import com.iu.base.util.Pager;

import lombok.extern.slf4j.Slf4j;

//controller 내의 모든 method가 @ResponseBody가 필요하다면 선언 
@RestController
@Slf4j
public class RestFulController {

	@Autowired
	private NoticeService noticeService;
	
//	@GetMapping("/rest/{num}/detail")
	@GetMapping("/rest/detail")
//	@ResponseBody
	public BoardVO getDetail(BoardVO boardVO) throws Exception{
		boardVO = noticeService.getDetail(boardVO);
		
		return boardVO;
		
	}
	
	@GetMapping("/rest/list/{page}")
//	@ResponseBody
	public List<BoardVO> getList(@PathVariable(name = "page" ) Long p, Pager pager) throws Exception {
		//@PathVariable(name 이름을 따로 지정 = "page", required 필수니? = false, value = "1" )
		log.error("page ======{}",p);
				
		List<BoardVO> ar = noticeService.getList(pager);
		
		return ar;
	}
	
}
