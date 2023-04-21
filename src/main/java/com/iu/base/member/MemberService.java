package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
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
	
	

}
