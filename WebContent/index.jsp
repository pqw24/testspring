<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="form"  action="<%=request.getContextPath()%>/login/login.do"  method="post"   >
用户名：<input id="username"  name="username" type="text"   />
密    码：<input id="passWord"  name="passWord" type="password"   />
<input type="button"  value="提交" onclick="submits()"   />
</form>
<script type="text/javascript">
function  submits(){
	document.getElementById("form").submit();
}
</script>
</body>
</html>