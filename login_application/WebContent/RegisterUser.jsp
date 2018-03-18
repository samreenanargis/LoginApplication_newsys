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

<form name="registrationForm" method="post" action="RegisterUserController">
	
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" required></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="date" name="dob"></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td><select name="sex">
				<option value="M" placeholder= "Male"> Male </option>
				<option value="F" placeholder= "Female"> Female </option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="register" value="Register"></td>
			</tr>
			

		</table>
	</form>

</body>
</html>