package wsintelliauction.db;


public class DBDriver
{
	//Our Database Manajer Object
	DatabaseManager DBManager; 
	
	public DBDriver()
	{
		/*
		 * The Default Parameters look something like this
		 *
		 * URL = "jdbc:mysql://localhost:3306/";
		 * JDBCDriverClass = "com.mysql.jdbc.Driver";
		 * DBName = "wsintelliauction";
		 * UserName = "root"; 
		 * Password = "s1lentk1ll";
		 * 
		 */
		
		DBManager = new DatabaseManager("jdbc:mysql://localhost:3306/", "root", "s1lentk1ll");
		DBManager.startConnection();
		DBManager.openDatabase("wsintelliauction");
		/*
		 * Here we make a query bunch of test query's and execute them.
		 */
		
		
		//Create a table named fish
		DBManager.updateQuery("CREATE TABLE Employees (No INT(255) NOT NULL AUTO_INCREMENT, Name VARCHAR(25), Gender CHAR(1), PRIMARY KEY (No) )");
		DBManager.updateQuery("INSERT INTO  Employees (Name, Gender)" +
									"VALUES ('Wesley', 'M')," +
										   "('Gerhad', 'M')," +
										   "('Billy','M')," +
										   "('Suzie','F')," +
										   "('Jill','F')," +
										   "('Martin','M');");
		
		//Run a query on a table
		ResultMatrix Matrix = DBManager.query("SELECT * FROM Employees");
		
		/*
		 * We call the DBManager to get the table, it returns the objects, this if for manual
		 */
		Object[][] MatrixObject = Matrix.getMatrix();
		
		/*
		 * Print the table
		 */
		System.out.println(Matrix);
		
		/*
		 * Kill the connection
		 */
		DBManager.stopConnection();
	}
	
	public static void main(String[] args)
	{
		new DBDriver();
	}
}
