package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.command.BoardVO;
import com.simple.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class JDBCMybatis {
	
	//1. 세션팩토리 빈 주입 확인
	@Autowired
	private SqlSessionFactoryBean SqlSessionFactory;
	
	//2. TestMapper인터페이스 주입
	@Autowired
	private TestMapper testMapper;
	
	//마이바티스 객체 확인
	@Test
	public void test() {
		System.out.println("세션 팩토리 = "+SqlSessionFactory);
		
	}
	
	@Test
	public void testGetTime() {
		System.out.println(testMapper.getTime());
	}
	//insert구문의 값을 전달할 때는 , 단일값 or VO를 통해서 전달 or Map으로 전달
	//vo를 통한 전달 구문
//	@Test
//	public void insertTest() {
//		for (int i = 1; i <= 10; i++) {
//			
//			BoardVO vo = new BoardVO();
//			vo.setName("홍길동"+i);
//			vo.setTitle("테슷흐"+i);
//			vo.setContent("테슷흐!"+i);
//			testMapper.insert(vo);
//		}
//	}
	
	//Map을 통한 전달 구문
//	@Test
//	public void insertTest() {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("name", "홍길자");
//		map.put("title", "맵을 통한 추가");
//		map.put("content", "this is add from map");
//		testMapper.insert(map);
//	}
	@Test
	public void selectTest() {
		ArrayList<BoardVO> list = testMapper.getList();
		System.out.println("반환결과 :"+list.toString());
	}
	
	//10번 게시글의 단일 조회
	@Test
	public void getListOne() {
		BoardVO vo = testMapper.getListOne(10);
		System.out.println("단일조회결과:"+vo.toString());
	}
	//2개의 파라미터를 전달할 경우
	@Test
	public void getListTwo() {
		ArrayList<BoardVO> list =testMapper.getListTwo("홍길동", "테슷흐");
		System.out.println("두개 파라미터 전달 결과 : "+ list.toString());
	}
	
	//게시글 수정테스트
	//update태그를 이용합니다
	//VO객체를 이용해서 수정내용 (글제목, 글내용)을 입력하고
	//10번 게시글을 수정해보세요
	@Test
	public void update() {
		
		BoardVO vo = new BoardVO();
		vo.setNum(10);
		vo.setTitle("업데이트 된 제목");
		vo.setContent("업데이트 된 내용");
		
		int result = testMapper.update(vo);
		System.out.println("업데이트 여부 : " + result);
	}
	//게시글 삭제 리스트
	//delete태그를 이용합니다
	//3번 게시글을 삭제하는 구문을 작성(삭제 결과여부도 확인)
	@Test
	public void delete() {
		BoardVO vo = new BoardVO();
		vo.setNum(3);
		int result = testMapper.delete(vo);
		System.out.println("삭제 여부 : "+ result);
	}
}
