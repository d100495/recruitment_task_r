package com.dungr.recruitmenttaskr.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.dungr.recruitmenttaskr.domain.SensorOperation;
import com.dungr.recruitmenttaskr.service.ISensorService;
import com.dungr.recruitmenttaskr.service.SensorService;

public class SensorServiceTest {

	Sensor sensor = null;
	SensorOperation sensorOperation = null;
	ISensorService sensorService = null;
	List<Sensor> sensorList = null;

	@Before
	public void setUp() {
		sensor = new Sensor();
		sensorService = new SensorService();
		sensorOperation = new SensorOperation();
		sensorList = new ArrayList<>();

		sensor.setId("1");
		sensor.setValue(20);
		sensor.setMaxValue(150);
		sensor.setMinValue(0);
		sensorList.add(sensor);
	}

	@Test
	public void testModifySensorValue_WhenDecrementAndValueIsOk_ShouldReturnChangedValue() {
		Sensor changedSensor = sensorService.modifySensorValue(sensorList, "decrement", 20, 1);
		assertEquals(Integer.valueOf(0), changedSensor.getValue());
	}

	@Test
	public void testModifySensorValue_WhenIncrementAndValueIsOk_ShouldReturnChangedValue() {
		Sensor changedSensor = sensorService.modifySensorValue(sensorList, "increment", 20, 1);
		assertEquals(Integer.valueOf(40), changedSensor.getValue());
	}

	@Test
	public void testModifySensorValue_WhenSetAndValueIsOk_ShouldReturnChangedValue() {
		Sensor changedSensor = sensorService.modifySensorValue(sensorList, "set", 5, 1);
		assertEquals(Integer.valueOf(5), changedSensor.getValue());
	}

}
