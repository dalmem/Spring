<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<!-- 파일업로드 폼태그의 enctype을 multipart/form-data로 반드시 설정 -->
	<form action="upload_ok" method="post" enctype="multipart/form-data">
		파일선택:<input type="file" name="file"><br/>
		<input type="submit" value="확인"> 
	</form>
	<!-- 여러파일 업로드 : multiple옵션 사용 -->
	<form action="upload_ok2" method="post" enctype="multipart/form-data">
		파일선택:<input type="file" name="files" multiple="multiple"><br/>
		<input type="submit" value="확인"> 
	</form>
	<hr>
	<!-- 여러파일 업로드 : 복수태그방법 사용 -->
	<form action="upload_ok3" method="post" enctype="multipart/form-data">
		파일선택:<input type="file" name="file"><br/>
		파일선택:<input type="file" name="file"><br/>
		파일선택:<input type="file" name="file"><br/>
		<input type="submit" value="확인"> 
	</form>
	
	<!-- 가변적인 폼 일 경우 -->
	<form action="upload_ok4" method="post" enctype="multipart/form-data"> 
		<input type="text" name="name">
		파일선택:<input type="file" name="file"><br/>
		<input type="text" name="name">
		파일선택:<input type="file" name="file"><br/>
		<input type="text" name="name">
		파일선택:<input type="file" name="file"><br/>
		<input type="submit" value="확인">
	</form>
	
</body>
</html>