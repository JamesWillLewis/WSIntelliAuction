package wsintelliauction.lib.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import wsintelliauction.lib.misc.ErrorLogger;

/**
 * Contains, manages and lays out all component for a window.
 * 
 * 
 * @author James Lewis
 *
 * @param <E> {@link WindowHandle} type.
 */
public abstract class WindowFrame <E extends WindowHandle<?>> {

	protected JFrame frame;
	protected E handleRef;

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

	public WindowFrame(final String windowName) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame = new JFrame(windowName);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				initialize();
				Dimension screenSize = Toolkit.getDefaultToolkit()
						.getScreenSize();
				screenSize.width *= 0.8;
				screenSize.height *= 0.8;
				frame.setPreferredSize(screenSize);
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				launch();
			}
		});
	}

	protected abstract void initialize();

	public void launch() {
		frame.setVisible(true);
	}

	public void close() {
		frame.setVisible(false);
	}
	
	public void attachHandle(E handleRef){
		this.handleRef = handleRef;
	}

}
