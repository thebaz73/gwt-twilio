package com.xedge.twilio.client;

public abstract class DeviceHandler {
	public abstract void handle(Device device);
	
	static public void fire(DeviceHandler handler,Device device) {
		handler.handle(device);
	}
}