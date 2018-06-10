package com.dungr.recruitmenttaskr.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.dungr.recruitmenttaskr.service.EngineService;
import com.dungr.recruitmenttaskr.service.IEngineService;

public class EngineServiceTest {

	IEngineService engineService = null;
	List<Sensor> sensorList = null;

	@Before
	public void setUp() {
		engineService = new EngineService();
		sensorList = new ArrayList<>();
	}

	@Test
	public void testGetBrokenEngines_WhenOneEngineIsBroken_ShouldReturnListWithOneEngine() {
		Sensor sensor = new Sensor();
		sensor.setId("1");
		sensor.setValue(20);
		sensor.setEngine("engine1");
		sensor.setType("pressure");
		sensorList.add(sensor);

		Sensor sensor2 = new Sensor();
		sensor2.setId("2");
		sensor2.setValue(20);
		sensor2.setType("temperature");
		sensor2.setMasterSensorId("1");
		sensorList.add(sensor2);

		List<String> aList = engineService.getBrokenEngines(sensorList, 50, 10);
		String s = aList.get(0);
		assertEquals("engine1", s);
	}

}
