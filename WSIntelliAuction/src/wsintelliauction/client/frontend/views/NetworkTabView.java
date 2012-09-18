package wsintelliauction.client.frontend.views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import wsintelliauction.client.frontend.models.NetworkTabModel;
import wsintelliauction.gui.View;

public class NetworkTabView extends View<NetworkTabModel> {

	public NetworkTabView(NetworkTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	private JTable serversTable;
	private JButton btnRegisterNewServer;
	private DefaultTableModel registeredServersTableModel;

	@Override
	public String toString() {
		return "Network";
	}

	public JButton getBtnRegisterNewServer() {
		return btnRegisterNewServer;
	}

	public void updateServerListTable() {
		// registeredServersTableModel.add
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	protected void initialize() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"Network Connection Management", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JPanel registeredServersPanel = new JPanel();
		registeredServersPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0)), "Registered Servers",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(registeredServersPanel, "flowy,cell 0 0,grow");
		registeredServersPanel.setLayout(new MigLayout("", "[grow][]",
				"[grow][]"));

		JScrollPane scrollPane = new JScrollPane();
		registeredServersPanel.add(scrollPane, "cell 0 0 2 1,grow");

		serversTable = new JTable();

		// construct table to display registered servers
		registeredServersTableModel = new DefaultTableModel(new String[] {
				"Server ID", "Host name", "Host Address", "IP Address",
				"Connected" }, 1) {
			Class[] columnTypes = new Class[] { Object.class, Object.class,
					Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		serversTable.setModel(registeredServersTableModel);

		serversTable.getColumnModel().getColumn(0).setPreferredWidth(133);
		serversTable.getColumnModel().getColumn(1).setPreferredWidth(142);
		serversTable.getColumnModel().getColumn(2).setPreferredWidth(148);
		serversTable.getColumnModel().getColumn(3).setPreferredWidth(117);
		scrollPane.setViewportView(serversTable);

		btnRegisterNewServer = new JButton("Register New Server");

		registeredServersPanel.add(btnRegisterNewServer, "flowx,cell 0 1");

		JButton btnRemoveServer = new JButton("Remove Server");
		registeredServersPanel.add(btnRemoveServer, "cell 0 1");

		JButton btnConnectTo = new JButton("Connect To");
		registeredServersPanel.add(btnConnectTo, "flowx,cell 1 1,alignx right");

		JButton btnNewButton = new JButton("Disconnect From");
		registeredServersPanel.add(btnNewButton, "cell 1 1,alignx right");

		JButton btnPing = new JButton("Ping");
		registeredServersPanel.add(btnPing, "cell 1 1");

		JPanel connectionInfoPanel = new JPanel();
		connectionInfoPanel.setBorder(new TitledBorder(null,
				"Connection Information", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(connectionInfoPanel, "cell 0 1,grow");
		connectionInfoPanel.setLayout(new MigLayout("", "[80px][grow]",
				"[16px]"));

		JLabel lblServerStatus = new JLabel("Server status:");
		connectionInfoPanel.add(lblServerStatus,
				"cell 0 0,alignx left,aligny top");

		JLabel lblRunning = new JLabel("RUNNING");
		connectionInfoPanel.add(lblRunning, "cell 1 0,alignx center");
	}

}
