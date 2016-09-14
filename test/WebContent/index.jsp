<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%
	String str = (String)request.getAttribute("hellokey");
String path = request.getContextPath();
%>
<body>

<form action="/test/check" method="post">
	<input type="text" name="name" id="name" value="">
	<input type="text" name="pass" id="pass" value="">
	<input type="submit" value="submit">
</form>
</body>
</html>