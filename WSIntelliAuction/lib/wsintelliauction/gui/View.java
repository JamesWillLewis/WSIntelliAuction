package wsintelliauction.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import wsintelliauction.misc.ErrorLogger;

/**
 * A view initialises and organises the actual visible components of a window.
 * The view inherits from JFrame, and uses SWING windowing.
 * A view maintains a reference to a model, which it uses to set the values/states
 * of it's components.
 * Each view must provide methods for assigning listeners/observers to it's components,
 * which a controller will use to observe user input.
 * 
 * @author James Lewis
 * 
 */
public abstract class View<M extends Model> extends JFrame {

	protected M model;
	
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
	public View(M model) {
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//initialize frame components
		initialize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.width *= 0.8;
		screenSize.height *= 0.8;
		setPreferredSize(screenSize);
		pack();
		setLocationByPlatform(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * Contains all code for initialisation, configuration and positioning of view components.
	 */
	protected abstract void initialize();

	/**
	 * Launch this view in a new thread.
	 */
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				setVisible(true);
			}
		});
	}

	/**
	 * Set frame visibility to false.
	 */
	public void close() {
		setVisible(false);
	}

}
