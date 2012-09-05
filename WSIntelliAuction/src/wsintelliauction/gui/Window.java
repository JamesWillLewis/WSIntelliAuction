package wsintelliauction.gui;

import javax.swing.JFrame;

public abstract class Window extends JFrame  {

	public void launch(){
		pack();
		setVisible(true);
	}
	
}
