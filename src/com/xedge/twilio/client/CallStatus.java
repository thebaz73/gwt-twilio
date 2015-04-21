package com.xedge.twilio.client;
/**
 * queued	The call is ready and waiting in line before going out.
 * ringing	The call is currently ringing.
 * in-progress	The call was answered and Twilio is currently in progress.
 * completed	The call was answered and has ended normally.
 * busy	The caller received a busy signal.
 * failed	The call could not be completed as dialed, most likely because the phone number was non-existent.
 * no-answer	The call ended without being answered.
 * canceled	The call was canceled via the REST API while queued or ringing.
 * @author alessioh
 *
 */
public enum CallStatus {
	queued("queued"),
	ringing("ringing"),
	in_progress("in-progress"),
	completed("completed"),
	busy("busy"),
	failed("failed"),
	no_answer("no-answer"),
	canceled("ui-icon-grip-diagonal-secanceled");
	
	private String formattedName;

	CallStatus(String formattedName) {
		this.formattedName = formattedName;
	}

	public String getFormattedName() {
		return formattedName;
	}

	public static CallStatus getByFormattedName(String formattedName) {
		String name = formattedName.replace("-", "_");
		return valueOf(name);
	}
}
