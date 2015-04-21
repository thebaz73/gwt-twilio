package com.xedge.twilio.client;

	public abstract class ErrorHandler {
		public abstract void handle(Error error);

		static public void fire(ErrorHandler handler, Error error) {
			handler.handle(error);
		}
	}
