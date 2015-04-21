package com.xedge.twilio.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Parameters extends JavaScriptObject {

	protected Parameters() {
	}

	public static native Parameters create() /*-{
		return {};
	}-*/;

	/**
	 * A unique identifier for this call, generated by Twilio.
	 * 
	 * @return
	 */
	public final native String getCallSid() /*-{
		return this.CallSid;
	}-*/;

	/**
	 * Your Twilio account id. It is 34 characters long, and always starts with
	 * the letters AC.
	 * 
	 * @return
	 */
	public final native String getAccountSid() /*-{
		return this.AccountSid;
	}-*/;

	/**
	 * The phone number or client identifier of the party that initiated the
	 * call. Phone numbers are formatted with a '+' and country code, e.g.
	 * +16175551212 (E.164 format). Client identifiers begin with the client:
	 * URI scheme; for example, for a call from a client named 'tommy', the From
	 * parameter will be client:tommy.
	 * 
	 * @return
	 */
	public final native String getFrom() /*-{
		return this.From;
	}-*/;

	/**
	 * The phone number or client identifier of the called party. Phone numbers
	 * are formatted with a '+' and country code, e.g. +16175551212 (E.164
	 * format). Client identifiers begin with the client: URI scheme; for
	 * example, for a call to a client named 'jenny', the To parameter will be
	 * client:jenny.
	 * 
	 * @return
	 */
	public final native String getTo() /*-{
		return this.To;
	}-*/;

	private final native String getCallStatusJS() /*-{
		return this.CallStatus;
	}-*/;

	/**
	 * A descriptive status for the call.
	 * 
	 * @return
	 */
	public final CallStatus getCallStatus() {
		CallStatus status = null;
		try {
			String statusValue = getCallStatusJS();
			if (statusValue != null) {
				status = CallStatus.getByFormattedName(statusValue);
			}
		} catch (Exception e) {
		}
		return status;
	}

	/**
	 * The version of the Twilio API used to handle this call.
	 * 
	 * @return
	 */
	public final native String getApiVersion() /*-{
		return this.ApiVersion;
	}-*/;

	private final native String getCallDirectionJS() /*-{
		return this.Direction;
	}-*/;

	/**
	 * Indicates the direction of the call. In most cases this will be inbound,
	 * but if you are using <Dial> it will be outbound-dial.
	 * 
	 * @return
	 */
	public final CallDirection getCallDirection() {
		CallDirection callDirection = null;
		try {
			String callDirectionValue = getCallDirectionJS();
			if (callDirectionValue != null) {
				callDirection = CallDirection.getByFormattedName(callDirectionValue);
			}
		} catch (Exception e) {
		}
		return callDirection;
	}

	/**
	 * This parameter is set only when Twilio receives a forwarded call, but its
	 * value depends on the caller's carrier including information when
	 * forwarding. Not all carriers support passing this information.
	 * 
	 * @return
	 */
	public final native String getForwardedFrom() /*-{
		return this.ForwardedFrom;
	}-*/;

	/**
	 * The state or province of the caller.
	 * 
	 * @return
	 */
	public final native String getFromState() /*-{
		return this.FromState;
	}-*/;

	/**
	 * The city of the caller.
	 * 
	 * @return
	 */
	public final native String getFromCity() /*-{
		return this.FromCity;
	}-*/;

	/**
	 * The postal code of the caller.
	 * 
	 * @return
	 */
	public final native String getFromZip() /*-{
		return this.FromZip;
	}-*/;

	/**
	 * The country of the caller.
	 * 
	 * @return
	 */
	public final native String getFromCountry() /*-{
		return this.FromCountry;
	}-*/;

	/**
	 * The city of the called party.
	 * 
	 * @return
	 */
	public final native String getToCity() /*-{
		return this.ToCity;
	}-*/;

	/**
	 * The state or province of the called party.
	 * 
	 * @return
	 */
	public final native String getToState() /*-{
		return this.ToState;
	}-*/;

	/**
	 * The postal code of the called party.
	 * 
	 * @return
	 */
	public final native String getToZip() /*-{
		return this.ToZip;
	}-*/;

	/**
	 * The country of the called party.
	 * 
	 * @return
	 */
	public final native String getToCountry() /*-{
		return this.ToCountry;
	}-*/;

	/**
	 * The duration in seconds of the just-completed call.
	 * 
	 * @return
	 */
	public final native int getCallDuration() /*-{
	return this.CallDuration;
	}-*/;

}
