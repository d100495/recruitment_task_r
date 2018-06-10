package com.dungr.recruitmenttaskr.service;

import java.util.List;

import com.dungr.recruitmenttaskr.domain.Sensor;

public interface ISensorService {

	Sensor modifySensorValue(List<Sensor> sensors, String operation, int value, int id);

}