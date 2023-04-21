package com.iu.base.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("admin")
	public void getAdmin()throws Exception{
		
	}
	
	@GetMapping("mypage")
	public void getMypage()throws Exception{
		
	}
	
	
	
	@GetMapping("login")
	public ModelAndView getLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/login");
		return mv;
		
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.getLogin(memberVO);
		
		mv.setViewName("redirect:./login");
		
		if(memberVO!=null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}
		
		return mv;
	}
	
	
	@GetMapping("logout")
	public ModelAndView getLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	
	@GetMapping("idDuplicateCheck")
	@ResponseBody 
	public boolean idDuplicateCheck(MemberVO memberVO)throws Exception{
		log.debug("ID 중복 체크  =======");
		boolean check = false;
		
		memberVO = memberService.idDuplicateCheck(memberVO);
		
		if(memberVO !=null) {
			check=true;
		}

		return check;
	}
	

	
	
	
	@GetMapping("join")
	public ModelAndView setJoin()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/join");
		
		return mv;
	}
	
	
	@PostMapping("join")
	public ModelAndView setJoin(MemberVO memberVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setJoin(memberVO);
		
//		mv.addObject("member", result);
		mv.setViewName("redirect:../");
		return mv;
		
	}
	
	
}
