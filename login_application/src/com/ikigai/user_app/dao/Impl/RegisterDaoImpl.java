package com.ikigai.user_app.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ikigai.user_app.bean.RegisterUserBean;
import com.ikigai.user_app.constants.ConnectionConstants;
import com.ikigai.user_app.constants.RegisterUserConstants;
import com.ikigai.user_app.dao.IConnectionDao;
import com.ikigai.user_app.dao.IRegisterDao;

public class RegisterDaoImpl implements IRegisterDao{
	
	/**
	 * <P>
	 * This method first connects to the database. 
	 * 
	 * Then it calls the createPreparedStatement() method to create a query with the values entered by the user in 
	 * RegisterUser.jsp page.
	 * 
	 * Next it calls the executeUpdate() method to execute the query generate by the createPreparedStatement() method
	 * and update the record in the database.
	 * The executeUpdate() method returns a boolean value(true is the record has been updated) which is in turn 
	 * returned by this method.
	 * 
	 * </P> 
	 * @param RegisterUserBean
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean registerUser(RegisterUserBean registerUserBean) throws SQLException {
		
		boolean isUserRegistered = false;
		
		IConnectionDao connectionDao = new ConnectionDao(ConnectionConstants.URL, ConnectionConstants.USERNAME, ConnectionConstants.PASSWORD);
		
		PreparedStatement preparedStatement = connectionDao.createPreparedStatement(RegisterUserConstants.REGISTERUSER_QUERY);
		
		preparedStatement.setString(1, registerUserBean.getUsername());
		preparedStatement.setString(2, registerUserBean.getPassword());
		preparedStatement.setString(3, registerUserBean.getFirstName());
		preparedStatement.setString(4, registerUserBean.getLastName());
		preparedStatement.setString(5, registerUserBean.getDob());
		preparedStatement.setString(6, registerUserBean.getSex());
		
		isUserRegistered = connectionDao.executeUpdate(preparedStatement);

		return isUserRegistered;
		
	}

}
