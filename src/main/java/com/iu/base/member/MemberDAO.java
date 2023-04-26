package com.iu.base.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.javassist.compiler.ast.Member;

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
	
	//모든 멤버 조회  
	public List<MemberVO> getMemberList()throws Exception;
	
	//접속 마지막시간 저장 
	public int setLastTime(MemberVO memberVO)throws Exception;
	
	//접속한지 3일 이상된 사용자 enabled를 0으로 변경 
	public int setEnabledMember()throws Exception;
	
	//오늘 생일인 사람 가져오기 
	public List<MemberVO> getMemberBirth ()throws Exception;
	
}
