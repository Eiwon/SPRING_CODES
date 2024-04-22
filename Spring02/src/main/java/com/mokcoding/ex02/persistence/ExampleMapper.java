package com.mokcoding.ex02.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper // Mapper 어노테이션
public interface ExampleMapper {
	// * Mapper : 
	// - MyBatis의 구성요소로, SQL 쿼리, 매개 변수, 결과 데이터 등을
	//   자바 객체에 매핑할 수 있게 도와주는 역할
	// - 인터페이스 + 어노테이션 방식 or 인터페이스 + XML 방식
	// - 간단한 쿼리는 인터페이스 + 어노테이션 방식
	// - 복잡한 쿼리 및 추가 설정 필요시 인터페이스 + XML 방식
	
	@Select("SELECT SYSDATE FROM DUAL") // 쿼리 결과를 메소드에 적용하는 어노테이션
	public String getDate(); // 메소드 리턴 타입은 쿼리 결과 데이터 타입과 매칭
	
	
}
