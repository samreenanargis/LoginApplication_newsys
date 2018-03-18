package com.ikigai.user_app.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ikigai.user_app.bean.UserInfoBean;

public interface IUserInfoDao {
	
	public ArrayList<UserInfoBean> getUserInfo() throws SQLException;

}
