package com.ikigai.user_app.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ikigai.user_app.bean.UserInfoBean;
import com.ikigai.user_app.dao.Impl.UserInfoDaoImpl;

public class UserInfoController {
	
	/**
	 * <P>
	 * This method calls the getUserInfo() method from the userInfoDaoImpl class which returns an ArrayList containing
	 * user information. 
	 * This ArrayList is in turn returned by this method. 
	 * </P>
	 * @param  
	 * @return ArrayList
	 * @throws throws SQLException
	 */
	public ArrayList<UserInfoBean> getUserInfo() throws SQLException {
		UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
		ArrayList<UserInfoBean> userInfoArray = userInfoDaoImpl.getUserInfo();
		return userInfoArray;
	}

}
