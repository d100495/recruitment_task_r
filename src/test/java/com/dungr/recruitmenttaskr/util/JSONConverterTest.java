package com.dungr.recruitmenttaskr.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.dungr.recruitmenttaskr.domain.SensorOperation;
import com.dungr.recruitmenttaskr.util.JSONConverter;

public class JSONConverterTest {

	JSONConverter jsonConverter = null;

	@Before
	public void setUp() {
		jsonConverter = new JSONConverter();
	}

	@Test
	public void testConvertObjToJSON_WhenSensorHasId_ShouldReturnIdAsJSONString() {
		Sensor sensor = new Sensor();
		sensor.setId("10");
		assertEquals("{\"id\":\"10\"}", jsonConverter.convertObjToJSON(sensor));
	}

	@Test
	public void testConvertJSONToSensorOperation_WhenJSONStringIsCorrect_ShouldReturnBothObjValues() {
		String operationJSON = "{\r\n" + "  \"operation\": \"decrement\",\r\n" + "  \"value\": \"2\"\r\n" + "}";
		SensorOperation sensorOperation = new SensorOperation();
		sensorOperation.setOperation("decrement");
		sensorOperation.setValue("2");

		assertEquals(sensorOperation.getOperation(),
				jsonConverter.convertJSONToSensorOperation(operationJSON).getOperation());
		assertEquals(sensorOperation.getValue(), jsonConverter.convertJSONToSensorOperation(operationJSON).getValue());
	}

}
