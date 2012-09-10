package wsintelliauction.lib.gui;

/**
 * 
 * A single instance of a GUI unit (referred to as a Window) - wraps 3 elements
 * together which are required for the efficient handling of an interface:
 * 
 * <br/>
 * <ul>
 * <li> {@link WindowFrame} - Contains the actual interface components.</li>
 * <li> {@link WindowData} - The frame's underlying data model.</li>
 * <li> {@link WindowHandle} - Used by the interface for communication.</li>
 * <ul>
 * 
 * @param <FT>
 *            WindowFrame type (must be subclass of WindowFrame)
 * @param <DT>
 *            WindowData type (must be subclass of WindowData)
 * @param <HT>
 *            WindowHandle type (must be subclass of WindowHandle)
 * 
 * @author James Lewis
 */
public abstract class Window<FT extends WindowFrame, DT extends WindowData, HT extends WindowHandle> {

	/**
	 * WindowFrame for this window.
	 */
	protected FT frame;
	/**
	 * WindowData for this window.
	 */
	protected DT data;
	/**
	 * WindowHandle for this window.
	 */
	protected HT handle;

	/**
	 * Construct a window instance. Passes all necessary references to each
	 * window component.
	 * 
	 * @param frame
	 *            WindowFrame of this window.
	 * @param data
	 *            WindowData for this window.
	 * @param handle
	 *            WindowHandle for this window.
	 */
	public Window(FT frame, DT data, HT handle) {
		this.frame = frame;
		this.data = data;
		this.handle = handle;
		frame.setWindowRef(this);
		data.setWindowRef(this);
		handle.setWindowRef(this);
	}

	/**
	 *	Launches this window.
	 *	Makes the window visible.
	 */
	public void launchWindow() {
		frame.launch();
	}

	/**
	 * Closes this window.
	 * The window will no longer be visible.
	 */
	public void closeWindow() {
		frame.close();
	}

	/**
	 * @return Window's frame reference.
	 */
	public FT getFrame() {
		return frame;
	}


	/**
	 * @return Window's data reference.
	 */
	public DT getData() {
		return data;
	}


	/**
	 * @return Window's handle reference.
	 */
	public HT getHandle() {
		return handle;
	}


}
