<%@page import="com.ikigai.user_app.controller.UserInfoController"%>
<%@page import="com.ikigai.user_app.bean.UserInfoBean" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/login_application/style/tableStyle.css" />
</head>
<body>

<% 
UserInfoController userInfoController = new UserInfoController(); 
ArrayList<UserInfoBean> userInfo = userInfoController.getUserInfo();
%>
<TABLE id="users">
            <TR>
                <TH>Name</TH>
                <TH>DOB</TH>
                <TH>Sex</TH>
            </TR>
            
          
            <% for(UserInfoBean user : userInfo) { %>
            <TR>
            		<TD> <% out.println(user.getFirstName() + " " + user.getLastName()); %> </TD>
            		<TD> <% out.println(user.getDOB()); %> </TD>
            		<TD> <% out.println(user.getSex()); %> </TD>
            		
            		<% } %>
            	</TR>	
</TABLE>            

</body>
</html>