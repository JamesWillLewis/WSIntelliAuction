package com.uct.cs.wsintelliauction.window;

import com.uct.cs.wsintelliauction.utility.ResourceContainer;

public abstract class Module<M extends Model, V extends View<?>, C extends Controller<?, ?>> {

	protected M model;
	protected V view;
	protected C controller;

	protected ResourceContainer resourceContainer;

	public Module(ResourceContainer resourceContainer) {
		this.resourceContainer = resourceContainer;
	}

	/**
	 * Display the module's view.
	 */
	public abstract void display();

	public M getModel() {
		return model;
	}

	public void setModel(M model) {
		this.model = model;
	}

	public V getView() {
		return view;
	}

	public void setView(V view) {
		this.view = view;
	}

	public C getController() {
		return controller;
	}

	public void setController(C controller) {
		this.controller = controller;
	}
	
	

}
