<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返回上传消息</title>
</head>
<body>
 ${message}
 <P>改进后的上传</P>
 <form action="<%=request.getContextPath() %>/upload/uploads.do" enctype="multipart/form-data" method="post" >
        上传用户：<input type="text" name="username"><br/>
        上传文件1：<input type="file" name="file1"><br/>
        上传文件2：<input type="file" name="file2"><br/>
   <input type="submit" value="提交"  >
</form>
</body>
</html>