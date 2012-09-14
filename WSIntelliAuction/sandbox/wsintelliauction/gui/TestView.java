package wsintelliauction.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;

public class TestView extends View<TestModel> {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField answerField;
	private JSlider slider1;
	private JSlider slider2;
	private JToggleButton btnAddValues;

	public TestView(TestModel model) {
		super(model);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		slider1 = new JSlider(0, 100, model.getSlider1Value());
		GridBagConstraints gbc_slider1 = new GridBagConstraints();
		gbc_slider1.insets = new Insets(0, 0, 5, 5);
		gbc_slider1.gridx = 0;
		gbc_slider1.gridy = 0;
		contentPane.add(slider1, gbc_slider1);
		
		textField1 = new JTextField(model.getSlider1Value()+"");
		textField1.setEditable(false);
		GridBagConstraints gbc_textField1 = new GridBagConstraints();
		gbc_textField1.insets = new Insets(0, 0, 5, 0);
		gbc_textField1.gridx = 1;
		gbc_textField1.gridy = 0;
		contentPane.add(textField1, gbc_textField1);
		textField1.setColumns(10);
		
		slider2  = new JSlider(0, 100, model.getSlider2Value());
		GridBagConstraints gbc_slider2 = new GridBagConstraints();
		gbc_slider2.insets = new Insets(0, 0, 5, 5);
		gbc_slider2.gridx = 0;
		gbc_slider2.gridy = 1;
		contentPane.add(slider2, gbc_slider2);
		
		textField2 = new JTextField(model.getSlider2Value()+"");
		textField2.setEditable(false);
		GridBagConstraints gbc_textField2 = new GridBagConstraints();
		gbc_textField2.insets = new Insets(0, 0, 5, 0);
		gbc_textField2.gridx = 1;
		gbc_textField2.gridy = 1;
		contentPane.add(textField2, gbc_textField2);
		textField2.setColumns(10);
		
		btnAddValues = new JToggleButton("Add Values");
		btnAddValues.setSelected(model.isMustAdd());
		GridBagConstraints gbc_btnAddValues = new GridBagConstraints();
		gbc_btnAddValues.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddValues.gridx = 0;
		gbc_btnAddValues.gridy = 3;
		contentPane.add(btnAddValues, gbc_btnAddValues);
		
		answerField = new JTextField(model.getAnswerValue()+"");
		answerField.setEditable(false);
		GridBagConstraints gbc_answerField = new GridBagConstraints();
		gbc_answerField.gridx = 1;
		gbc_answerField.gridy = 3;
		contentPane.add(answerField, gbc_answerField);
		answerField.setColumns(10);
	}

	public JSlider getSlider1() {
		return slider1;
	}
	public JSlider getSlider2() {
		return slider2;
	}
	public JTextField getTextField1() {
		return textField1;
	}
	public JTextField getTextField2() {
		return textField2;
	}
	public JToggleButton getBtnAddValues() {
		return btnAddValues;
	}
	public JTextField getAnswerField() {
		return answerField;
	}
}
