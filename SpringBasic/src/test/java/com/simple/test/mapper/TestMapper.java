package com.simple.test.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.simple.command.BoardVO;

public interface TestMapper {
	
	//인터페이스 이름과 동일한 이름의 구현 xml 파일을 생성
	public String getTime();
//	public int insert(BoardVO vo);
	public int insert(Map<String, String> map);
	
	public ArrayList<BoardVO> getList(); // 조회
	public BoardVO getListOne(int bno); //pk를 통한 단일조회
	public ArrayList<BoardVO> getListTwo(@Param("xxx") String name, 
										@Param("yyy") String title);//2개 값 전달
	public int update(BoardVO vo);
	public int delete(BoardVO vo);
}
