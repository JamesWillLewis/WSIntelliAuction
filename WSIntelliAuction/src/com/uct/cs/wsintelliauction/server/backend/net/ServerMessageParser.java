package com.uct.cs.wsintelliauction.server.backend.net;

import com.uct.cs.wsintelliauction.net.MessageParser;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.util.ResourceContainer;

public class ServerMessageParser extends MessageParser<ServerResourceContainer> {

	public ServerMessageParser(ServerResourceContainer resourceManager) {
		super(resourceManager);
	}


}
