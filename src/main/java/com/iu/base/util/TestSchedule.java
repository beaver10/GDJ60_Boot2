package com.iu.base.util;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.base.board.BoardDAO;
import com.iu.base.board.BoardVO;
import com.iu.base.board.notice.NoticeController;
import com.iu.base.board.notice.NoticeDAO;
import com.iu.base.board.notice.NoticeVO;
import com.iu.base.member.MemberDAO;
import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSchedule {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private MailManager mailManager;
	

	

	//@Scheduled(cron = "*/10 * * * * *")
//	public void test() throws Exception {
//		log.error("=======반복중 ");
//		List<MemberVO>list = memberDAO.getMemberList();
//		
//		for(MemberVO memberVO : list ) {
//			log.error(memberVO.getUserName());
//		}
//		
//	}
	
	
	//@Scheduled (cron = "*/30 * * * * *")
	public void setEnabledMember() throws Exception{
		
		log.error("진행중 ======");
		
		memberDAO.setEnabledMember();
		
		
	}
	
	//@Scheduled (cron = "*/10 * * * * *")
	public void getMemberBirth() throws Exception{
		List<MemberVO>list =memberDAO.getMemberBirth();
		NoticeVO noticeVO = new NoticeVO();
		
	    if (list.isEmpty()) {
	        // 생일인 회원이 없는 경우
	        return;
	    }
		
		StringBuffer sb = new StringBuffer();
		sb.append("오늘은 ");
		
		for(MemberVO memberVOs : list) {
			sb.append(memberVOs.getName());
			sb.append(", ");
		}
		sb.append("생일입니다!!!");
		
		noticeVO.setTitle("오늘의생일자를 축하해주세요");
		noticeVO.setWriter("관리자");
		noticeVO.setContents(sb.toString());
		
		noticeDAO.setInsert(noticeVO);
		
	}
//	
//	//@Scheduled(cron = " 30 54 * * * * ")
//	public void sendMail()throws Exception{
//		
//		mailManager.sendMail();
//		
//		
//	}
	
	
	
}
