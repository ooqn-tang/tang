package com.ooqn.util;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDemo {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper obj = new ObjectMapper();
		obj.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		JsonNode readTree = obj.readTree("{'a':{'c':'b'}}");

		for (JsonNode jsonNode : readTree) {
			System.out.println(jsonNode);
		}
	}
}
