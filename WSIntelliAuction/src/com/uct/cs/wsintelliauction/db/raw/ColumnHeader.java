package com.uct.cs.wsintelliauction.db.raw;

public class ColumnHeader 
{
	private String title;
	private String type;
	
	public ColumnHeader(String title, String type)
	{
		this.title = title;
		this.type = type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getType()
	{
		return type;
	}
	public String getTitle()
	{
		return title;
	}
	public String toString()
	{
		return title+" ("+type+")";
	}

}
