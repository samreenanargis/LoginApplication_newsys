package com.ikigai.user_app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ikigai.user_app.bean.LoginBean;

public interface ILoginDao {
	
	public ResultSet getLoginInfo(LoginBean loginBean) throws SQLException, ClassNotFoundException;

}
