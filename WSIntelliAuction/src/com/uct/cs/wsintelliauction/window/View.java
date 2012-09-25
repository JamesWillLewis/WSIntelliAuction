package com.uct.cs.wsintelliauction.window;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.uct.cs.wsintelliauction.utility.AppConfig;
import com.uct.cs.wsintelliauction.utility.ErrorLogger;


/**
 * A view initializes and organizes the actual visible components of a window.
 * The view inherits from JFrame, and uses SWING windowing. A view maintains a
 * reference to a model, which it uses to set the values/states of it's
 * components. Each view must provide methods for assigning listeners/observers
 * to it's components, which a controller will use to observe user input.
 * 
 * The UI look&feel skin which the interfaces uses can be set in the config.properties
 * file, under the property 'skin'. The value of the 'skin' key must be a valid
 * look&feel class path. The following are available(From the JTattoo library):
 * 
 * <h1>Look&Feel class paths.</h1>
 * <ul>
 * <li>com.jtattoo.plaf.acryl.AcrylLookAndFeel</li>
 * <li>com.jtattoo.plaf.aero.AeroLookAndFeel</li>
 * <li>com.jtattoo.plaf.aluminium.AluminiumLookAndFeel</li>
 * <li>com.jtattoo.plaf.bernstein.BernsteinLookAndFeel</li>
 * <li>com.jtattoo.plaf.fast.FastLookAndFeel</li>
 * <li>com.jtattoo.plaf.graphite.GraphiteLookAndFeel</li>
 * <li>com.jtattoo.plaf.hifi.HiFiLookAndFeel</li>
 * <li>com.jtattoo.plaf.luna.LunaLookAndFeel</li>
 * <li>com.jtattoo.plaf.mcwin.McWinLookAndFeel</li>
 * <li>com.jtattoo.plaf.mint.MintLookAndFeel</li>
 * <li>com.jtattoo.plaf.noire.NoireLookAndFeel</li>
 * <li>com.jtattoo.plaf.smart.SmartLookAndFeel</li>
 * <li>com.jtattoo.plaf.texture.TextureLookAndFeel</li>
 * </ul>
 * 
 * @author James Lewis
 * 
 */
public abstract class View<M extends Model<?>> extends JPanel{

	/**
	 * Serial version number.
	 */
	private static final long serialVersionUID = -7002345541190407724L;

	/**
	 * Reference to data model.
	 */
	protected M model;

	/**
	 * Set the look and feel on runtime
	 */
	static {
		try {
			UIManager.setLookAndFeel(AppConfig.getProperty("skin"));
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
		initialize();
	}

	/**
	 * Contains all code for initialisation, configuration and positioning of
	 * view components.
	 */
	protected abstract void initialize();


}
