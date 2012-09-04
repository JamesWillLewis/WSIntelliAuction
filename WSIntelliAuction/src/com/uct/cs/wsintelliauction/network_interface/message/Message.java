package com.uct.cs.wsintelliauction.network_interface.message;

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
public abstract class Message {

	/**
	 *	Enum defining message types used for network communication. 
	 */
	enum MessageType {
		RAW, INFO, PLACEBID, QUERY, SOLUTION_OFFER, SOLUTION_ACCEPT, LEASE, CONFIRM_LEASE;
	}
	
	private byte[] rawData;
	
	public byte[] getByteData(){
		return rawData;
	}
	

}
