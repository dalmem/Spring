﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>상세보기</p>
                        </div>
                        
                        <form>
                            <div>
                                <label>DATE</label>
                                <p>${list.regdate }</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' value="${list.bno}" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='#writer' value="${list.writer}" readonly>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${list.title }" readonly>
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content' readonly>${list.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-primary" onclick="location.href='freeModify?bno=${list.bno}'">변경</button>
                            <button type="button" class="btn btn-dark" onclick="location.href='freeList'">목록</button>
                    </form>
                </div>
            </div>
        </div>
        </section>
        
        <section style="margin-top: 80px;">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-9 write-wrap">
                        <form class="reply-wrap">
                            <div class="reply-image">
                                <img src="../resources/img/profile.png">
                            </div>
                            <!--form-control은 부트스트랩의 클래스입니다-->
	                    <div class="reply-content">
	                        <textarea class="form-control" rows="3" id="reply"></textarea>
	                        <div class="reply-group">
	                              <div class="reply-input">
	                              <input type="text" class="form-control" id="replyId" placeholder="이름">
	                              <input type="password" class="form-control" id="replyPw" placeholder="비밀번호">
	                              </div>
	                              
	                              <button type="button" class="right btn btn-info" id="replyRegist">등록하기</button>
	                        </div>
	
	                    </div>
                        </form>

                        <!--여기에접근 반복-->
                        <div id="replyList">
                        <!-- <div class='reply-wrap'>
                            <div class='reply-image'>
                                <img src='../resources/img/profile.png'>
                            </div>
                            <div class='reply-content'>
                                <div class='reply-group'>
                                    <strong class='left'>honggildong</strong> 
                                    <small class='left'>2019/12/10</small>
                                    <a href='#' class='right'><span class='glyphicon glyphicon-pencil'></span>수정</a>
                                    <a href='#' class='right'><span class='glyphicon glyphicon-remove'></span>삭제</a>
                                </div>
                                <p class='clearfix'>여기는 댓글영역</p>
                            </div>
                        </div> -->
                        </div>
                        <button type="button" class="form-control" id="moreList">게시글(더보기)</button>
                    </div>
                </div>
            </div>
        </section>
        
           
        
	<!-- 모달 
		선택자.modal("show") //open
		선택자.modal("hide") //hide
	-->
	<div class="modal fade" id="replyModal" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="btn btn-default pull-right" data-dismiss="modal">닫기</button>
					<h4 class="modal-title">댓글수정</h4>
				</div>
				<div class="modal-body">
					<!-- 수정폼 id값을 확인하세요-->
					<div class="reply-content">
					<textarea class="form-control" rows="4" id="modalReply" placeholder="내용입력"></textarea>
					<div class="reply-group">
						<div class="reply-input">
						    <input type="hidden" id="modalRno">
							<input type="password" class="form-control" placeholder="비밀번호" id="modalPw">
						</div>
						<button class="right btn btn-info" id="modalModBtn">수정하기</button>
						<button class="right btn btn-info" id="modalDelBtn">삭제하기</button>
					</div>
					</div>
					<!-- 수정폼끝 -->
				</div>
			</div>
		</div>
	</div>
	<script>
	$("#replyModal").modal("show");//모달창 보이게
	$("#modalDelBtn").click(function(){
		$("#replyModal").modal("hide");
	})
	
	
	//1. 제이쿼리 라이브러리 확인
	//2. 안전하게 로딩이 끝난 직후 ready함수 안에서 작성
		$(document).ready(function(){
			
			$("#replyRegist").click(add);
			
			//등록함수
			function add(){
				
				var bno = "${list.bno}";//문자열의 형태로 화면에서 넘어온 bno 번호
				var reply = $("#reply").val();//내용
				var replyId = $("#replyId").val();//id
				var replyPw = $("#replyPw").val();//pw
				
				console.log(bno,reply,replyId,replyPw);
				
				if(reply === '' || replyId==='' || replyPw===''){
					alert("누락된 값이 있습니다");
					return;
				}
				$.ajax({
					type : "POST",
					url : "../reply/replyRegist",
					data : JSON.stringify({"bno": bno, "reply":reply ,"replyId" : replyId, "replyPw":replyPw}) ,
					contentType : "application/json; charset=utf-8",
					success : function(data){
						if(data == 1){
							$("#reply").val("");
							$("#replyId").val("");
							$("#replyPw").val("");
							alert("댓글 등록.");
							getList(1,true);
						}else{
							alert("댓글 등록 실패")
						}
					},
					error : function(error){
						alert(error,"등록실패입니다 문의하세요 관리자에게 알간?")
					}
				});
			}//end regist
			$("#moreList").click(function(){
				getList(++pageNum, false);
			})
			
			//댓글목록요청
			var pageNum = 1;
			var strAdd = ""; //화면에 그려넣을 태그를 문자열의 형태로 추가
			getList(1); //상세화면 진입시에 리스트 목록을 가져옵니다.
			function getList(page, reset) {
				
				//select구문에서 필요한 값은? bno
				var bno = "${list.bno}";
				
				// $.ajax() vs $.getJSON 
				// $.ajax() - get, post, put, delete공용적으로 처리하는 제이쿼리기능.
				// $.getJSON(요청주소, 콜백함수) - 단순히 get방식의 데이터만 얻어올 때 사용하는 기능.
				$.getJSON(
					"../reply/getList/"+bno+"/"+page ,
					function(dataList) {
						
						
						var data = dataList.list;
						var total = dataList.total;
						
						if(reset == true){
							pageNum=1;
							strAdd="";
						}
						
						if(pageNum * 20 >= total){
							$("#moreList").css("display","none");
							
						}
						
						if(data.length <= 0) { //댓글이 없는 경우 함수종료 
							return; //함수종료
						}
						
						
						
						for(var i = 0; i < data.length; i++) {
							
	                        strAdd += "<div class='reply-wrap'>";
                            strAdd += "<div class='reply-image'>";
                            strAdd += "<img src='../resources/img/profile.png'>";
                            strAdd += "</div>";
                            
                            strAdd += "<div class='reply-content'>";
                            strAdd += "<div class='reply-group'>";
                            strAdd += "<strong class='left'>"+ data[i].replyId +"</strong>"; 
                            strAdd += "<small class='left'>"+ timeStamp(data[i].replydate) +"</small>";
                            strAdd += "<a href='"+data[i].rno+"' class='right replyModify'><span class='glyphicon glyphicon-pencil'></span>수정</a>";
                            strAdd += "<a href='"+data[i].rno+"' class='right replyDelete'><span class='glyphicon glyphicon-remove'></span>삭제</a>";
                            strAdd += "</div>";
                            strAdd += "<p class='clearfix'>"+ data[i].reply +"</p>";
                            strAdd += "</div>";
                        	strAdd += "</div>";
						}
						$("#replyList").html(strAdd); //replyList자식으로 추가
					}
				);
				
			} //end getList
			getList();
			//수정상세 모달창
			/*
				에이잭스가 순서를 보장하지 않기 때문에, 실제이벤트 선언이 먼저 실행됩니다
				그렇다면 화면에 댓글관련 창은 아무것도 없는 형태이므로, 일반클릭이벤트는 동작하지 않습니다.
				이때, 이미 존재하는 태그 replyList(부모)에 이벤트를 등록하고 이벤트를 전파시켜서 사용하는 위임방식을 반드시 사용해야 합니다.
			*/
			$("#replyList").on("click","a",function(){
				event.preventDefault();
				//현재 클릭한 a태그 href안에 있는 rno번호를 -> 모달창의 hidden태그로 옮겨보세요

				var rno = $(this).attr("href")
				$("#modalRno").val(rno);
				
				
				if( $(this).hasClass("replyModify") ){//event.target.classList.contains("replyModify")
					$(".modal-title").html("댓글수정");
					$("#modalReply").css("display","inline"); //textarea숨김처리
					$("#modalModBtn").css("display","inline");
					$("#modalDelBtn").css("display","none");
					$("#replyModal").modal("show");
				
				}else{
					$(".modal-title").html("댓글삭제");
					$("#modalReply").css("display","none"); //textarea숨김처리
					$("#modalModBtn").css("display","none");
					$("#modalDelBtn").css("display","inline");
					$("#replyModal").modal("show");					
				}
				//1. 수정버튼 vs 삭제버튼인지 확인
				//제이쿼리 hasClass() 함수를 이용해서 처리
				
				
			});
			$("#modalModBtn").click(function(){
			
			//수정이벤트
			/*
				1. 모달창에 rno, reply, replyPw값을 얻습니다
				2. ajax함수를 이용해서 POST방식으로 reply/update요청. 필요한 값은 JSON형식으로 처리
				3. 서버에서는 요청을 받아서 비밀번호를 확인하고, 비밀번호가 맞다면 업데이트를 진행
				4. 만약 비밀번호가 틀렸다면 0을 반환해서 비밀번호가 틀렸습니다. 경고창을 띄우세요
				5. 업데이트가 성공적으로 진행됬다면 modal창 값을 공백으로 초기화
			*/	
				var rno = $("#modalRno").val();
				var reply = $("#modalReply").val();
				var replyPw = $("#modalPw").val();
				
				console.log(rno,reply,replyPw);
				if(rno ==="" || reply===""||replyPw===""){
					alert("내용, 비번을 입력하세요");
					return;
				}

				$.ajax({
					type : "POST",
					url : "../reply/update",
					data : JSON.stringify({"rno": rno, "reply":reply ,"replyPw":replyPw}) ,
					contentType : "application/json; charset=utf-8",
					success : function(data){
						if(data === 1){//업데이트 성공
							alert("업데이트")
						$("#modalReply").val("");
						$("#modalPw").val("");
						$("#replyModal").modal("hide");
						getList(1, true);
						}else{//업데이트 실패
							alert("없데이트")
						}
					},
					error : function(status,error){}
				});

				
			});
			
			$("#modalDelBtn").click(function(){
				console.log(1);
				/*
					1.모달창에 rno, replyPw값을 얻습니다
					2. ajax함수를 이용해서 POST방식으로 reply/delete요청, 필요한 값은JSON형식으로 처리
					3. 서버에서는 요청을 받아서 비밀번호를 확인하고 비밀번호가 일치하면 삭제를 진행
					4. 비밀번호가 틀렸다면 0을반환해서 경고창을 띄움
				*/
				var rno = $("#modalRno").val();
				var replyPw = $("#modalPw").val();
				if(replyPw===""){
					alert("비밀번호 입력 요망");
					return;
				}
				$.ajax({
					type : "POST",
					url : "../reply/delete",
					data : JSON.stringify({"rno": rno, "replyPw":replyPw}) ,
					contentType : "application/json; charset=utf-8",
					success : function(data){
						console.log(1);
						if(data === 1){
							alert("삭제완료")
							getList(1,true);
						}else{
							alert("비밀번호 확인")
						}
					},
					error: function(status, error){}
				})
			})
			
			//javascript에서 날짜 포맷팅
			
			function timeStamp(millis) {
				// 1시간 기준으로 방금전 or xx시간 or 1일 기준으로 날짜출력
				var now = new Date();
				var gap = now.getTime()-millis;
				
				console.log(now);
				console.log(gap);
				var time; //리턴할 문자열
				if(gap<1000*60*60*20){
					//1일 미만인 경우
					if(gap<1000*60*60){
						//1시간 미만
						time="방금 전";
					}else{
						//1일미만~ 1시간 이상인 경우
						time=parseInt( gap/(1000*60*60) ) + "시간 전";
					}
				}else{
					//1일 이상인 경우
					var date = new Date(millis);
					var year = date.getFullYear();
					var month = date.getMonth() +1;
					var day = date.getDate();
					var hour = date.getHours();
					var minute = date.getMinutes();
					var second = date.getSeconds();
					time = year + "년" +month +"월"+day+"일" +(hour<10? "0"+hour : hour)+"시"+(minute < 10? "0"+minute:minute)+"분"+(second<10? "0"+second:second)+"초";

				}
				
				return time;
			}
			
			
			
			
		});
	</script>
	
	
	
	