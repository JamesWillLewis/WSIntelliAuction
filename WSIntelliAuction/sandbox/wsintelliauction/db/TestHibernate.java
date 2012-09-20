package wsintelliauction.db;

import java.util.ArrayList;

import wsintelliauction.db.orm.DatabaseManager;

public class TestHibernate {

	public static void main(String[] args) {
		DatabaseManager manager = new DatabaseManager();


		manager.close();
	}
}
