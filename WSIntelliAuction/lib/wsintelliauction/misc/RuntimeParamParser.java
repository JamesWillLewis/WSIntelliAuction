package wsintelliauction.misc;

import java.util.Hashtable;

/**
 * 
 * Used for parsing and handling runtime command-line parameters. Each option
 * must have a constant string declared for it, with it's option flag, as well
 * as being declared in the {@link initParamList} method.
 * 
 * <hr/>
 * 
 * <h1>Parameters</h1>
 * <ul>
 * <li>-d = debug.</li>
 * <li>-m [value] = mode.</li>
 * <li>-h = help.</li>
 * <li>-v = version.</li>
 * </ul>
 * 
 * @author James Lewis
 */
public class RuntimeParamParser {

	/**
	 * Specifies a single command line parameter, which is set by the arguments
	 * at runtime of the application.
	 * 
	 * @author James Lewis
	 * 
	 */
	public class Parameter {

		/**
		 * Textual identifier of the parameter.
		 */
		public final String id;

		/**
		 * Option flag used by an argument to identify this parameter.
		 */
		public final String option;
		/**
		 * (Optional) value for the option specified by the argument.
		 */
		public String value;
		/**
		 * If this parameter requires a value.
		 */
		public final boolean requiresValue;
		/**
		 * If the runtime arguments specified this option.
		 */
		public boolean flagged;

		/**
		 * Define a new parameter.
		 * 
		 * @param id
		 *            Option identifier.
		 * @param option
		 *            Option flag.
		 * @param value
		 *            Value of option (optional).
		 * @param requiresValue
		 *            If parameter requires value.
		 */
		public Parameter(String id, String option, boolean requiresValue) {
			this.id = id;
			this.option = option;
			this.requiresValue = requiresValue;
			value = "";
			flagged = false;
		}

	}

	/**
	 * Raw string arguments (as parsed via command line)
	 */
	private String rawArgs[];

	/**
	 * Mapping of parameter identifier to the actual parameter.
	 */
	private final Hashtable<String, Parameter> PARAMETERS;

	/**
	 * Debug option flag.
	 */
	public static final String DEBUG_OPTION = "-d";
	/**
	 * Mode option flag.
	 */
	public static final String MODE_OPTION = "-m";
	/**
	 * Help option flag.
	 */
	public static final String HELP_OPTION = "-h";
	/**
	 * Version option flag.
	 */
	public static final String VERSION_OPTION = "-v";

	/**
	 * Construct new parser
	 * 
	 * @param rawArgs
	 *            Arguments as parsed from command line
	 */
	public RuntimeParamParser(String[] rawArgs) {
		this.rawArgs = rawArgs;
		PARAMETERS = new Hashtable<String, Parameter>();
		initParamList();
		parse();
	}

	/**
	 * Declare the parameters for the arguments. <br/>
	 * <b>NOTE:</b> ALL parameters declared here must have a constant flag
	 * declared for it as a field of this class, in the format: <i>public static
	 * final String [option_name]_OPTION = "[option_flag]"; </i>
	 */
	private void initParamList() {
		Parameter debugArg = new Parameter("debug", DEBUG_OPTION, false);
		Parameter modeArg = new Parameter("mode", MODE_OPTION, true);
		Parameter helpArg = new Parameter("help", HELP_OPTION, false);
		Parameter versionArg = new Parameter("version", VERSION_OPTION, false);

		PARAMETERS.put(debugArg.option, debugArg);
		PARAMETERS.put(modeArg.option, modeArg);
		PARAMETERS.put(helpArg.option, helpArg);
		PARAMETERS.put(versionArg.option, versionArg);
	}

	/**
	 * Iterates through the supplied arguments and recognises options, sets the
	 * flags, and assigns values if required. Invalid options are skipped. If an
	 * option is defined twice, the value of the last defined option is
	 * assigned.
	 */
	private void parse() {
		for (int i = 0; i < rawArgs.length; i++) {
			String option = rawArgs[i];
			Parameter p = PARAMETERS.get(option);
			// if the flag is identified
			if (p != null) {
				p.flagged = true;
				// if the argument requires a value
				if (p.requiresValue) {
					// if argument value is out of bounds, or the argument
					// value is a flag
					if (i + 1 == rawArgs.length
							|| PARAMETERS.containsKey(rawArgs[i + 1])) {
						ErrorLogger.log("Missing value for " + p.id
								+ " option.");
						p.flagged = false;
					} else {
						p.value = rawArgs[++i];
					}
				}

			} else {
				ErrorLogger.log("Unrecognised option : " + option);
			}

		}
	}

	public Parameter getParam(String option) {
		Parameter p = PARAMETERS.get(option);
		if (p == null) {
			ErrorLogger.log("Invalid option: " + option);
		}
		return p;
	}
}
