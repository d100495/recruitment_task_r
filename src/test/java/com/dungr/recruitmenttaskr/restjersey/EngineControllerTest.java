package com.dungr.recruitmenttaskr.restjersey;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.dungr.recruitmenttaskr.repo.ISensorRepository;
import com.dungr.recruitmenttaskr.repo.SensorRepository;
import com.dungr.recruitmenttaskr.restjersey.EngineController;
import com.dungr.recruitmenttaskr.service.EngineService;
import com.dungr.recruitmenttaskr.service.IEngineService;

public class EngineControllerTest {

	EngineController engineController = null;
	IEngineService engineService = null;
	ISensorRepository sensorRepository = null;

	@Before
	public void setUp() {
		engineService = mock(EngineService.class);
		sensorRepository = mock(SensorRepository.class);
		engineController = new EngineController(engineService, sensorRepository);
	}

	@Test
	public void testGetBrokenEngines_WhenRequestHasBeenProcessed_ShouldReturnStringListOkHTTP() {
		List<String> listString = new ArrayList<>();
		listString.add("12345");
		when(engineService.getBrokenEngines(any(), anyInt(), anyInt())).thenReturn(listString);
		when(sensorRepository.getSensors()).thenReturn(new ArrayList<>());

		Response response = engineController.getBrokenEngines(2, 5);
		assertEquals(200, response.getStatus());
		assertEquals(Response.ok("[12345]").build().getEntity(), response.getEntity());
	}

}
