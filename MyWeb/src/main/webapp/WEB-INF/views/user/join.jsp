<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container-fluid text-center">    
    
    <div class="semi-back">
      <div class="joinArea">
          <form action="#" class="joinForm" method="GET">
            <h4 class="box">회원가입</h4>
            <label for="id" class="joinLabel ">ID(*)</label><br>
            <input type="text" class="joinId" name="id" id="id">
            <button class="checkBtn btn-primary" id="checkBtn">중복체크</button>
            <p class="msgId" id="msgId"></p>               
            <br>
            <label for="password" class="joinLabel pwlabel">PASSWORD(*)</label><br>
            <input type="password" class="password" id="password" name="password">
            <p class="msgPw" id="msgPw"></p>  
            <br>
            <label for="pwCheck" class="joinLabel">PASSWORD 확인(*)</label><br>
            <input type="password" class="pwCheck" id="pwCheck" name="pwCheck" >
            <p id="msgPw-c"></p>
            <br>
            
            <label for="gender" class="joinLabel">성별</label>
            <select name="gender" id="gender" class="gender">
              <option value="man">남자</option>
              <option value="woman">여자</option>
            </select> 
            <label for="gender" class="joinLabel"> 나이</label>
            <select name="age" id="age" class="age">
              <script>
              for(i=7; i<100;i++){
              document.write("<option value='"+i+" '>"+i+"</option>")
              
              }
            </script>
            
            </select>
            <br>
            <label for="email" class="joinLabel">EMAIL</label><br>
            <input type="text" class="email1" name="email1"> @ <select id="email2" class="email2" onchange="email(this)">
              <option class="option" value="choice">선택</option>
              <option class="option" value="gmail.com">gmail.com</option>
              <option class="option" value="naver.com" >naver.com</option>
              <option class="option" value="hanmail.net" >hanmail.net</option>
              <option class="option" value="etc">직접입력</option>
            </select>
              <label for="joinLabel addr-num">주소</label>
              <input type="text" class="postNum" id="addrZipNum" placeholder="우편번호" readonly>
              <button type="button" class="btn btn-primary addrBtn" onclick="goPopup()">주소찾기</button>
            <div class="form-group">
              <input type="text" class="form-control" id="addrBasic" placeholder="기본주소">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="addrDetail" placeholder="상세주소">
            </div>
            <br>
            <div class="actorSection">
              <label for="likeActor" class="joinLabel pwlabel">관심있는 배우</label><br>
            </div>
            <button type="button" class="add btn-primary" onclick="addActor()">+</button>
            <button type="button" class="minus btn-primary" onclick="minusActor()">-</button>
            <br>
            <br>
            <div class="diretorSection">
            <label for="likeDirector" class="joinLabel pwlabel">관심있는 감독</label><br>
          </div>
            <button type="button" class="add btn-primary" onclick="addDirector()">+</button>
            <button type="button" class="minus btn-primary" onclick="minusDirector()">-</button>
            <div class="genre">
              <label class="joinLabel">선호하는 장르</label><br>
              <label class="joinLabel checkboxLabel"><input type="checkbox" class="checkbox-genre" value="romence"> 로맨스</label>
              <label class="joinLabel checkboxLabel"><input type="checkbox" class="checkbox-genre" value="animation"> 애니메이션</label>
              <label class="joinLabel checkboxLabel"><input type="checkbox" class="checkbox-genre" value="SF"> SF</label>
              <label class="joinLabel checkboxLabel"><input type="checkbox" class="checkbox-genre" value="comedy"> 코미디</label>
              <label class="joinLabel checkboxLabel"><input type="checkbox" class="checkbox-genre" value="horror"> 공포</label>
              <label class="joinLabel checkboxLabel"><input type="checkbox" class="checkbox-genre" value="thiler"> 스릴러</label>
              <label class="joinLabel checkboxLabel"><input type="checkbox" class="checkbox-genre" value="documentry"> 다큐멘터리</label>
            
            </div>
            <br>
                    
            <button type="submit" class="btn joinbtn " style="padding: 15px;">가입</button>
            <button type="button" class="btn btn-default" style="padding: 15px;" onclick="location=''">취소</button>
          </form>
        </div>
      </div>
      
      
    
  
</div>

<script>
  // 직접입력 선택시 input으로 바꿈
  function email(selected){
    var index = selected.selectedIndex;
    if(index ==4){
      $(".email2").replaceWith(function() {
        return $('<input>',{type:'text', class:'email2'})
      })
    }
  }

//아이디 옵션
var id = document.getElementById("id");
id.onkeyup=function(){

  var regex = /^[A-Za-z0-9+]{4,12}$/; 
            if(regex.test(document.getElementById("id").value )) {
                document.getElementById("id").style.borderColor = "green";
                document.getElementById("msgId").innerHTML = "아이디중복체크는 필수 입니다";

            } else {
                document.getElementById("id").style.borderColor = "red";
                document.getElementById("msgId").innerHTML = "";
            }
  
}
//패스워드 옵션
var pw = document.getElementById("password");
        pw.onkeyup = function(){
            var regex = /^[A-Za-z0-9+]{8,16}$/;
             if(regex.test(document.getElementById("password").value )) {
                document.getElementById("password").style.borderColor = "green";
                document.getElementById("msgPw").innerHTML = "사용가능합니다";
            } else {
                document.getElementById("password").style.borderColor = "red";
                document.getElementById("msgPw").innerHTML = "";
            }
        }
        //패스워드 체크
        var pwConfirm = document.getElementById("pwCheck");
        pwConfirm.onkeyup = function() {
            var regex = /^[A-Za-z0-9+]{8,16}$/;
            if(document.getElementById("pwCheck").value == document.getElementById("password").value ) {
                document.getElementById("pwCheck").style.borderColor = "green";
                document.getElementById("msgPw-c").innerHTML = "비밀번호가 일치합니다";
            } else {
                document.getElementById("pwCheck").style.borderColor = "red";
                document.getElementById("msgPw-c").innerHTML = "비밀번호 확인란을 확인하세요";
            }
        }           

//중복체크
$("#checkBtn").click(function(){
  if($("#id").val() === ""){
    alert("아이디를 입력하세요")
  }else if($("#id").val().length <6){
    alert("아이디는 6글자 이상입니다")
  }

})
  
//선호 감독, 배우 +,- 버튼
  function addDirector(){
  var input = document.createElement("input")
  var add = document.querySelector(".diretorSection").appendChild(input)
  input.setAttribute('class','likeDirector')
  }
  function addActor(){
  var input = document.createElement("input")
  var add = document.querySelector(".actorSection").appendChild(input)
  input.setAttribute('class','likeActor')
  }
  function minusActor() {
    var inp = document.querySelector(".actorSection");
    inp.removeChild(inp.children[2])
  }
  function minusDirector() {
    var inp = document.querySelector(".diretorSection");
    inp.removeChild(inp.children[2])
  }

//주소찾기
  function goPopup(){
    		var pop = window.open("jsp/jusoPopup.html","pop","width=570,height=420, scrollbars=yes, resizable=yes");
    		
    	}
    	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
    		document.getElementById("addrBasic").value = roadAddrPart1;
    		document.getElementById("addrDetail").value = addrDetail;
    		document.getElementById("addrZipNum").value = zipNo;
    	}

</script>
</body>
</html>