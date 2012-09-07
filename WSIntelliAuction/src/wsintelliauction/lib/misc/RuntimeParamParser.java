package wsintelliauction.lib.misc;

/**
 * 
 * Used for parsing and handling runtime command-line parameters.
 * Optimal use would be to derive a subclass and override, 
 * implementing customized functionality for handling parameters. 
 * 
 * @author James Lewis
 */
public class RuntimeParamParser {

	/**
	 * Raw string arguments (as parsed via command line)
	 */
	private String rawArgs[];
	
	/**
	 * Construct new parser
	 * 
	 * @param rawArgs Arguments as parsed from command line
	 */
	public RuntimeParamParser(String[] rawArgs) {
		this.rawArgs = rawArgs;
	}
	
}
