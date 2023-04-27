package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.iu.base.util.MailManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MailManager mailManager;
	
	
	public int setFindPassword(MemberVO memberVO)throws Exception{
		
		String newPassword = UUID.randomUUID().toString().substring(0, 6);
		
		mailManager.send(memberVO.getEmail(), "임시 비밀번호 입니다.", memberVO.getUsername()+"님의 임시 비밀번호 : "+newPassword);
		
		memberVO.setPassword(passwordEncoder.encode(newPassword));
		
		return memberDAO.setFindPassword(memberVO);
	}

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.error("----------스프링 시큐리티 로그인-----{}");
		log.error("==========={}",username);
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		try {
			memberVO = memberDAO.getLogin(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberVO;
	}


	//password 일치 검증 
	public boolean memberCheck(MemberVO memberVO, BindingResult bindingResult)throws Exception{

		boolean result = false;
		//false : error가 없음. 검증 성공
		//true : error가 있음. 검증 실패
		
		//1. annotation 검증 결과 
		result = bindingResult.hasErrors();
		
		//2. password 일치 검증 
		if(!memberVO.getPassword().equals(memberVO.getPassword2())) {
			result = true;
			bindingResult.rejectValue("password2", "member.password.notEqual");
		}
		
		//3. ID중복 검사
		MemberVO check = memberDAO.idDuplicateCheck(memberVO);
		
		if(check!=null) {
			result=true;
			bindingResult.rejectValue("username", "member.username.notEnable");
		}
		
		return result;
		
	}
	
	
	public MemberVO getLogin (MemberVO memberVO)throws Exception{
		
			return memberDAO.getLogin(memberVO); 
		
	}
	
	
	public int setJoin (MemberVO memberVO) throws Exception{
		//memberVO.setEnabled(true);
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		int result = memberDAO.setJoin(memberVO);
		Map<String, Object>map = new HashMap<>();
		
		map.put("username", memberVO.getUsername());
		map.put("num", 3);
		result = memberDAO.setMemberRole(map);
		
		return result;
	}
	
	
	public MemberVO idDuplicateCheck(MemberVO memberVO)throws Exception{
		
		return memberDAO.idDuplicateCheck(memberVO);
	}
	
	public List<MemberVO> getMemberList()throws Exception{
				
		return memberDAO.getMemberList();
		
	}
	
	public int setLastTime(MemberVO memberVO) throws Exception{
		
		return memberDAO.setLastTime(memberVO);
	}


}
