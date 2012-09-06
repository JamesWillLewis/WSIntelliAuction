package wsintelliauction.lib.gui;

/**
 * 
 * @author James
 * 
 * @param <FT>
 *            WindowFrame type (must be subclass of WindowFrame)
 * @param <DT>
 *            WindowData type (must be subclass of WindowData)
 * @param <HT>
 *            WindowHandle type (must be subclass of WindowHandle)
 */
public abstract class Window<FT extends WindowFrame<HT>, DT extends WindowData<FT>, HT extends WindowHandle<DT>> {

	protected FT frame;
	protected DT data;
	protected HT handle;
	
	public Window(FT frame, DT data, HT handle){
		this.frame = frame;
		this.data = data;
		this.handle = handle;
		frame.attachHandle(handle);
		data.attachFrame(frame);
		handle.attachData(data);
	}

	public FT getFrame() {
		return frame;
	}

	public void setFrame(FT frame) {
		this.frame = frame;
	}

	public DT getData() {
		return data;
	}

	public void setData(DT data) {
		this.data = data;
	}

	public HT getHandle() {
		return handle;
	}

	public void setHandle(HT handle) {
		this.handle = handle;
	}

}
