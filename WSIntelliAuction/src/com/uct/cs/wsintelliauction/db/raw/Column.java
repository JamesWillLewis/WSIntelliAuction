package com.uct.cs.wsintelliauction.db.raw;

/**
 * A simple object to hold an array of object. Some functions 
 * like getColumn(), getSize(), getElementAt(), addAt() exist.
 */
public class Column
{
	private Object[] columnData;
	
	public Column(int columnSize)
	{
		columnData = new Object[columnSize];
	}
	
	public Object[] getColumn()
	{
		return columnData;
	}
	
	public Object getElementAt(int index)
	{ 
		return columnData[index];
	}
	
	public int getSize()
	{
		return columnData.length;
	}
	
	public void addAt(int index, Object data)
	{
		columnData[index] = data;
	}
}
