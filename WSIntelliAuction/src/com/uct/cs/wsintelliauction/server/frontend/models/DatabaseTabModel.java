package com.uct.cs.wsintelliauction.server.frontend.models;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.database.persistent.tables.Channel;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.window.Model;

public class DatabaseTabModel extends Model<ServerResourceContainer> {

	private QueryResultTable resultTable;

	public static final String[] TABLE_LIST = new String[] { "Channel",
			"Lease", "Auction", "PrimaryUser", "SecondaryUser" };

	public DatabaseTabModel(ServerResourceContainer resourceContainer) {
		super(resourceContainer);
	}

	@Override
	public void reset() {
		resultTable = new QueryResultTable();
	}

	public void submitQuery(int selectedTable, String condition) {
		ArrayList<Object> resultSet;
		
		
		resultSet = resourceManager.getDatabaseDriver()
				.query("FROM " + TABLE_LIST[selectedTable]
						+ (condition.equals("") ? "" : " WHERE " + condition));
		
		
		
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

			// CHANNEL TABLE
			if (type instanceof Channel) {
				columnNames = new String[] { "ID", "ChannelNumber",
						"LowerBound", "UpperBound", "PowerLimitation",
						"PUOwned" };
				dataMatrix = new Object[resultSet.size()][columnNames.length];
				for (int i = 0; i < resultSet.size(); i++) {
					Object[] row = dataMatrix[i];
					row[0] = ((Channel) resultSet.get(i)).getId();
					row[1] = ((Channel) resultSet.get(i)).getChannelNumber();
					row[2] = ((Channel) resultSet.get(i)).getLowerBound();
					row[3] = ((Channel) resultSet.get(i)).getUpperBound();
					row[4] = ((Channel) resultSet.get(i)).getPowerLimitation();
					row[5] = ((Channel) resultSet.get(i)).isPUOwned();
				}
			}

			resultTable.setDataVector(dataMatrix, columnNames);

		} else {
			JOptionPane.showMessageDialog(null, "Result set is empty",
					"Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public class QueryResultTable extends DefaultTableModel {

		public QueryResultTable() {
			super(new Object[] {}, 0);
		}
		
		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

	}

	public QueryResultTable getResultTable() {
		return resultTable;
	}

	public String getDatabaseName() {
		return resourceManager.getDatabaseDriver().getDatabaseName();
	}

}
