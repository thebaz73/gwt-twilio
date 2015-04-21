package com.xedge.twilio.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The configuration object for the sounds for this device. These are the default sounds played for an incomming connection, 
 * initiating an outgoing connection, and disconnecting a connection.
 * @author alessioh
 *
 */
public class Sounds extends JavaScriptObject {
	protected Sounds() {
	}

	public static native Sounds create() /*-{
		return {};
	}-*/;

	public static native Sounds create(boolean incoming, boolean outgoing, boolean disconnect) /*-{
		var obj = {};
		obj.incoming = incoming;
		obj.outgoing = outgoing;
		obj.disconnect = disconnect;
		return obj;
	}-*/;

	public final native boolean getIncoming() /*-{
		return this.incoming;
	}-*/;

	public final native void setIncoming(boolean incoming) /*-{
		this.incoming = incoming;
	}-*/;

	public final native boolean getOutgoing() /*-{
		return this.outgoing;
	}-*/;

	public final native void setOutgoing(boolean outgoing) /*-{
		this.outgoing = outgoing;
	}-*/;

	public final native boolean getDisconnect() /*-{
		return this.disconnect;
	}-*/;

	public final native void setDisconnect(boolean disconnect) /*-{
		this.disconnect = disconnect;
	}-*/;

}
