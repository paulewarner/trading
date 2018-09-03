<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loginX" method="POST" >
<p> ${message}</p>
<p>UserId: <input type="text" name="userId"></p>
<p>UserName: <input type="text" name="username"></p>
<p>Password: <input type="password" name="password"></p>
<p>Authority: <input type="text" name="authority"></p>
<p><input type="submit"></p>
</form>

</body>
</html>