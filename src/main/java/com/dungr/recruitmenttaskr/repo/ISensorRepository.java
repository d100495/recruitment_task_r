package com.dungr.recruitmenttaskr.repo;

import java.util.List;

import com.dungr.recruitmenttaskr.domain.Sensor;

public interface ISensorRepository {

	List<Sensor> getSensors();

	void putSensor(Sensor sensor);

}