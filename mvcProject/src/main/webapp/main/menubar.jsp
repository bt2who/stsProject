<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul{
	list-style: none;
}
li{
	display: inline-block;
}
</style>
</head>
<body>
메뉴바
<ul>
	<c:if test="${sessionScope.userId != null}">
		<li><a href="#">SignOut</a></li>	
		<li><a href="#">WriteBoard</a></li>
	</c:if>
	
		<li><a href="#">SignUp</a></li>
		<li><a href="#">SignIn</a></li>
		<li><a href="#">BoardList</a></li>
	
	
	
</ul>
</body>
</html>