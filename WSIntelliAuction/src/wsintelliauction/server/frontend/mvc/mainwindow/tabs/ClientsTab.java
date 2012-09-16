package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class ClientsTab extends JPanel {
	private JTable table;

	public ClientsTab() {
		init();
	}

	private void init() {
		setBorder(new TitledBorder(null, "Client Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JLabel lblFilter = new JLabel("Filter:");
		add(lblFilter, "flowx,cell 0 0");
		
		JComboBox filterComboBox = new JComboBox();
		filterComboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Active", "Connected", "Has outstanding bid(s)", "Holds lease(s)"}));
		add(filterComboBox, "cell 0 0,alignx left");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Secondary User ID", "Bids Placed", "Leases Held", "Status", "Hostname"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(171);
		table.getColumnModel().getColumn(1).setPreferredWidth(122);
		table.getColumnModel().getColumn(2).setPreferredWidth(121);
		table.getColumnModel().getColumn(3).setPreferredWidth(121);
		table.getColumnModel().getColumn(4).setPreferredWidth(118);
		scrollPane.setViewportView(table);
	}

	@Override
	public String getName() {
		return "Client";
	}
}
