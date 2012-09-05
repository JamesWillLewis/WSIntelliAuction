package wsintelliauction.windowing;

public class Window {

	private WindowFrame frame;
	private WindowData data;
	private WindowHandle handle;
	
	public Window(WindowFrame frame, WindowData data, WindowHandle handle) {
		super();
		this.frame = frame;
		this.data = data;
		this.handle = handle;
	}

	public WindowFrame getFrame() {
		return frame;
	}

	public void setFrame(WindowFrame frame) {
		this.frame = frame;
	}

	public WindowData getData() {
		return data;
	}

	public void setData(WindowData data) {
		this.data = data;
	}

	public WindowHandle getHandle() {
		return handle;
	}

	public void setHandle(WindowHandle handle) {
		this.handle = handle;
	}
	
	
	
}
