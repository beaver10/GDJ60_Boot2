package com.iu.base.member;

import java.util.List;

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
	
	
	public int setJoin (MemberVO memberVO, RoleVO roleVO) throws Exception{
		memberDAO.setRole(roleVO);
		
		int result = memberDAO.setJoin(memberVO,roleVO);
		
		
		
		return result;
	}

}
