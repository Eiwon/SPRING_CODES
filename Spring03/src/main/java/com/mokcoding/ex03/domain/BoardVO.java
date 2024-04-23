package com.mokcoding.ex03.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardVO {
	private int boardId;
	private String boardTitle;
	private String boardCOntent;
	private String memberId;
	private Date boardDateCreated; 
}
