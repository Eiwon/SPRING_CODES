package com.mokcoding.ex02.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mokcoding.ex02.domain.BoardVO;

@Mapper
public interface BoardMapper {

	// 메소드 이름은 BoardMapper.xml의 sql 쿼리 정의 태그 id와 동일
	// 매개변수는 BoardMapper.xml에서 #{변수명}과 동일(클래스 타입은 각 멤버변수명과 매칭)
	
	int insert(BoardVO boardVO); // 게시글 등록
	
	List<BoardVO> selectList(); // 전체 게시글 조회
	
	BoardVO selectOne(int boardId); // 특정 게시글 조회
	
	int update(BoardVO boardVO); // 특정 게시글 수정
	
	int delete(int boardId); // 특정 게시글 삭제
}
