package com.xedge.twilio.client;

public abstract class ConnectionHandler {
	public abstract void handle(Connection connection);

	static public void fire(ConnectionHandler handler, Connection connection) {
		handler.handle(connection);
	}
}