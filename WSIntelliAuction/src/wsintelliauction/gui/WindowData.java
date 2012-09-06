package wsintelliauction.gui;

public abstract class WindowData <E extends WindowFrame<?>>{
	
	protected E frameRef;
	
	
	public void attachFrame(E frameRef){
		this.frameRef = frameRef;
	}

	public void updateAll(){}

}
