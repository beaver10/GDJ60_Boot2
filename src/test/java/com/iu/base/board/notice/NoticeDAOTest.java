package com.iu.base.board.notice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.base.board.BoardVO;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	void setInsertTest()throws Exception{
		
		for(int i =0; i<100; i++) {
			
			BoardVO boardVO = new NoticeVO();
			
			boardVO.setTitle("테스트 제목"+i);
			boardVO.setWriter("테스트 작성자"+i);
			boardVO.setContents("테스트 내용"+i);
			
			int result = noticeDAO.setInsert(boardVO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
			
		}
		System.out.println("종료 ");
	}
	
	//@Test
	void setUpdateTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		
		boardVO.setNum(1L);
		boardVO.setTitle("TEST3");
		boardVO.setContents("TESTCONTENTS3");
		
		int result = noticeDAO.setUpdate(boardVO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	void setDeleteTest()throws Exception{
		BoardVO boardVO = new BoardVO();
		
		boardVO.setNum(6L);
		
		int result = noticeDAO.setDelete(boardVO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	void getDetailTest()throws Exception{
		BoardVO boardVO = new BoardVO();
		
		boardVO.setNum(4L);
		
		boardVO = noticeDAO.getDetail(boardVO);
		
		assertEquals(1, boardVO);
		
	}
	
	
	
}
