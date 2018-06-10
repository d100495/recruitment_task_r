package com.dungr.recruitmenttaskr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dungr.recruitmenttaskr.domain.Sensor;

public class EngineService implements IEngineService {

	@Override
	public List<String> getBrokenEngines(List<Sensor> sensors, int pressure_threshold, int temp_threshold) {
		Map<String, String> idToEngineWithLowPressure = new HashMap<>();
		Set<String> masterIdsForSensorWithHighTemp = new HashSet<>();
		Set<String> brokenEngines = new HashSet<>();
		sensors.forEach(sen -> {
			if (sen.getType().equals("pressure") && sen.getValue() < pressure_threshold) {
				idToEngineWithLowPressure.put(sen.getId(), sen.getEngine());
			}
		});
		sensors.forEach(sen -> {
			if (sen.getType().equals("temperature")) {
				if (idToEngineWithLowPressure.containsKey(sen.getMasterSensorId()) && sen.getValue() > temp_threshold) {
					masterIdsForSensorWithHighTemp.add(sen.getMasterSensorId());
				}
			}
		});
		idToEngineWithLowPressure.forEach((k, v) -> {
			if (masterIdsForSensorWithHighTemp.contains(k)) {
				brokenEngines.add(v);
			}
		});
		return new ArrayList<String>(brokenEngines);
	}

}
