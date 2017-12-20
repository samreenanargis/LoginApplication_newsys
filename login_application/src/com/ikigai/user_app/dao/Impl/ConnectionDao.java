package com.ikigai.user_app.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ikigai.user_app.constants.ConnectionConstants;

public class ConnectionDao {

	private String url;
	private String username;
	private String password;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	ConnectionConstants connectionConstants = new ConnectionConstants();
	
	public ConnectionDao(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}


	public void createConnection() {

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

	public Statement createStatement() {

		statement = null;
		try {
			if (connection == null) {
				createConnection();
			}

			statement = connection.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return statement;
	}

	public ResultSet executeQuery(String query) {

		ResultSet resultSet = null;

		if (statement == null) {
			createStatement();
		}
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet executeQuery1(PreparedStatement preparedStmtQuery) throws SQLException, ClassNotFoundException {
		
		ResultSet resultSet1 = null;
		if(preparedStmtQuery == null) {
			createStatement();
		}
		resultSet1 = preparedStmtQuery.executeQuery();
		System.out.println("executeQuery1 executed");
		return resultSet1;
	}

	public PreparedStatement createPreparedStatement(String query) {

		PreparedStatement preparedStatement = null;

		if (statement == null) {
			createStatement();
		}
		try {
			preparedStatement = connection.prepareStatement(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("createPrepareStatement executed");
		return preparedStatement;
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


