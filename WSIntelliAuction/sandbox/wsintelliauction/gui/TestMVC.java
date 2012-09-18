package wsintelliauction.gui;

import wsintelliauction.gui.Module;

/**
 * A simple demonstration of exactly how the MVC process works.
 * 
 * @author James
 *
 */
public class TestMVC extends Module<TestModel, TestView, TestController> {

	
	public TestMVC() {
		//create the model, view and controller. (pass all required references)
		model = new TestModel();
		view = new TestView(model);
		controller = new TestController(view, model, null);
	}
	
	
	public static void main(String[] args){
		new TestMVC().launchMVC();
	}
	
}
