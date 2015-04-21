package com.xedge.twilio.client;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * It represents a "soft device, the client that provides connections into Twilio.
 * There is no need to instantiate Device yourself, but you do need to invoke setup() before using it.
 * @author alessioh
 *
 */
public class Device extends JavaScriptObject {
	public enum Status {
		offline, ready, busy
	}
	
	protected Device() {
	}

	/**
	 * Initialize Device with a capability token.This will activate the device
	 * and give it an identity and certain privileges based on the token passed.
	 * You should call this before anything else. If your token allows inbound
	 * client connections, the device will start listening for new connections
	 * when you call .setup().
	 * 
	 * @param token
	 */
	public static final native void setup(String token) /*-{
		$wnd.Twilio.Device.setup(token);
	}-*/;

	/**
	 * Register a handler function to be called when the ready event is fired.
	 * This is initially triggered when all operations in setup() have completed
	 * and the device is ready and online. It may be triggered again if the
	 * device goes offline and comes back online.
	 * 
	 * @param handler
	 */
	public static final native void ready(DeviceHandler handler) /*-{
		$wnd.Twilio.Device
				.ready(function(device) {
					@com.xedge.twilio.client.DeviceHandler::fire(Lcom/xedge/twilio/client/DeviceHandler;Lcom/xedge/twilio/client/Device;)(handler,device);
				});
	}-*/;

	/**
	 * Register a handler function to be called when the offline event is fired.
	 * This is triggered when the network connection drops, meaning the device
	 * will not receive incoming connections.
	 * 
	 * @param handler
	 */
	public static final native void offline(DeviceHandler handler) /*-{
		$wnd.Twilio.Device
				.offline(function(device) {
					@com.xedge.twilio.client.DeviceHandler::fire(Lcom/xedge/twilio/client/DeviceHandler;Lcom/xedge/twilio/client/Device;)(handler,device);
				});
	}-*/;

	/**
	 * Register a handler function to be called when an incoming event is fired.
	 * This is triggered whenever an incoming connection from an outbound REST
	 * call or a TwiML <Dial> to to this device is made.
	 * 
	 * @param handler
	 */
	public static final native void incoming(ConnectionHandler handler) /*-{
		$wnd.Twilio.Device
				.incoming(function(connection) {
					@com.xedge.twilio.client.ConnectionHandler::fire(Lcom/xedge/twilio/client/ConnectionHandler;Lcom/xedge/twilio/client/Connection;)(handler,connection);
				});
	}-*/;

	/**
	 * Register a handler function to be called when the device receives a
	 * canceled event. This is triggered when an incoming connection is canceled
	 * by the caller before it is accepted by the device.
	 * 
	 * @param handler
	 */
	public static final native void cancel(ConnectionHandler handler) /*-{
		$wnd.Twilio.Device
				.cancel(function(connection) {
					@com.xedge.twilio.client.ConnectionHandler::fire(Lcom/xedge/twilio/client/ConnectionHandler;Lcom/xedge/twilio/client/Connection;)(handler,connection);
				});
	}-*/;

	/**
	 * Register a handler function to be called when the device receives a
	 * connect event. This is triggered when a connection is opened, whether
	 * initiated using .connect() or via an accepted incoming connection.
	 * 
	 * @param handler
	 */
	public static final native void connect(ConnectionHandler handler) /*-{
		$wnd.Twilio.Device
				.connect(function(connection) {
					@com.xedge.twilio.client.ConnectionHandler::fire(Lcom/xedge/twilio/client/ConnectionHandler;Lcom/xedge/twilio/client/Connection;)(handler,connection);
				});
	}-*/;

	/**
	 * Attempt a new connection to a Twilio Application.
	 * 
	 * @return
	 */
	public static final native Connection connect() /*-{
		return $wnd.Twilio.Device.connect();
	}-*/;

	/**
	 * Attempt a new connection to a Twilio Application.The optional params
	 * argument is a JavaScript object which will be url-encoded and passed to
	 * your application as POST/GET parameters. Your application should not
	 * assume that these parameters are safe since any user can call this
	 * function with whatever parameters she wants.
	 * 
	 * @param params
	 * @return
	 */
	public static final Connection connect(Map<String, String> params) {

		return connectJS(JSHelper.convertStringMapToJSONObject(params).getJavaScriptObject());
	}

	private static final native Connection connectJS(JavaScriptObject params) /*-{
		return $wnd.Twilio.Device.connect(params);
	}-*/;

	/**
	 * Terminate all active connections. This will trigger the disconnect event
	 * handler for each active connection. It will not prevent new incoming
	 * connections.
	 */
	public static final native void disconnectAll() /*-{
		$wnd.Twilio.Device.disconnectAll();
	}-*/;

	/**
	 * Register a handler function to be called any time a connection is closed.
	 * 
	 * @param handler
	 */
	public static final native void disconnect(ConnectionHandler handler) /*-{
		$wnd.Twilio.Device
				.disconnect(function(connection) {
					@com.xedge.twilio.client.ConnectionHandler::fire(Lcom/xedge/twilio/client/ConnectionHandler;Lcom/xedge/twilio/client/Connection;)(handler,connection);
				});
	}-*/;

	/**
	 * Register a handler function to be called when any asynchronous device
	 * error occurs. These may be errors in your request, your capability token,
	 * connection errors, or other application errors.
	 * 
	 * @param handler
	 */
	public static final native void error(ErrorHandler handler) /*-{
		$wnd.Twilio.Device
				.error(function(error) {
					@com.xedge.twilio.client.ErrorHandler::fire(Lcom/xedge/twilio/client/ErrorHandler;Lcom/xedge/twilio/client/Error;)(handler,error);
				});
	}-*/;

	private static final native String statusJS() /*-{
		return $wnd.Twilio.Device.status();
	}-*/;

	/**
	 * Return the status of the device. The status will be one of the following
	 * strings: "offline", "ready", or "busy". 
	 * ready - The device can receive incoming connections and attempt outgoing connections. 
	 * offline - The device is not connected and cannot receive incoming connections. 
	 * busy - The device is connected to the network, has an active connection, and
	 * cannot receive incoming connections or make outgoing connection attempts.
	 * 
	 * @return
	 */
	public static final Status status() {
		Status status = null;
		try {
			String statusValue = statusJS();
			if (statusValue != null) {
				status = Status.valueOf(statusValue);
			}
		} catch (Exception e) {
		}
		return status;
	}

	/**
	 * The configuration object for the sounds for this device.
	 * @return
	 */
	public static final native Sounds sounds() /*-{
		return $wnd.Twilio.Device.sounds();
	}-*/;

	
	/**
	 * Register a handler function to be called when availability state changes for any client currently associated with your 
	 * Twilio account. When the device is ready, this handler function is invoked once for each available client. 
	 * Thereafter it is invoked as clients become available or unavailable.
	 * @param handler
	 */
	public static final native void presence(PresenceHandler handler) /*-{
	$wnd.Twilio.Device
			.presence(function(presenceEvent) {
				@com.xedge.twilio.client.PresenceHandler::fire(Lcom/xedge/twilio/client/PresenceHandler;Lcom/xedge/twilio/client/PresenceEvent;)(handler,presenceEvent);
			});
}-*/;
}
