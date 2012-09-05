package wsintelliauction.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import wsintelliauction.global.ErrorLogger;

public abstract class WindowFrame {
	
	protected JFrame frame;
	
	public WindowFrame() {
		frame = new JFrame();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			ErrorLogger.submitError(e.getMessage());
		} catch (InstantiationException e) {
			ErrorLogger.submitError(e.getMessage());
		} catch (IllegalAccessException e) {
			ErrorLogger.submitError(e.getMessage());
		} catch (UnsupportedLookAndFeelException e) {
			ErrorLogger.submitError(e.getMessage());
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		initialize();
	}
	
	protected abstract void initialize();

	public void launch(){
		frame.setVisible(true);
	}
	
	public void close(){
		frame.setVisible(false);
	}
	
}
