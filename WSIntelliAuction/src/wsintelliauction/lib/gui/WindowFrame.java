package wsintelliauction.lib.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import wsintelliauction.lib.misc.ErrorLogger;

/**
 * Contains, manages and lays out all components for a window.
 * 
 * @author James Lewis
 * 
 */
public abstract class WindowFrame {

	/**
	 * Master window Frame.
	 */
	protected JFrame frame;
	/**
	 * Reference to containing window.
	 */
	protected Window<?, ?, ?> windowRef;

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

	/**
	 * Construct a new window frame, and set some default standard properties.
	 * @param windowName Window title.
	 */
	public WindowFrame(final String windowName) {
		frame = new JFrame(windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//initialize frame components
		initialize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.width *= 0.8;
		screenSize.height *= 0.8;
		frame.setPreferredSize(screenSize);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	/**
	 * Contains all code for initialisation, configuration and positioning of frame components.
	 */
	protected abstract void initialize();

	/**
	 * Launch the frame (in a new thread)
	 */
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Set frame visibility to false.
	 */
	public void close() {
		frame.setVisible(false);
	}

	/**
	 * Sets window reference.
	 * 
	 * @param windowRef
	 *            Window reference.
	 */
	public void setWindowRef(Window<?, ?, ?> windowRef) {
		this.windowRef = windowRef;
	}
}
