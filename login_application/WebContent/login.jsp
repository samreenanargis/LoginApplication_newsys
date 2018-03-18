<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/login_application/style/style.css" />
</head>
<body>
   
	<div id="container">
	<form name="loginForm" method="post" action="LoginController">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="login" value="Login"></td>
			</tr>
			

		</table>
	</form>

	<form name="RegistrationForm" method="post" action="RegisterUserTrial.jsp">
	
		<table id = "registerButton">
			<tr>
				
				<td> <input type="submit" name="register" value="Register"> </td>
			</tr>
			
		</table>
	</form>
	</div>
</body>
</html>