package com.xedge.twilio.client;
	public abstract class PresenceHandler {
		public abstract void handle(PresenceEvent presenceEvent);

		static public void fire(PresenceHandler handler, PresenceEvent presenceEvent) {
			handler.handle(presenceEvent);
		}
	}
