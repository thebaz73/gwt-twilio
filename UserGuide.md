Read the Twilio Client docs http://www.twilio.com/docs/client/
  * # Steps to using Twilio Client in your GWT app #
    1. Add gwt-twilio-1.1.jar to your projects classpath
    1. Add a link to the Twilio Client javascript file in your html file NB. Do not use https since it causes problems with some browsers.
> > > ```xml
<script type="text/javascript" src="http://static.twilio.com/libs/twiliojs/1.0/twilio.min.js">

Unknown end tag for &lt;/script&gt;

```
    1. Inherit the Twilio module in your GWT Module File
> > > ```xml
<inherits name='com.xedge.twilio.GWTTwilio'/>```
    1. Start coding...


# Code Snippets #
  * Import classes
```java
     import com.xedge.twilio.client.Connection;
import com.xedge.twilio.client.ConnectionHandler;
import com.xedge.twilio.client.Device;
import com.xedge.twilio.client.DeviceHandler;
import com.xedge.twilio.client.Error;
import com.xedge.twilio.client.ErrorHandler;```


  * Initialize Device with a capability token http://www.twilio.com/docs/client/capability-tokens
```java
    Device.setup(token);```

  * Get device ready
```java
    Device.ready(new DeviceHandler() {
@Override
public void handle(Device device) {
//device ready
}
});```

  * Add device error handler
```java
    Device.error(new ErrorHandler() {
@Override
public void handle(Error error) {
//error has occured
}
});```

  * Make a call
```java
    Device.connect();```

  * Make a call with parameters
```java
    Device.connect();
Map<String, String> params = new HashMap<String, String>();
params.put("contact", "08233433533");
Device.connect(params);```

  * Hangup on all connections
```java
    Device.disconnectAll();```

  * Listen for calls that are successfully established
```java
    Device.connect(new ConnectionHandler() {
@Override
public void handle(Connection connection) {
//Successfully established call
}
});```

  * Listen for calls that end
```java
    Device.disconnect(new ConnectionHandler() {
@Override
public void handle(Connection connection) {
//Call has ended
}
});```

  * Listen for incoming calls
```java
    Device.incoming(new ConnectionHandler() {
@Override
public void handle(Connection connection) {
//access to incoming connection parameters
String from = connection.getParameters().getFrom());
//accept a call
connection.accept();
}
});```

  * Listen for accepted connections/answered calls
```java
    connection.accept(new ConnectionHandler() {
@Override
public void handle(Connection connection) {
//connection accepted
}
});```

  * Listen for disconnected connections/hangup calls
```java
    connection.disconnect(new ConnectionHandler() {
@Override
public void handle(Connection connection) {
//connection disconnected
}
});```

  * Listen for errors on the connections/calls
```java
    connection.error(new ErrorHandler() {
@Override
public void handle(Error error) {
//Connection error
String errorMessage = error.getMessage();
String errorCode = error.getCode();
}
});```

  * Listen for availability state changes for any client currently associated with the Twilio account
```java
    Device.presence(new PresenceHandler() {
@Override
public void handle(PresenceEvent presenceEvent) {
String clientName = presenceEvent.getFrom();
boolean availability = presenceEvent.isAvailable();
}
});```