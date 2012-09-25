package com.uct.cs.wsintelliauction.server.backend.network;

import com.uct.cs.wsintelliauction.network.MessageParser;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;

public class ServerMessageParser extends MessageParser<ServerResourceContainer> {

	public ServerMessageParser(ServerResourceContainer resourceManager) {
		super(resourceManager);
	}


}
