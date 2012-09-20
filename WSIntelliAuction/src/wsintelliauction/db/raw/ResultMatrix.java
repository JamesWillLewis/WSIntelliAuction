package wsintelliauction.db.raw;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

import wsintelliauction.util.EventLogger;

public class ResultMatrix
{
	private Column columnRefs[] = null;
	private ResultSetMetaData metaData = null;
	private Object[][] Matrix = null;
	private int amtRows, amtCols;
	
	
	/**
	 * Given a result set to a SQL database query this class creates an 
	 * object matrix with the desired table content in it. It also provides some 
	 * access and modifier methods
	 * @param Results
	 */
	public ResultMatrix(ResultSet Results)
	{
		amtRows = amtCols = 0;
		
		try 
		{
			/*
			 * Get the column count
			 */
			metaData = Results.getMetaData();
			amtCols = metaData.getColumnCount();
			

			/*
			 * Create a new column reference array
			 */
			columnRefs = new Column[amtCols];
			
			/*
			 * Create a queue of objects to read from the result set row by row, placing
			 * each row into an array, each array in turn added to the queue.
			 */
			Queue<Object[]> queue = new LinkedList<Object[]>();
			while(Results.next())
			{
				Object[] row = new Object[amtCols];
				
				for(int col = 1 ; col < amtCols+1 ; ++col)
				{
						row[col-1] = Results.getObject(col);
				}
				queue.add(row);
				++amtRows;
			}
			
			/*
			 * Create our new column objects and assign them a size.
			 */
			for(int i = 0 ; i < amtCols ; ++i)
			{
				columnRefs[i] = new Column(amtRows);
			}
			
			/*
			 * Iterate through the queue of object arrays and transpose them into the object matrix.
			 */
			int currentRow = 0;
			while(!queue.isEmpty())
			{
				Object[] row = queue.poll();
				
				for(int i = 0 ; i < amtCols ; ++i)
						columnRefs[i].addAt(currentRow, row[i]);
				++currentRow;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException E)
		{
			EventLogger.log("There was an error, the array index went out of bound.");
		}
		catch (SQLException e) 
		{
			EventLogger.log("There was an error creating the result set. Error Message: "+e.getMessage() + 
							"\n\tError Code: "+e.getErrorCode());
		}
	}
	
	/*//This is removed as we don't really need to know types since we are 
	  //implementing another method to handle that later.
	private ColumnHeader createColumnHeader(String title, int type) 
	{
		switch(type)
		{
			
			case Types.CHAR: case Types.VARCHAR: case Types.LONGNVARCHAR:
				return new ColumnHeader(title, "String");
				
			case Types.DECIMAL: case Types.NUMERIC:
				return new ColumnHeader(title,"BigDecimal");
				
			case Types.TINYINT:
				return new ColumnHeader(title,"Byte");
			
			case Types.INTEGER: case Types.SMALLINT:
				return new ColumnHeader(title,"Integer");
				
			case Types.BIGINT:
				return new ColumnHeader(title,"Long");
				
			case Types.DOUBLE: case Types.FLOAT:
				return new ColumnHeader(title,"Double");
				
			case Types.REAL:
				return new ColumnHeader(title,"Float");
				
			case Types.BOOLEAN: case Types.BIT:
				return new ColumnHeader(title,"Boolean");
			case Types.DATE:
				return new ColumnHeader(title,"Date");
				
			case Types.TIME:
				return new ColumnHeader(title,"Time");
				
			case Types.TIMESTAMP:
				return new ColumnHeader(title,"Timestamp");
				
			case Types.BINARY: case Types.VARBINARY: case Types.LONGVARBINARY:
				return new ColumnHeader(title,"Byte[]");
			
			default: EventLogger.log("Error determining row type of table. This is sourcery");
					 return null;
		}
		
	}
	*/

	/**
	 * Returns an entire column object.
	 * @param Col
	 * @return Column
	 */
	public Column getColumn(int Col)
	{
		return (Column) columnRefs[Col];
	}
	
	/**
	 * Get an object at a specific location
	 * @param Row
	 * @param Col
	 * @return Object Element
	 */
	
	public Object getElement(int Row, int Col)
	{
		return columnRefs[Col].getElementAt(Row);
	}
	
	/**
	 * Returns the matrix object. Creates this object if it doesn't 
	 * exist, otherwise it just returns the object.
	 * @return Matrix
	 */
	public Object[][] getMatrix()
	{
		if(Matrix == null)
			createMatrix();
		return Matrix;
	}
	
	/**
	 * Creates a matrix object that is associated with the SQL query result.
	 */
	private void createMatrix()
	{
		Matrix = new Object[amtRows][amtCols];
		
		for(int row = 0 ; row < amtRows ; ++row)
		{
			for(int col = 0; col < amtCols ; ++col)
			{
				Object Val = columnRefs[col].getElementAt(row);
				Matrix[row][col] = Val;
			}
		}
	}
	
	/*
	 * A Way to display the matrix nicely.
	 */
	public String toString()
	{
		if(Matrix == null)
			createMatrix();
	
		String Temp = "";
		
		for(Object[] O : Matrix)
		{
			for(Object i : O)
				Temp+= i+"\t";
			Temp += "\n";
		}
		return Temp;
	}
}