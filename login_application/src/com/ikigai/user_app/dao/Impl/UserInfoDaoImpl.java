package com.ikigai.user_app.dao.Impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ikigai.user_app.bean.UserInfoBean;
import com.ikigai.user_app.constants.ConnectionConstants;
import com.ikigai.user_app.constants.UserInfoConstants;
import com.ikigai.user_app.dao.IConnectionDao;
import com.ikigai.user_app.dao.IUserInfoDao;

public class UserInfoDaoImpl implements IUserInfoDao {
	
	/**
	 * <P>
	 * This method first connects to the database. 
	 * 
	 * Then it calls the executeQuery() method that executes a query to select all the required fields from the table.
	 * The method then returns an object of ResultSet.
	 * 
	 * Next the method creates an object of type ArrayList.
	 * Then it calls the .next() method on resultSet and sets the values in the userInfoBean.
	 * It then adds the userInfoBean to the userInfoArrayList.
	 * Finally the method returns the userInfoArrayList.
	 * </P> 
	 * @param 
	 * @return ArrayList
	 * @throws SQLException
	 */
	public ArrayList<UserInfoBean> getUserInfo() throws SQLException {
		IConnectionDao connectionDao = new ConnectionDao(ConnectionConstants.URL, ConnectionConstants.USERNAME, ConnectionConstants.PASSWORD);
		
		ResultSet resultSet = connectionDao.executeQuery(UserInfoConstants.USERINFO_QUERY);
		
		ArrayList<UserInfoBean> userInfoArrayList = new ArrayList<UserInfoBean>();
		while(resultSet.next()) {
			UserInfoBean userInfoBean = new UserInfoBean();
			userInfoBean.setFirstName(resultSet.getString("student_firstName"));
			userInfoBean.setLastName(resultSet.getString("student_lastName"));
			userInfoBean.setDOB(resultSet.getString("student_DOB"));
			userInfoBean.setSex(resultSet.getString("student_sex"));
			userInfoArrayList.add(userInfoBean);
		}
		
		return userInfoArrayList;
	}

}
