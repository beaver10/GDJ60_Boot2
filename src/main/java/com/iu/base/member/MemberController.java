package com.iu.base.member;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.mail.Message;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	

	
	@GetMapping("findPassword")
	public ModelAndView setFindPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/findPassword");
		return mv;
	}
	
	@PostMapping("findPassword")
	public ModelAndView setFindPassword(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setFindPassword(memberVO);
		log.error("정답은???{}",result);
		
		if(result == 0) {
//			mailService.sendMail(memberVO);
			mv.setViewName("common/result");
			mv.addObject("message", "사용자가 없습니다.");
		}else {
			mv.setViewName("common/result");
			mv.addObject("message", "메일이 발송되었습니다.");
			mv.addObject("url", "./login");
		}
		return mv;
	}
	
	
	@GetMapping("info")
	public void info(HttpSession session) {
		log.error("=============login info");
//		Enumeration<String> names = session.getAttributeNames();
//		while(names.hasMoreElements()) {
//			log.error("========={}==========", names.nextElement());
//		}
		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
		log.error("==========================={}",obj);
		SecurityContextImpl contextImpl = (SecurityContextImpl) obj;
		Authentication authentication = contextImpl.getAuthentication();
		
		
		log.error("========USERNAME{}",authentication.getName());
		log.error("========DETAIL{}",authentication.getDetails());
		log.error("========MEMBERVO{}",authentication.getPrincipal());

		
	}
	
	
	@GetMapping("admin")
	public void getAdmin()throws Exception{
		
	}
	
	@GetMapping("mypage")
	public void getMypage()throws Exception{
		
	}
	
	
	
	@GetMapping("login")
	public ModelAndView getLogin(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
	
		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		if( obj ==null) {
			mv.setViewName("member/login");
		}else {
			mv.setViewName("redirect:/");
		}
		
		return mv;
		
	}
	
//	@PostMapping("login")
//	public ModelAndView getLogin(MemberVO memberVO, HttpSession session) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		memberVO = memberService.getLogin(memberVO);
//		
//		mv.setViewName("redirect:./login");
//		
//		if(memberVO!=null) {
//			session.setAttribute("member", memberVO);
//			mv.setViewName("redirect:../");
//		}
//		
//		return mv;
//	}
//	
	
	@GetMapping("logout")
	public ModelAndView getLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
						
		int result = memberService.setLastTime(memberVO);
		
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
	public ModelAndView setJoin(MemberVO memberVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/join");
		
		return mv;
	}
	
	
	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, BindingResult bindingResult)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.memberCheck(memberVO, bindingResult);
		
		if(check) {
			mv.setViewName("member/join");
			
			return mv;
		}
		
		int result = memberService.setJoin(memberVO);
		
//		mv.addObject("member", result);
		mv.setViewName("redirect:../");
		return mv;
		
	}
	

	
}
