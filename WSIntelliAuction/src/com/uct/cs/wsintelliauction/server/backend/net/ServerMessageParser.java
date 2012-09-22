package com.uct.cs.wsintelliauction.server.backend.net;

import com.uct.cs.wsintelliauction.net.MessageParser;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceManager;
import com.uct.cs.wsintelliauction.util.ResourceManager;

public class ServerMessageParser extends MessageParser<ServerResourceManager> {

	public ServerMessageParser(ServerResourceManager resourceManager) {
		super(resourceManager);
	}


}
