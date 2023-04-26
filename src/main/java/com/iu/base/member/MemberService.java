package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
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
			bindingResult.rejectValue("userName", "member.userName.notEnable");
		}
		
		return result;
		
	}
	
	
	public MemberVO getLogin (MemberVO memberVO)throws Exception{
//		MemberVO result = memberDAO.getLogin(memberVO);
//		
//		if(result != null && memberVO.getPassword().equals(result.getPassword())) {
//			memberVO.setPassword(null);
//			memberVO.setRoleVOs(result.getRoleVOs());
//			return memberVO;
//		}else {
			return memberDAO.getLogin(memberVO); //result
//		}
		
	}
	
	
	public int setJoin (MemberVO memberVO) throws Exception{
		memberVO.setEnabled(true);
		int result = memberDAO.setJoin(memberVO);
		Map<String, Object>map = new HashMap<>();
		
		map.put("userName", memberVO.getUserName());
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
