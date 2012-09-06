package wsintelliauction.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import wsintelliauction.ErrorLogger;

public abstract class WindowFrame {

	protected JFrame frame;

	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			ErrorLogger.log(e.getMessage());
		} catch (InstantiationException e) {
			ErrorLogger.log(e.getMessage());
		} catch (IllegalAccessException e) {
			ErrorLogger.log(e.getMessage());
		} catch (UnsupportedLookAndFeelException e) {
			ErrorLogger.log(e.getMessage());
		}
	}

	public WindowFrame(String windowName) {
		frame = new JFrame(windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.width *= 0.8;
		screenSize.height *= 0.8;
		frame.setPreferredSize(screenSize);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	protected abstract void initialize();

	public void launch() {
		frame.setVisible(true);
	}

	public void close() {
		frame.setVisible(false);
	}

}
