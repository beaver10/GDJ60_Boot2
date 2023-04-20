package com.iu.base.board.notice;

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
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Value("${app.upload.notice}")
	private String path;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		BoardVO boardVO = noticeService.getDetail(noticeVO);
	
		mv.addObject("boardVO", boardVO);
		mv.setViewName("board/detail");
		
		return mv;
		
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileVO boardFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardFileVO = noticeService.getFileDetail(boardFileVO);
		
		mv.addObject("boardFileVO", boardFileVO);
		mv.setViewName("fileManager");
		
		return mv;
	}
	
	
	
	//list
	@GetMapping("list")
	public ModelAndView getList(ModelAndView mv, Pager pager)throws Exception{
		
		log.info("search : {}", pager.getSearch());
		log.info("kind : {}", pager.getKind());
		log.info("path : {}",path);
		
		List<BoardVO>ar = noticeService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
		
	}
	
	//add
	@GetMapping("add")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		return mv;
		
	}
	
	//add
	@PostMapping("add")
	public ModelAndView setInsert(NoticeVO noticeVO, MultipartFile[] boardFiles) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		for(MultipartFile multipartFile:boardFiles) {
			log.info("oriname : {} Size : {}",multipartFile.getOriginalFilename(), multipartFile.getSize());
		}
		
		int result = noticeService.setInsert(noticeVO, boardFiles);
			
		mv.setViewName("redirect:./list");
		return mv;
		
	}


}
