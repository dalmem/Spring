package com.team404.common.util;

import lombok.Data;

@Data
public class PageVO {
	private int startPage;//페이지네이션의 시작번호
	private int endPage;//페이지네이션의 끝번호
	private boolean prev;//이전버튼 활성여부
	private boolean next;//다음버튼 활성여부
	
	private int pageNum;//조회 페이저 번호
	private int amount;//데이터개수
	private int total;//전체게시글수
	private Criteria cri;//페이지 기준(번호, 데이터 개수)
	
	//PageVO가 생성될때 cri, total 반드시 전달되야 하기 때문에 한개로 제한
	public PageVO(Criteria cri , int total) {
		//페이지 번호, 데이터개수, 전체글수는 전달되는 값에 따라서 초기화
		this.pageNum = cri.getPageNum();
		this.amount=cri.getAmount();
		this.total=total;
		this.cri =cri;
		//끝페이지 계산
		this.endPage=(int)(Math.ceil(this.pageNum/10.0) ) * 10;
		//사용자가 pageNum 11을 눌렀다 -> 20번, pageNum 13번눌렀다 - 20번
		
		//끝페이지를 이용해서 처음페이지 계산
		this.startPage = endPage - 10 + 1;
		// 진짜 끝번호 계산
		
		int realEnd = (int)Math.ceil(total / (double)this.amount );
		if(this.endPage > realEnd ) {
		this.endPage = realEnd;
		}
		//이전버튼 활성화 여부
		this.prev = this.startPage > 1;
		
		//다음버튼 활성화 여부
		this.next = realEnd > this.endPage;
	}


}
