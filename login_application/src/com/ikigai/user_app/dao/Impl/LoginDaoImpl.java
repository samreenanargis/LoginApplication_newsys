package com.ikigai.user_app.dao.Impl;

import com.ikigai.user_app.dao.Impl.ConnectionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ikigai.user_app.bean.LoginBean;
import com.ikigai.user_app.constants.LoginConstants;

public class LoginDaoImpl {
	
	
	
	public ResultSet getLoginInfo(LoginBean loginBean) throws SQLException, ClassNotFoundException {
		System.out.println("LoginDaoImpl getLoginInfo START");
		
		ConnectionDao connectionDao = new ConnectionDao("jdbc:mysql://localhost:3306/student_info?useSSl=false", "root", "sammu");
		//LoginBean loginBean = new LoginBean();
		
		PreparedStatement preparedStatement = connectionDao.createPreparedStatement(LoginConstants.LOGIN_QUERY);
		
		preparedStatement.setString(1, loginBean.getUsername());
		preparedStatement.setString(2, loginBean.getPassword());
		
		System.out.println("username: " + loginBean.getUsername());
		System.out.println("password: " + loginBean.getPassword());
		System.out.println(preparedStatement.toString());

		
		ResultSet resultSet = connectionDao.executeQuery1(preparedStatement);
		System.out.println("LoginDaoImpl getLoginInfo END");
		
		return resultSet;
	
	}

}
