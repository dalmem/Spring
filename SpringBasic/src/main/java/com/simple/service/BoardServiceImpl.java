package com.simple.service;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;
import com.simple.mapper.BoardMapper;
import com.simple.mapper.ScoreMapper;

@Service("boardService") //component스캔 확인
public class BoardServiceImpl implements BoardService {

	
//	@Autowired
//	@Qualifier("boardDAO")
//	private BoardDAO boardDAO;
//	
//	
//	@Override
//	public void boardRegist(BoardVO vo) {
//		
//		boardDAO.boardRegist(vo);
//	}
//
//	@Override
//	public ArrayList<BoardVO> getList() {
//	
//		return boardDAO.getList();
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		
//		boardDAO.boardDelete(num);
//	}
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void boardRegist(BoardVO vo) {
		boardMapper.boardRegist(vo);
		
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		return boardMapper.getList();
	}

	@Override
	public void boardDelete(int num) {
		
		boardMapper.boardDelete(num);
		
	}

}