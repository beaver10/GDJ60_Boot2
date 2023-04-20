package com.iu.base.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.BoardFileVO;
import com.iu.base.board.BoardVO;
import com.iu.base.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@Value("${app.upload.qna")
	private String path;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	
	//list
	@GetMapping("list")
	public ModelAndView getList(ModelAndView mv, Pager pager) throws Exception{
		
		List<BoardVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//detail
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		BoardVO boardVO = qnaService.getDetail(qnaVO);
		
		mv.addObject("boardVO", boardVO);
		mv.setViewName("board/detail");
		
		return mv;
		
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileVO boardFileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardFileVO = qnaService.getFileDetail(boardFileVO);
		
		mv.addObject("boardFileVO", boardFileVO);
		mv.setViewName("fileManager");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setInsert(QnaVO qnaVO, MultipartFile[] boardFiles)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setInsert(qnaVO, boardFiles);
		
		mv.setViewName("redirect:./list");
		
		return mv;
		
	}

}
