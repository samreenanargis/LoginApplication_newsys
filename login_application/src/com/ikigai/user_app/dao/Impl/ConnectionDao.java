package com.ikigai.user_app.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ikigai.user_app.constants.ConnectionConstants;
import com.ikigai.user_app.dao.IConnectionDao;

public class ConnectionDao implements IConnectionDao{

	private String url;
	private String username;
	private String password;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	PreparedStatement preparedStatement;
	
	ConnectionConstants connectionConstants = new ConnectionConstants();
	
	public ConnectionDao(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
 

	private void createConnection() {
		if ((url != null) && (username != null)
				&& (password != null)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(url, username,
						password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Connected to database");
		} else {
			System.out.println("The input arguments for database connection are not correct");
		}
	}

	/**
	 * <P>
	 * This method creates a Statement object. The Statement object allows execution of basic SQL queries and 
	 * retrieval of the results through the ResultSet class.
	 * </P>
	 * @return Statement object that is created within this method.
	 */
	public Statement createStatement() {
		statement = null;
		try {
			if (connection == null) {
				createConnection();
			}
			
			/*
			 * The following method is called on the Connection object to create a Statement instance. 
			 */
			statement = connection.createStatement();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	
	/**
	 * <P>
	 * Executes a SELECT query and returns a ResultSet object generated by the query.
	 * </P>
	 * @param  query that is to be executed in the database.
	 * @return ResultSet object
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		ResultSet resultSet = null;
		if (statement == null) {
			createStatement();
		}
		resultSet = statement.executeQuery(query);
	
		return resultSet;
	}
	
	
	/*
	 * <P>
	 * Same as executeQuery()
	 * </P>
	 */
	public ResultSet executeQuery1(PreparedStatement preparedStatement) throws SQLException, ClassNotFoundException {	
		ResultSet resultSet1 = null;
		
		resultSet1 = preparedStatement.executeQuery();
		System.out.println("executeQuery1 executed");
		return resultSet1;
	}
	
	
	/**
	 * <P>
	 * Creates a parameterized statement to be executed with the database.
	 * </P> 
	 * @param query with question mark placeholders and values in place of the placeholders by calling one of the
	 * setter methods from the PreparedStatement class.
	 * @return PreparedStatement Object
	 * @throws SQLException
	 */
	public PreparedStatement createPreparedStatement(String query) throws SQLException {
		preparedStatement = null;
		if(connection == null) {
			createConnection();
		}
		preparedStatement = connection.prepareStatement(query);
		System.out.println("createPrepareStatement executed");
		return preparedStatement;
	}
	
	
	/**
	 * <P>
	 * This method uses the preparedStatement to get values from the registerUserBean and updates those values
	 * in the database.
	 * The method used to update is preparedStatement.executeUpdate. The return value for executeUpdate is int.
	 * (if record is updated it returns 1, else, it returns 0.)
	 * </P>
	 * @param preparedStatement
	 * @return boolean 
	 * @throws SQLException
	 */
	public boolean executeUpdate(PreparedStatement preparedStatement) throws SQLException {
		int updateValue = 0;
		
		if(connection == null) {
			createConnection();
		}
		updateValue = preparedStatement.executeUpdate();
		System.out.println("Record updated");
		return (updateValue > 0);
	}

	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


