package com.iu.base.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	
	
	//로그인
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	//회원가입 (조인) 
	public int setJoin(MemberVO memberVO, RoleVO roleVO) throws Exception;
	
	//회원권한 넣기
	public int setRole(RoleVO roleVO)throws Exception;
	
	//로그아웃
	
	
}
