package com.ikigai.user_app.dao.Impl;

import com.ikigai.user_app.dao.IConnectionDao;
import com.ikigai.user_app.dao.ILoginDao;
import com.ikigai.user_app.dao.Impl.ConnectionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ikigai.user_app.bean.LoginBean;
import com.ikigai.user_app.constants.ConnectionConstants;
import com.ikigai.user_app.constants.LoginConstants;

public class LoginDaoImpl implements ILoginDao {
	
	/**
	 * <P>
	 * This method first creates a connection with the database.
	 * 
	 * Next it creates a preparedStatement by calling the createPreparedStatement() method of the ConnectionDao class
	 * and setting the values from the LoginBean into the query(LoginConstants) with the '?' placeholders.
	 * 
	 * Finally it calls the executeQuery1() method of the ConnectionDao class by passing in the preparedStatement
	 * as parameter. This method returns an object of ResultSet which is finally returned by the 
	 * getLoginInfo() method.
	 * </P>
	 * @param LoginBean
	 * @return ResultSet
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ResultSet getLoginInfo(LoginBean loginBean) throws SQLException, ClassNotFoundException {
		System.out.println("LoginDaoImpl getLoginInfo START");
		
		IConnectionDao connectionDao = new ConnectionDao(ConnectionConstants.URL, ConnectionConstants.USERNAME, ConnectionConstants.PASSWORD);
		//LoginBean loginBean = new LoginBean();
		
		PreparedStatement preparedStatement = connectionDao.createPreparedStatement(LoginConstants.LOGIN_QUERY);
		
		System.out.println("Is prepared statememt null"+ preparedStatement == null);

		System.out.println("******* is preparedStatement null: " + loginBean == null); 
		
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
