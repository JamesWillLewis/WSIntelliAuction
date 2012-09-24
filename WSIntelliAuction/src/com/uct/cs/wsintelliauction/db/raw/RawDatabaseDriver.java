package com.uct.cs.wsintelliauction.db.raw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;


public class RawDatabaseDriver{

	/**
	 * Local Variables for our database
	 */
	private Statement statement = null;
	private Connection connection = null;
	
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String JDBCDriverClass = "com.mysql.jdbc.Driver";
	
	private String DBName, Username, Password;
	/**
	 * Creates a new Database Manager with the following properties.
	 * Note that the DBName is not specified, this is used to connect 
	 * to the server only, when connect() is called
	 * 
	 * @param URL
	 * @param Username
	 * @param Password
	 */
	public RawDatabaseDriver(String URL, String Username, String Password)
	{
		this.DBName = null;
		this.Username = Username;
		this.Password = Password;
	}
	
	/**
	 * Creates a new Database Manager with the following properties.
	 * Note that the DBName is specified, this is used to connect 
	 * to the server and database explicitly, when connect() is called
	 * 
	 * @param URL
	 * @param Username
	 * @param Password
	 * @param DBName
	 */
	public RawDatabaseDriver(String URL, String Username, String Password, String DBName)
	{
		this.DBName = DBName;
		this.Username = Username;
		this.Password = Password;
	}
	
	/**
	 * Opens the desired database.
	 * @param DBName
	 */
	public void openDatabase(String DBName)
	{
		this.DBName = DBName;
		
		openDatabase();
	}
	
	/**
	 * Opens the database, provided the DBName was given as a command line parameter or
	 * or the openDatabase(<DBName>) was called before.
	 */
	public void openDatabase()
	{
		if(DBName == null)
			EventLogger.log("Error, you need to specify a DB first. Use openConnection(<Database Name>)");
		
		try 
		{
			connection = DriverManager.getConnection(URL+DBName,Username,Password);  //Connected to the DB
		}
		catch (SQLException e) 
		{
			EventLogger.log("Could not open the desired database, please check Username, password and access privaliges and try again." +
							"\n\tError: "+e.getMessage()+" Error Code: "+e.getErrorCode());
		}
	}
	
	/**
	 * Create a connection with the Database
	 */
	public void startConnection()
	{
		try
		{
			Class.forName(JDBCDriverClass).newInstance();
			
			//Try loading the JDBC Drivers and connect to the specified DB, if errors Log them.
			if(DBName == null)
			{
				connection = DriverManager.getConnection(URL,Username,Password);
				EventLogger.log("Database Server Connected");
			}
			else
			{
				connection = DriverManager.getConnection(URL+DBName,Username,Password);
				EventLogger.log("Database Server Connected. Connected to DB: "+DBName);
			} 
		}
		catch (SQLException e) 
		{
				EventLogger.log("There was error establishing a connection with the Database: "+DBName+
								"\n\tPlease ensure that the Name and URL are correct and try again.");
		}
		catch(Exception e)
		{
			EventLogger.log("There was error loading the drivers, please ensure that they exist. Error: "+e.getMessage());
		}
	}
		
	/**
	 * Stop a Database Connection
	 */
	public void stopConnection()
	{
		try 
		{
			connection.close();  //Disconnected
		} 
		catch (SQLException e) 
		{
			EventLogger.log("There was an error closing the connection to the DB! Error: "+e.getMessage());
		}
	}
	
	/**
	 * Creates an update Query where no output is returned.
	 * @param query
	 */
	public void updateQuery(String query)
	{
		try 
		{
			statement = connection.createStatement();	//Create a new statement
			statement.executeUpdate(query);				//Execute it.
		}
		catch (SQLException e) 
		{
			EventLogger.log("Error Executeing Update Query: "+e.getMessage()+" \n\tSQL Error Code: "+e.getErrorCode());
		}
	}
	
	/**
	 * This returns a ResultMatrix object which has stored the results in an access object.
	 * @param query
	 * @return ResultMatrix, the matrix holding the resulting query table
	 */
	public ResultMatrix query(String query)
	{
		ResultMatrix resultMatrix = null;  
		
		try
		{	
			//Create a new statement
			statement = connection.createStatement();
		    // Create a result set containing all data from the query
		    ResultSet Results = statement.executeQuery(query);
		    //Create a new result Matrix, with standard iterator access.
		    resultMatrix = new ResultMatrix(Results);
		   
		} 
		catch (SQLException e)
		{
			ErrorLogger.log("There was an error executing the Query. Error: "+e.getMessage()+"\n\tSQL Error: "+e.getErrorCode());
		}
		
		return resultMatrix;
	}
}