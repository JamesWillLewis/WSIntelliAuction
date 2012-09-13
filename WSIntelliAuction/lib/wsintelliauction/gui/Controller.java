package wsintelliauction.gui;

import wsintelliauction.task.TaskManager;


/**
 * A controller ties together both a model and a view using the MVC protocol.
 * The controller is responsible for assigning listeners to the view,
 * which allows the view to call functions from the model, and assigning values 
 * to the model and the view. 
 * A controller contains a reference to the paired view (which it uses to assign listeners,
 * as well as set field values in the view), as well as a reference to a paired model,
 * which holds the underlying data and provides functions.
 * 
 * @author James Lewis
 * 
 */
public abstract class Controller<M extends Model, V extends View> {

	protected V view;
	protected M model;
	
	protected TaskManager taskManager;
	
	/**
	 * @param view
	 * @param model
	 * @param taskManager
	 */
	public Controller(V view, M model, TaskManager taskManager) {
		this.view = view;
		this.model = model;
		this.taskManager = taskManager;
	}
	
	

}
