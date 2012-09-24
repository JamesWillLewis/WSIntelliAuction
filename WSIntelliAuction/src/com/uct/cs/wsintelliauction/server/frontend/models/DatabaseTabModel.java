package com.uct.cs.wsintelliauction.server.frontend.models;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.db.orm.tables.Channel;
import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;

public class DatabaseTabModel extends Model<ServerResourceContainer> {

	private QueryResultTable resultTable;

	public DatabaseTabModel(ServerResourceContainer resourceContainer) {
		super(resourceContainer);
	}

	@Override
	public void reset() {
		resultTable = new QueryResultTable();
	}

	public void submitQuery(String statement) {
		System.out.println(statement);
		ArrayList<Object> resultSet = resourceManager.getDatabaseDriver()
				.query(statement);
		if (resultSet == null) {
			JOptionPane
					.showMessageDialog(
							null,
							"There was an error in your HQL statement. \nView error log for more details",
							"Error", JOptionPane.ERROR_MESSAGE);
		} else if (resultSet.size() > 0) {

			String[] columnNames = {};
			Object[][] dataMatrix = {};

			Object type = resultSet.get(0);

			//	CHANNEL TABLE
			if (type instanceof Channel) {
				columnNames = new String[] { "ID", "ChannelNumber",
						"LowerBound", "UpperBound", "PowerLimitation",
						"PUOwned" };
				dataMatrix = new Object[resultSet.size()][columnNames.length];
				for(int i = 0; i < resultSet.size(); i++){
					Object[] row = dataMatrix[i];
					row[0] = ((Channel)resultSet.get(i)).getId();
					row[1] = ((Channel)resultSet.get(i)).getChannelNumber();
					row[2] = ((Channel)resultSet.get(i)).getLowerBound();
					row[3] = ((Channel)resultSet.get(i)).getUpperBound();
					row[4] = ((Channel)resultSet.get(i)).getPowerLimitation();
					row[5] = ((Channel)resultSet.get(i)).isPUOwned();
				}
			}

			resultTable.setDataVector(dataMatrix, columnNames);

		} else {
			JOptionPane.showMessageDialog(null,
					"Result set is empty", "Result",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public class QueryResultTable extends DefaultTableModel {

		public QueryResultTable() {
			super(new Object[] {}, 0);
		}

	}

	public QueryResultTable getResultTable() {
		return resultTable;
	}

}
