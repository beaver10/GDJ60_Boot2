package com.iu.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iu.base.aoptest.Card;
import com.iu.base.aoptest.Transport;
import com.iu.base.board.BoardFileVO;
import com.iu.base.util.Pager;

@Controller
public class HomeController {
	
	@Autowired
	private Transport transport;
	
	@Autowired
	private Card card;
	
	@GetMapping("/")
	public String Home() {
		
		return "index";
		
	}
	
	@GetMapping("/use")
	public void use() throws Exception{
		
		Pager pager = new Pager();
		pager.setKind("bus title");
		
		transport.useBus(pager);
		
		
		BoardFileVO boardFileVO = new BoardFileVO();
		boardFileVO.setFileName("subway file");
		
		transport.useSubway(boardFileVO);
		
		transport.takeWalk();
		
	}
	

}
