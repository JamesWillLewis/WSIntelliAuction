package com.uct.cs.wsintelliauction.gui;

import com.uct.cs.wsintelliauction.util.ResourceManager;

public abstract class Module<M extends Model, V extends View<?>, C extends Controller<?, ?>> {

	protected M model;
	protected V view;
	protected C controller;

	protected ResourceManager resourceManager;

	public Module(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
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
