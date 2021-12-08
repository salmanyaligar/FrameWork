package com.vitiger.comcast.generic_utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author salman1
 *
 */
public class Databaseutility {
	static	Driver driver;
	static Connection connection;
	static ResultSet result;
		
		/**
		 * This method will perform the MySql database connection
		 */
		
		public void connectDB()
		{
			try {
				driver=new Driver();
				DriverManager.registerDriver(driver);
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			    }catch (SQLException e) {
			    	e.printStackTrace();
			    }
		}


/**
 * This method will close the mysql database
 * @throws SQLException 
 * @throws Sqlexception
 */
		public void closeDB() throws SQLException
		{
	      connection.close();
		}
		
		
		public ResultSet executeQuery(String query) {
			try {
				result=connection.createStatement().executeQuery(query);
				return result;
			} catch (SQLException e) {
		      e.printStackTrace();
			}
			return result;
		}
		}


