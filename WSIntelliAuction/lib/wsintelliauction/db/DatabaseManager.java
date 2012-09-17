package wsintelliauction.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;



public class DatabaseManager{
	
	
	/**
	 * Local Variables for our database
	 */
	private Statement Statement = null;
	private Connection Connection = null;
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String JDBCDriverClass = "com.mysql.jdbc.Driver";
	private String DBName = "wsintelliauction";
	private String UserName = "root"; 
	private String Password = "s1lentk1ll";
	
	public DatabaseManager(String DBName, String UserName, String Password)
	{
		this.DBName = DBName;
		this.UserName = UserName;
		this.Password = Password;
		
		startConnection();
		Queue<String[]> Temp = getResultSet("SELECT * FROM employee11");
		
		for(String[] t:Temp){
			System.out.println();
			for(String i:t)
				System.out.print(i+"\t");
		}
		
		stopConnection();
	}
	
	public void startConnection()
	{
		try
		{
			Class.forName(JDBCDriverClass).newInstance();
			Connection = DriverManager.getConnection(URL+DBName,UserName,Password); //Connected to the DB
			System.out.println("Database Connected");
		} 
		catch (Exception e) 
		{
			System.out.println("Error Starting Connection");
		}
		
	}
	
	public void stopConnection()
	{
		try 
		{
			Connection.close();  //Disconnected
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		new DatabaseManager("wsintelliauction","root","s1lentk1ll");
		
	}
	
	public void updateQuery(String Query)
	{
		//Query = "CREATE TABLE Employee11(Emp_code integer, Emp_name varchar(10))";
		
		try 
		{
			Statement = Connection.createStatement();
			Statement.executeUpdate(Query);
		}
		catch (SQLException e) 
		{
			System.out.println("Error Executeing Update Query.");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method returns the entire result set of the query below.
	 * @param Query
	 * @param AmtCols
	 * @return
	 */
	public Queue<String[]> getResultSet(String Query)
	{
		//Create a new queue of String arrays
		Queue<String[]> Queue = new LinkedList<String[]>(); 
		
		int AmtCols = 0;
		
		try
		{	
			
			/*
			 * A Quick routine to get the amount of columns in the table.
			 */
			Statement = Connection.createStatement();
			ResultSet ColCountResult = Statement.executeQuery("SELECT COUNT(*) FROM employee11");
			ColCountResult.next();
			AmtCols = ColCountResult.getInt("COUNT(*)");
			System.out.println(AmtCols);		
			
			//Create a new statement
			Statement = Connection.createStatement();
		    // Create a result set containing all data from the query
		    ResultSet Results = Statement.executeQuery(Query);
		    
		    // Fetch each row from the result set
		    while (Results.next()) 
		    {
		    	String Temp[] = new String[AmtCols];
		        
		    	//Iterate through the columns expected
		    	for(int i = 1 ; i < AmtCols+1 ; i++)
		        	Temp[i-1] = Results.getString(i);
		        
		        //Add it to the queue
		        Queue.add(Temp);
		    							
		        // Get the data from the row using the column name
		        // String col_string = Results.getString("col_string");
		         
		    }
		    
		} 
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("There was an indexing error, maybe you specified too many columns? please check");
		}
		catch (SQLException e)
		{
			System.out.println("Poes");
		}
		
		return Queue;
		
	}
	
}