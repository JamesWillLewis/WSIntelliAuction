package wsintelliauction.server.frontend.views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import wsintelliauction.gui.View;
import wsintelliauction.server.frontend.models.AuctionTabModel;

public class AuctionTabView extends View<AuctionTabModel> {
	public AuctionTabView(AuctionTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	private JTable table;

	@Override
	protected void initialize() {
		setBorder(new TitledBorder(null, "Auction Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow][]"));

		JLabel lblFilter = new JLabel("Filter:");
		add(lblFilter, "flowx,cell 0 0");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null, null, null, null, null }, }, new String[] { "Bid #",
				"Time placed", "Time outstanding", "Secondary User",
				"Frequency Band Requested", "Power Limit Requested", "Status" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(67);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(3).setPreferredWidth(114);
		table.getColumnModel().getColumn(4).setPreferredWidth(191);
		table.getColumnModel().getColumn(5).setPreferredWidth(140);
		scrollPane.setViewportView(table);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "All",
				"Outstanding", "Satisfied" }));
		add(comboBox, "cell 0 0");

		JPanel auctionControlPanel = new JPanel();
		auctionControlPanel.setBorder(new TitledBorder(null,
				"Auction Settings", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		add(auctionControlPanel, "cell 0 2,grow");
		auctionControlPanel.setLayout(new MigLayout("", "[251.00px]",
				"[25px,bottom]"));

		JCheckBox chckbxNewCheckBox = new JCheckBox("Automatic Broker");
		chckbxNewCheckBox.setSelected(true);
		auctionControlPanel.add(chckbxNewCheckBox,
				"cell 0 0,alignx left,aligny center");

	}
	
	@Override
	public String toString() {
		return "Auction";
	}
}
