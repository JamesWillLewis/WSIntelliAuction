package wsintelliauction.db;

import java.util.ArrayList;

import com.uct.cs.wsintelliauction.db.orm.DatabaseManager;


public class TestHibernate {

	public static void main(String[] args) {
		DatabaseManager manager = new DatabaseManager();


		manager.close();
	}
}
