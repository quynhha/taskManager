package com.amazonaws.lambda.demo.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;

public class ParseJSON {

	BufferedReader reader;
	ParseJSON parser;
	ParseJSON jsonString;

	public Map<String, String> jsonParser(InputStream stream) throws Exception {
		reader = new BufferedReader(new InputStreamReader(stream));
		parser = new ParseJSON();
		jsonString = (ParseJSON) parser.parse(reader);
		Map<String, String> map = new HashMap<>();

		for (Object key : jsonString.keySet()) {
			String keyStr = (String) key;
			Object keyvalue = jsonString.get(keyStr);
			map.put(keyStr, keyvalue.toString());
		}
		return map;
	}

	private Object get(String keyStr) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	private ParseJSON parse(BufferedReader reader2) {
		// TODO Auto-generated method stub
		return null;
	}
}