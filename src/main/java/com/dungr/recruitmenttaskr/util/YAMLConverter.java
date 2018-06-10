package com.dungr.recruitmenttaskr.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YAMLConverter {

	public List<Sensor> convertYamlToSensorList(String yamlstr) {
		ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
		List<Sensor> list = new ArrayList<>();
		try {
			list = yamlReader.readValue(yamlstr, new TypeReference<ArrayList<Sensor>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
