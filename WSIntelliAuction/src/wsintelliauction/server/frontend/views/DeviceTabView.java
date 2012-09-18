package wsintelliauction.server.frontend.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import wsintelliauction.gui.View;
import wsintelliauction.server.frontend.models.DeviceTabModel;

public class DeviceTabView extends View<DeviceTabModel> {
	
	public DeviceTabView(DeviceTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	private ButtonGroup buttonGroup;

	@Override
	protected void initialize() {
		buttonGroup = new ButtonGroup();
		
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"Cognitive Device Manager", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		JPanel simulatorPanel = new JPanel();
		tabbedPane.addTab("Simulator", null, simulatorPanel, null);
		simulatorPanel.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JCheckBox chckbxSimulateCognitiveDevice = new JCheckBox(
				"Simulate device");
		buttonGroup.add(chckbxSimulateCognitiveDevice);
		simulatorPanel.add(chckbxSimulateCognitiveDevice, "cell 0 0");

		JPanel simParamPanel = new JPanel();
		simParamPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0,
				0)), "Simulator Parameters", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		simulatorPanel.add(simParamPanel, "cell 0 1,grow");

		JPanel driverPanel = new JPanel();
		tabbedPane.addTab("Driver", null, driverPanel, null);
		driverPanel.setLayout(new MigLayout("", "[grow]", "[][grow]"));

		JCheckBox chckbxConnectDevice = new JCheckBox("Connect device");
		buttonGroup.add(chckbxConnectDevice);
		driverPanel.add(chckbxConnectDevice, "cell 0 0");

		JPanel driverSettingsPanel = new JPanel();
		driverSettingsPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0)), "Driver Configuration",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		driverPanel.add(driverSettingsPanel, "cell 0 1,grow");
		driverSettingsPanel.setLayout(new MigLayout("",
				"[138.00][170.00][grow]", "[]"));

		JLabel lblSelectDevice = new JLabel("Select device:");
		driverSettingsPanel.add(lblSelectDevice, "cell 0 0,alignx left");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "[no devices registered]" }));
		driverSettingsPanel.add(comboBox, "cell 1 0,growx");

		JButton btnRegisterDevices = new JButton("Register Devices");
		driverSettingsPanel.add(btnRegisterDevices, "cell 2 0,alignx right");

	}

	@Override
	public String toString() {
		return "Device";
	}
}
