package wsintelliauction.gui;

/**
 * Manages all underlying data for a particular view and controller.
 * The model has no visibility of the view and controller. The controller and view
 * can be implemented in any way. The model only provides methods for accessing data,
 * setting data, and performing functions on the data. The model must have absolutely
 * no dependence on the controller or view which uses this model.
 * 
 * @author James Lewis
 *
 */
public abstract class Model{
	

	public Model() {
		reset();
	}
	
	/**
	 * Set all fields to default value.
	 */
	public abstract void reset();

}
