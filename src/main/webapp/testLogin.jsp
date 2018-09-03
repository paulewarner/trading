<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="portfolioX" method="POST">
<p> ${message}</p>
<p>UserId: <input type="text" name="userId"></p>
<p>Password: <input type="password" name="password"></p>
<p><input type="submit" value="login"></p>
</form>
<form action="registration">
<p>New User? <input type="submit" value ="click here!"></p>
</form>

</body>
</html>