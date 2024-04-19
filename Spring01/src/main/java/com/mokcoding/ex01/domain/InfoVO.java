package com.mokcoding.ex01.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



// Lombok 태그들

@Getter // getter 메서드
@Setter // setter 메서드
@ToString // toString 메서드
@NoArgsConstructor // 기본 생성자
public class InfoVO {

	private String name; // parameter name="name"
	private String email; // parameter name="email"
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate; // parameter name="birthDate"
	
}

