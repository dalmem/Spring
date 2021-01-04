package com.team404.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {

	private int bno;
	private int rno;
	private String reply;
	private String replyId;
	private String replyPw;
	private Timestamp replydate;
	private Timestamp updatedate;
}

