package wsintelliauction.db;

import java.util.ArrayList;

import com.uct.cs.wsintelliauction.database.persistent.ObjectDatabaseDriver;


public class TestHibernate {

	public static void main(String[] args) {
		ObjectDatabaseDriver manager = new ObjectDatabaseDriver();


		manager.close();
	}
}
