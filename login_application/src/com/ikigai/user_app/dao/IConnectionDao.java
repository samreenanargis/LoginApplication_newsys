package com.ikigai.user_app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface IConnectionDao {
	
	public Statement createStatement();
	
	public ResultSet executeQuery(String query) throws SQLException;
	
	public ResultSet executeQuery1(PreparedStatement preparedStatement) throws SQLException, ClassNotFoundException;
	
	public PreparedStatement createPreparedStatement(String query) throws SQLException;
	
	public boolean executeUpdate(PreparedStatement preparedStatement) throws SQLException;
	
	public void closeConnection();
	

}
