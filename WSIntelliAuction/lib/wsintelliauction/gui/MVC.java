package wsintelliauction.gui;

public abstract class MVC<M extends Model, V extends View<?>, C extends Controller<?,?>> {

	protected M model;
	protected V view;
	protected C controller;

	public void launchMVC() {
		view.launch();
	}

	public void closeMVC() {
		view.close();
	}

}
