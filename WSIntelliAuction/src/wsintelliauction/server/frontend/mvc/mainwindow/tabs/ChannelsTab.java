package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ChannelsTab extends JPanel {
	private JTable table;
	private final ButtonGroup filterButtonGroup = new ButtonGroup();

	public ChannelsTab() {
		init();
	}
	
	private void init(){
		setBorder(new TitledBorder(null, "Channel Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JLabel lblFilter = new JLabel("Filter:");
		add(lblFilter, "flowx,cell 0 0");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Available", "Unavailable", "Leased"}));
		add(comboBox, "cell 0 0,alignx left");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Channel ID", "Frequency Band", "Power Limitation", "Primary User", "Secondary User"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(138);
		table.getColumnModel().getColumn(2).setPreferredWidth(177);
		table.getColumnModel().getColumn(3).setPreferredWidth(137);
		table.getColumnModel().getColumn(4).setPreferredWidth(139);
		scrollPane.setViewportView(table);
	}
	
	@Override
	public String getName() {
		return "Channel";
	}
}
