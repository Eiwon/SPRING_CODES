package com.mokcoding.ex02.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex02.config.RootConfig;
import com.mokcoding.ex02.config.WebConfig;
import com.mokcoding.ex02.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit test 연결
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class}) // 설정 파일 연결
@Log4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void test() {
		//testBoardInsert();
		//testBoardSelectList();
		//testBoardSelectOne();
		//testBoardUpdate();
		testBoardDelete();
	}

	
	private void testBoardInsert() {
		BoardVO vo = new BoardVO(0, "test title", "test content", "guest", null);
		int result = boardMapper.insert(vo);
		log.info(result + "행 삽입");
	} // end testBoardInsert
	
	private void testBoardSelectList() {
		for(BoardVO vo : boardMapper.selectList()) {
			log.info(vo);
		} 
	} // end testBoardSelectList

	private void testBoardSelectOne() {
		BoardVO vo = boardMapper.selectOne(1);
		log.info(vo);
	} // end testBoardSelectOne
	
	private void testBoardUpdate() {
		int result = boardMapper.update(new BoardVO(3, "test", "test", null, null));
		log.info(result + "행 수정");
	} // end testBoardUpdate

	private void testBoardDelete() {
		int result = boardMapper.delete(3);
		log.info(result + "행 삭제");
	} // testBoardDelete
}
