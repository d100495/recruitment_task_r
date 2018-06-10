package com.dungr.recruitmenttaskr.service;

import java.util.List;
import java.util.ListIterator;

import com.dungr.recruitmenttaskr.domain.Sensor;

public class SensorService implements ISensorService {

	@Override
	public Sensor modifySensorValue(List<Sensor> sensors, String operation, int value, int id) {
		ListIterator<Sensor> listIterator = sensors.listIterator();
		Sensor sensor = new Sensor();

		while (listIterator.hasNext()) {
			Sensor sen = listIterator.next();
			if (sen.getId().equals(String.valueOf(id))) {
				int currentValue = sen.getValue();

				if (operation.equals("set")) {
					currentValue = value;
					sensor = setSensorValueWithValidation(sen, currentValue);
				}
				if (operation.equals("increment")) {
					currentValue += value;
					sensor = setSensorValueWithValidation(sen, currentValue);
				}
				if (operation.equals("decrement")) {
					currentValue -= value;
					sensor = setSensorValueWithValidation(sen, currentValue);
				}
			}
		}
		return sensor;
	}

	Sensor setSensorValueWithValidation(Sensor sensor, int value) {
		if (value <= sensor.getMaxValue() && value >= sensor.getMinValue()) {
			sensor.setValue(value);
			return sensor;
		} else {
			return sensor;
		}
	}
}
