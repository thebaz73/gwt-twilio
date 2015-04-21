package com.xedge.twilio.client;

import java.util.Map;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class JSHelper {

	public static final JSONObject convertStringMapToJSONObject(Map<String,String> map){
		JSONObject parameter = new JSONObject();
		if(map!=null){
		for (String key : map.keySet()) {
			String value = map.get(key);
			parameter.put(key, new JSONString(value));
		}
		}
		return parameter;
	}
	
	
}
