package com.bit.framework;

import java.util.HashMap;
import java.util.Map;

import com.bit.controller.Controller;

public class HandlerMapping {
	private static Map<String, Controller> map = new HashMap<String, Controller>();
	
	public static void setMap(String key, String value) {
		Class clazz;
		try {
			clazz = Class.forName(value);
			map.put(key, (Controller) clazz.newInstance());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public static Controller getController(String key) {
		return map.get(key);
	}

}
