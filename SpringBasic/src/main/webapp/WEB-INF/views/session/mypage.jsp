<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>권한이 있어야 접근가능한 마이페이지</h2>
	${sessionScope.user_id }<br/><!-- 세션값 -->
	${sessionScope.user_name}<br/>
	마이페이지===============================
	<a href="Logout">로그아웃</a>
	
</body>
</html>