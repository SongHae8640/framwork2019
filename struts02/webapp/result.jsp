<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과 페이지</h1>
	
	<!-- getParameter 아님, getParam은 주소에서 가져오는 것 -->
	<p><%=request.getAttribute("id") %></p>
	<p><%=request.getAttribute("num") %></p>
</body>
</html>