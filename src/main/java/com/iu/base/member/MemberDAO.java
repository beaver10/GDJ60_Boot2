package com.iu.base.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	
	//가입 아이디 조회 
	public MemberVO idDuplicateCheck(MemberVO memberVO)throws Exception;
	
	//로그인
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	//회원가입 (조인) 
	public int setJoin(MemberVO memberVO) throws Exception;
	
	//회원권한 넣기
	public int setMemberRole(Map<String, Object> map)throws Exception;
	
	
	
}
