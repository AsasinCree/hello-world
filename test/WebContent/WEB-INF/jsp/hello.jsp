<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String str = (String)request.getAttribute("hellokey");
%>
<body>
<script type="text/javascript" src="jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
function ajaxCheck(){
	var name = $("#name").val();
	if(name != null){
		$.ajax({
			url:"",
			data:{},
			type:"post",
			success:function(msg){
				if(msg == "error"){
					alert("error");
					$("#name").val("");
				}
			}
		});
	}
}
</script>

<form action="" method="post">
	<input type="text" name="name" id="name" onblur="ajaxCheck()" value="">
	<input type="submit" value="submit">
</form>
</body>
</html>