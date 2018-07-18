package com.mlearn.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String obj2Json(Object obj){
		String jsonStr = null;
		try {

			jsonStr = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return jsonStr;
	}
	
	public static <T> T json2Obj(String jsonStr, Class<T> cls){
		T t = null;
		try {

			t = objectMapper.readValue(jsonStr, cls);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public static <T> List<T> json2List(String jsonStr, Class<T> cls){
		List<T> t = null;
		try {

			t = objectMapper.readValue(jsonStr, new TypeReference<List<T>>() {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
}
