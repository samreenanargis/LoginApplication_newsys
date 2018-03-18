package com.ikigai.user_app.service;

import java.sql.SQLException;

import com.ikigai.user_app.bean.LoginBean;

public interface ILoginService {
	
	public boolean isLoginValid(LoginBean loginBean) throws ClassNotFoundException, SQLException;

}
