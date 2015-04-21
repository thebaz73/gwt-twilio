package com.xedge.twilio.client;




public enum CallDirection {
	inbound("inbound"),
	outbound_dial("outbound-dial");
	
	private String formattedName;

	CallDirection(String formattedName) {
		this.formattedName = formattedName;
	}

	public String getFormattedName() {
		return formattedName;
	}

	public static CallDirection getByFormattedName(String formattedName) {
		String name = formattedName.replace("-", "_");
		return valueOf(name);
	}
}