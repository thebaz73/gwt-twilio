package com.xedge.twilio.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Error extends JavaScriptObject {
	protected Error() {
	}

	public static native Error create() /*-{
		return {};
	}-*/;

	/**
	 * A string describing the error.
	 * @return
	 */
	public final native String getMessage() /*-{
		return this.message;
	}-*/;

	public final native void setMessage(String message) /*-{
		this.message = message;
	}-*/;

	/**
	 * A numeric error code described in the Twilio Client error code reference.
	 * @return
	 */
	public final native int getCode() /*-{
		return this.code;
	}-*/;

	public final native void setCode(int code) /*-{
		this.code = code;
	}-*/;

	/**
	 * A copy of the Flash info object produced by the events around the flash.net.NetConnection object.
	 * @return
	 */
	public final native JavaScriptObject getInfo() /*-{
		return this.info;
	}-*/;

	public final native void setInfo(JavaScriptObject info) /*-{
		this.info = info;
	}-*/;

	/**
	 * Reference to the Connection object that was active when the error occured.
	 * @return
	 */
	public final native Connection getConnection() /*-{
		return this.connection;
	}-*/;

	public final native void setConnection(Connection connection) /*-{
		this.connection = connection;
	}-*/;
}
