package wsintelliauction.lib.net.message;

import java.io.Serializable;

/**
 * Super-class for all message types. A message is an object which 
 * is used for communication via a network connection.
 * Various message types exist:
 *	<br/>
 *	<br/>
 *  <h4> Message types:</h4>
 * 	<ul>
 * 		<li> RAW </li>
 *		<li> INFO </li>
 * 		<li> PLACEBID </li>
 *		<li> QUERY </li>
 * 		<li> SOLUTION_OFFER </li>
 * 		<li> SOLUTION_ACCEPT </li>
 * 		<li> LEASE </li>	
 * 		<li> CONFIRM_LEASE </li>	
 * 	</ul>
 * 
 * @author James Lewis
 * @author Matthew Marlin
 * 
 */
public abstract class Message implements Serializable {

	/**
	 *	Serial version ID for object serialisation. 
	 */
	private static final long serialVersionUID = 1963804590196708103L;

	/**
	 *	Enum defining message types used for network communication. 
	 */
	enum MessageTypes {
		INFO, PLACEBID, QUERY, SOLUTION_OFFER, SOLUTION_ACCEPT, LEASE, CONFIRM_LEASE, GENERIC;
	}
	
	/**
	 *	For defining message time (enumeration selection)
	 */
	public MessageTypes messageType;
	
	/**
	 *	Construct this message with generic type.	
	 */
	public Message() {
		messageType = MessageTypes.GENERIC;
	}
	
	

}
