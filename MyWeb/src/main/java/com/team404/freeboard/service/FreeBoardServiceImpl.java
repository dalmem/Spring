package com.team404.freeboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.common.util.Criteria;
import com.team404.freeboard.mapper.FreeBoardMapper;

@Service("freeBoardService")//패키지가 읽히는지 확인(컴포넌트스캔 -servlet-context.xml)
public class FreeBoardServiceImpl implements FreeBoardService{

	
	@Autowired
	private FreeBoardMapper freeBoardMapper;
	@Override
	public void regist(FreeBoardVO vo) {
		System.out.println(vo.toString());
		freeBoardMapper.regist(vo);
	}
//	@Override
//	public ArrayList<FreeBoardVO> getList() {
//		ArrayList<FreeBoardVO> list = freeBoardMapper.getList();
//		return list;
//		
//	}
	@Override
	public FreeBoardVO getContent(int bno) {
		
		
		return freeBoardMapper.getContent(bno);
	}
	@Override
	public int update(FreeBoardVO vo) {
		
		return freeBoardMapper.update(vo);
	}
	@Override
	public int delete(int bno) {
		
		return freeBoardMapper.delete(bno);
	}
	@Override
	public ArrayList<FreeBoardVO> getList(Criteria cri) {
		System.out.println("getlist메서드 실행");
		
		return freeBoardMapper.getList(cri);
	}
	@Override
	public int getTotal(Criteria cri) {
		
		return freeBoardMapper.getTotal(cri);
	}
	
	
}
