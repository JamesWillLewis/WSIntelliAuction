package wsintelliauction.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import wsintelliauction.misc.Configuration;
import wsintelliauction.misc.ErrorLogger;

/**
 * A view initializes and organizes the actual visible components of a window.
 * The view inherits from JFrame, and uses SWING windowing. A view maintains a
 * reference to a model, which it uses to set the values/states of it's
 * components. Each view must provide methods for assigning listeners/observers
 * to it's components, which a controller will use to observe user input.
 * 
 * <h1>Look & Feel class paths.</h1>
 * <ul>
 * <li> {@link com.jtattoo.plaf.hifi.HiFiLookAndFeel}</li>
 * <li> {@link com.jtattoo.plaf.acryl.AcrylLookAndFeel}</li>
 * <li> {@link com.jtattoo.plaf.aero.AeroLookAndFeel}</li>
 * </ul>
 * 
 * @author James Lewis
 * 
 */
public abstract class View<M extends Model> extends JFrame {

	/**
	 * Serial version number.
	 */
	private static final long serialVersionUID = -7002345541190407724L;

	protected M model;

	static {
		try {

			UIManager.setLookAndFeel(Configuration.getProperty("ui"));
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
	 * 
	 * @param windowName
	 *            Window title.
	 */
	public View(M model) {
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// initialize frame components
		initialize();
		pack();
		setLocationByPlatform(true);
	}

	/**
	 * Contains all code for initialisation, configuration and positioning of
	 * view components.
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
