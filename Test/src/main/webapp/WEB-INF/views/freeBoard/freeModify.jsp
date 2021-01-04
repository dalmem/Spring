<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form name="freeUpdate" method="post">
                            <div>
                                <label>DATE</label>
                                <p>${list.regdate}</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' value="${list.bno }" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='writer' value="${list.writer }">
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${list.title }">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content'>${list.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-dark" id="ListBtn">목록</button>    
                            <button type="button" class="btn btn-primary" id="updateBtn">변경</button>
                            <button type="button" class="btn btn-info" id="deleteBtn">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
  		<script>
  			var listBtn = document.getElementById("ListBtn");
  			listBtn.onclick=function(){
  				location.href='freeList';
  				
  			}
  			var updateBtn = document.getElementById("updateBtn");
			updateBtn.onclick=function(){
  				/*
  					1. null을 허용하지 않는 태그의 공백값을 확인하고,공백이 없으면 freeUpdate요청으로 데이터를 전송.
  					2. int update() 메서드를 이용해서 글정보를 수정.
  					3. 컨트롤러에서는 업데이트 성공시 " 
  				*/
  				
  				if(document.freeUpdate.writer.value===''){
  					alter("공백불가");  						
  					document.freeUpdate.writer.focus();
  					return;
  				}else if(document.freeUpdate.title.value===''){
  					alter("공백불가");  						
  					document.freeUpdate.title.focus();
  					return;
  				}else{
  					document.freeUpdate.action="freeUpdate";
  					document.freeUpdate.submit();
  					
  				}
  				
  			}
			var deleteBtn = document.getElementById("deleteBtn");
			deleteBtn.onclick=function(){
  				
				document.freeUpdate.action="freeDelete";
				document.freeUpdate.submit(); 
  			}
  		</script>
  	