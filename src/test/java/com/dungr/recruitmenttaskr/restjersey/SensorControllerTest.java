package com.dungr.recruitmenttaskr.restjersey;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.dungr.recruitmenttaskr.repo.ISensorRepository;
import com.dungr.recruitmenttaskr.repo.SensorRepository;
import com.dungr.recruitmenttaskr.restjersey.SensorController;
import com.dungr.recruitmenttaskr.service.ISensorService;
import com.dungr.recruitmenttaskr.service.SensorService;

public class SensorControllerTest {

	SensorController sensorController = null;
	ISensorService sensorService = null;
	ISensorRepository sensorRepository = null;

	@Before
	public void setUp() {
		sensorService = mock(SensorService.class);
		sensorRepository = mock(SensorRepository.class);
		sensorController = new SensorController(sensorService, sensorRepository);
	}

	@Test
	public void testGetSensors_WhenRequestHasBeenProcessed_ShouldReturnStringListOkHTTP() {
		List<Sensor> sensorList = new ArrayList<>();
		Sensor sensor = new Sensor();
		sensor.setId("2");
		sensorList.add(sensor);

		when(sensorRepository.getSensors()).thenReturn(sensorList);

		Response response = sensorController.getSensors();

		assertEquals(200, response.getStatus());
		assertEquals(Response.ok("[{\"id\":\"2\"}]").build().getEntity(), response.getEntity());
	}

	@Test
	public void testUpdateSensor_WhenRequestHasBeenProcessed_ShouldReturnSensorOkHTTP() {
		List<Sensor> sensorList = new ArrayList<>();
		Sensor sensor = new Sensor();
		sensor.setId("2");
		sensorList.add(sensor);

		Sensor sensor2 = new Sensor();
		sensor2.setId("3");
		sensor2.setValue(20);
		sensor2.setMaxValue(100);
		sensor2.setMinValue(0);

		when(sensorRepository.getSensors()).thenReturn(sensorList);
		when(sensorService.modifySensorValue(any(), anyString(), anyInt(), anyInt())).thenReturn(sensor2);

		Response response = sensorController.updateSensor("3",
				"{\r\n" + "  \"operation\": \"set\",\r\n" + "  \"value\": \"3\"\r\n" + "}");
		assertEquals(200, response.getStatus());
		assertEquals(Response.ok("{\"id\":\"3\",\"value\":20,\"min_value\":0,\"max_value\":100}").build().getEntity(),
				response.getEntity());
	}

}
