package com.dungr.recruitmenttaskr.util;

import java.io.IOException;

import com.dungr.recruitmenttaskr.domain.SensorOperation;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConverter {
	public String convertObjToJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		String json = new String();
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public SensorOperation convertJSONToSensorOperation(String JSON) {
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		SensorOperation sensorOperation = new SensorOperation();
		try {
			sensorOperation = mapper.readValue(JSON, new TypeReference<SensorOperation>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sensorOperation;
	}
}
