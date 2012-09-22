package com.uct.cs.wsintelliauction.server.frontend.models;

import java.net.InetAddress;

import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceManager;

public class ServerTabModel extends Model<ServerResourceManager> {

	private boolean serverOn;

	private String hostNameField;
	private String hostAddressField;
	private String hostIPField;
	private String portField;
	private String connectionsField;

	public ServerTabModel(ServerResourceManager resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		serverOn = resourceManager.getServerNetworkManager().getServerActive()
				.get();
		updateServerStats();
	}

	public void updateServerStats() {
		if (serverOn) {
			InetAddress addr = resourceManager.getServerNetworkManager()
					.getServerHostAddress();
			int portNum = resourceManager.getServerNetworkManager()
					.getServerPortNumber();
			hostNameField = addr.getHostName();
			hostAddressField = addr.getCanonicalHostName();
			hostIPField = addr.getHostAddress();
			portField = String.valueOf(portNum);
			connectionsField = String.valueOf(resourceManager
					.getServerNetworkManager().getNumberOfConnections());
		} else {
			hostNameField = "";
			hostAddressField = "";
			hostIPField = "";
			portField = "";
			connectionsField = "";
		}
	}

	public void turnOnServer() {
		resourceManager.getServerNetworkManager().startServer();
		serverOn = resourceManager.getServerNetworkManager().getServerActive()
				.get();
		updateServerStats();
	}

	public void turnOffServer() {
		resourceManager.getServerNetworkManager().stopServer();
		serverOn = resourceManager.getServerNetworkManager().getServerActive()
				.get();
		updateServerStats();
	}

	public boolean isServerOn() {
		return serverOn;
	}

	public String getHostNameField() {
		return hostNameField;
	}

	public String getHostAddressField() {
		return hostAddressField;
	}
	
	public String getHostIPField() {
		return hostIPField;
	}

	public String getPortField() {
		return portField;
	}

	public String getConnectionsField() {
		return connectionsField;
	}
}
