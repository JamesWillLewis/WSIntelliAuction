package wsintelliauction.server.frontend.views;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class LeasesTabView extends JPanel {
	private JTable table;

	public LeasesTabView() {
		init();
	}
	
	private void init(){
		setBorder(new TitledBorder(null, "Lease Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblFilter = new JLabel("Filter:");
		add(lblFilter, "flowx,cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Lease #", "Channel #", "Secondary User", "Frequency Band", "Power Limitation", "Lease Period", "State"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(139);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(121);
		table.getColumnModel().getColumn(5).setPreferredWidth(125);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Pending", "Held", "Suspended", "Cancelled", "Expired"}));
		add(comboBox, "cell 0 0");
		
		JButton btnSuspendLease = new JButton("Suspend");
		add(btnSuspendLease, "flowx,cell 0 2");
		
		JButton btnCancelLease = new JButton("Terminate");
		add(btnCancelLease, "cell 0 2");
		
		JButton btnReallocate = new JButton("Reallocate");
		add(btnReallocate, "cell 0 2");
	}
	
	@Override
	public String getName() {
		return "Leases";
	}

}
