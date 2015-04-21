package com.xedge.twilio.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a specific connection into Twilio, such as a call. You never
 * instantiate it directly, but it's often passed in event handlers and one is
 * returned when you call Device.connect().
 * 
 * @author alessioh
 * 
 */
public class Connection extends JavaScriptObject {
	public enum Status {
		pending, connecting, open, closed
	}

	protected Connection() {
	}

	public static native Connection create() /*-{
		return {};
	}-*/;

	/**
	 * Register a handler function to be called when this connection is
	 * accepted. Accepting a connection sets its status to connecting.
	 * 
	 * @param handler
	 */
	public final native void accept(ConnectionHandler handler) /*-{
		this.accept(function(connection) {
					@com.xedge.twilio.client.ConnectionHandler::fire(Lcom/xedge/twilio/client/ConnectionHandler;Lcom/xedge/twilio/client/Connection;)(handler,connection);
				});
	}-*/;

	/**
	 * Accept a pending connection.
	 */
	public final native void accept() /*-{
		this.accept();
	}-*/;

	/**
	 * Register a handler function to be called when this connection is closed.
	 * 
	 * @param handler
	 */
	public final native void disconnect(ConnectionHandler handler) /*-{
		this.disconnect(function(connection) {
					@com.xedge.twilio.client.ConnectionHandler::fire(Lcom/xedge/twilio/client/ConnectionHandler;Lcom/xedge/twilio/client/Connection;)(handler,connection);
				});
	}-*/;
	
	
	/**
	 * Close this connection.
	 */
	public final native void disconnect() /*-{
	this.disconnect();
}-*/;
	
	/**
	 * Register a handler function to be called when any asynchronous device
	 * error occurs during the lifetime of this connection.
	 * 
	 * @param handler
	 */
	public final native void error(ErrorHandler handler) /*-{
		this.error(function(error) {
					@com.xedge.twilio.client.ErrorHandler::fire(Lcom/xedge/twilio/client/ErrorHandler;Lcom/xedge/twilio/client/Error;)(handler,error);
				});
	}-*/;

	/**
	 * Stop capturing audio from the microphone for this connection.
	 */
	public final native void mute() /*-{
		this.mute();
	}-*/;

	/**
	 * Resume capturing audio from the microphone for this connection.
	 */
	public final native void unmute() /*-{
		this.unmute();
	}-*/;

	/**
	 * Play DTMF tones. The digits parameter is a string and can contain the
	 * characters 0-9, #, and * .
	 * 
	 * @param digits
	 */
	public final native void sendDigits(String digits) /*-{
		this.sendDigits(digits);
	}-*/;

	private final native String statusJS() /*-{
		return this.status();
	}-*/;

	/**
	 * Return the status of this connection. The status will be one of the
	 * following strings: "pending", "connecting", "open" or "closed". pending -
	 * The connection is incoming and hasn't yet been established. connecting -
	 * The connection is transitioning to open status. open - The connection has
	 * been established. closed - The connection has been disconnected.
	 * 
	 * @return
	 */
	public final Status status() {
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
	 * An object available on incoming connections that contains application
	 * parameters such as who is calling and what was dialed.
	 * 
	 * @return
	 */
	public final native Parameters getParameters() /*-{
		return this.parameters;
	}-*/;
}
