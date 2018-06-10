package com.dungr.recruitmenttaskr.service;

import java.util.List;

import com.dungr.recruitmenttaskr.domain.Sensor;

public interface IEngineService {

	List<String> getBrokenEngines(List<Sensor> sensors, int pressure_threshold, int temp_threshold);

}