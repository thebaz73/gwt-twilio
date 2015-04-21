package com.xedge.twilio.client;

import com.google.gwt.core.client.JavaScriptObject;

public class PresenceEvent extends JavaScriptObject {
	protected PresenceEvent() {
	}

	public static native PresenceEvent create() /*-{
		return {};
	}-*/;

	/**
	 * The string representing the registered client identifier for which the presence change has occurred. 
	 * The string will only contain alphanumeric and underscore characters.
	 * @return
	 */
	public final native String getFrom() /*-{
		return this.from;
	}-*/;

	public final native void setFrom(String from) /*-{
		this.from = from;
	}-*/;

	/**
	 * true if the client specified by from is connected to Twilio, false otherwise.
	 * @return
	 */
	public final native boolean isAvailable() /*-{
		return this.available;
	}-*/;

	public final native void setAvailable(boolean available) /*-{
		this.available = available;
	}-*/;
}
