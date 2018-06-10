package com.dungr.recruitmenttaskr.restjersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.dungr.recruitmenttaskr.repo.ISensorRepository;
import com.dungr.recruitmenttaskr.repo.SensorRepository;
import com.dungr.recruitmenttaskr.service.EngineService;
import com.dungr.recruitmenttaskr.service.IEngineService;

@Path("/engines")
public class EngineController {

	// This variable is static and initialized here, to simulate proper behavior of
	// @POST method with list in repository (changes are saved for every session)
	private static ISensorRepository sensorRepository = new SensorRepository();

	IEngineService engineService = null;

	public EngineController() {
		engineService = new EngineService();
		// Original initialization (without list in repository)
		// sensorRepository = new SensorRepository();
	}

	public EngineController(IEngineService engineService, ISensorRepository sensorRepository) {
		this.engineService = engineService;
		this.sensorRepository = sensorRepository;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBrokenEngines(@QueryParam("pressure_threshold") int pressure_threshold,
			@QueryParam("temp_threshold") int temp_threshold) {

		List<Sensor> sensors = sensorRepository.getSensors();
		List<String> brokenEngines = engineService.getBrokenEngines(sensors, pressure_threshold, temp_threshold);
		if (brokenEngines.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok(brokenEngines.toString()).build();
	}
}
