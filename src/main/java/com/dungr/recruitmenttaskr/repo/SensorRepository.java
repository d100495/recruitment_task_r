package com.dungr.recruitmenttaskr.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.dungr.recruitmenttaskr.util.GitHubFileLoader;
import com.dungr.recruitmenttaskr.util.RestConstants;
import com.dungr.recruitmenttaskr.util.YAMLConverter;

public class SensorRepository implements ISensorRepository {

	static final String dataSource = RestConstants.DATASOURCE_PATH;

	public SensorRepository() {
		if (dataSource != null) {
			setListWithSensors(dataSource);
		}
	}

	@Override
	public List<Sensor> getSensors() {
		return getListWithSensors();
	}

	@Override
	public void putSensor(Sensor sensor) {
		modifySensorInList(sensor);
	}

	// This variable exists only because it's not possible to change the contents of
	// the sensors.yml file on github
	private static List<Sensor> sensorList = new ArrayList<>();

	// This method exists only because it's not possible to change the contents of
	// the sensors.yml file on github
	private List<Sensor> getListWithSensors() {
		return sensorList;
	}

	// This method exists only because it's not possible to change the contents of
	// the sensors.yml file on github
	private void setListWithSensors(String dataSource) {
		String yamlstr = new GitHubFileLoader().loadGitHubFileContent(dataSource);
		sensorList = new YAMLConverter().convertYamlToSensorList(yamlstr);
	}

	// This method exists only because it's not possible to change the contents of
	// the sensors.yml file on github
	private void modifySensorInList(Sensor sensor) {
		ListIterator<Sensor> sensorListIterator = sensorList.listIterator();
		while (sensorListIterator.hasNext()) {
			Sensor sen = sensorListIterator.next();

			if (sen.getId().equals(sensor.getId())) {
				sensorListIterator.set(sensor);
			}
		}
	}

}
