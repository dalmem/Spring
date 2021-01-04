package com.team404.reply.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;

public interface ReplyMapper {
	public int replyRegist(ReplyVO vo);
	//public ArrayList<ReplyVO> getList(int bno);
	public ArrayList<ReplyVO> getList(@Param("bno") int bno, @Param("cri") Criteria cri);
	public int getTotal(int bno);
	public int update(ReplyVO vo);
	public int delete(ReplyVO vo);
	public int pwCheck(ReplyVO vo);
}
