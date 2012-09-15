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

public class ChannelsTab extends JPanel {
	private JTable table;
	private final ButtonGroup filterButtonGroup = new ButtonGroup();

	public ChannelsTab() {
		init();
	}
	
	private void init(){
		setBorder(new TitledBorder(null, "Channel Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
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
		
		JLabel lblShow = new JLabel("Show:");
		add(lblShow, "flowx,cell 0 1");
		
		JRadioButton rdbtnAll = new JRadioButton("All");
		filterButtonGroup.add(rdbtnAll);
		add(rdbtnAll, "cell 0 1");
		
		JRadioButton rdbtnAvailable = new JRadioButton("Available");
		filterButtonGroup.add(rdbtnAvailable);
		add(rdbtnAvailable, "cell 0 1");
		
		JRadioButton rdbtnUnavailable = new JRadioButton("Unavailable");
		filterButtonGroup.add(rdbtnUnavailable);
		add(rdbtnUnavailable, "cell 0 1");
		
		JRadioButton rdbtnLeased = new JRadioButton("Leased");
		filterButtonGroup.add(rdbtnLeased);
		add(rdbtnLeased, "cell 0 1");
	}
	
	@Override
	public String getName() {
		return "Channel";
	}
}
