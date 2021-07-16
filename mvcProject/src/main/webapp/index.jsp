<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
	<jsp:include page="/main/menubar.jsp"></jsp:include>
</div>

<div id="container">
	<c:if test="${empty display }">
		<jsp:include page="/main/body.jsp"></jsp:include>
	</c:if>	
	<c:if test="${not empty display} ">
		<jsp:include page="${display }"></jsp:include>
	</c:if>
</div>

<div id="footer">
	<jsp:include page="/main/footer.jsp"></jsp:include>
</div>

</body>
</html>