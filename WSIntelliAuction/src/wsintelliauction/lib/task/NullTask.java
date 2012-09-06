package wsintelliauction.lib.task;


/**
 * Task which represents a null task (A task which performs no unit of work).
 * Mostly used as a placeholder for erroneous or non-recognized tasks.
 * 
 * @author James
 *
 */
public class NullTask extends Task {

	public NullTask() {
		super("[NULL TASK]");
	}
	
	@Override
	public boolean perform() {
		//DO NOTHING
		return true;
	}

}
