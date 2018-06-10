package com.dungr.recruitmenttaskr.restjersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dungr.recruitmenttaskr.domain.Sensor;
import com.dungr.recruitmenttaskr.domain.SensorOperation;
import com.dungr.recruitmenttaskr.repo.ISensorRepository;
import com.dungr.recruitmenttaskr.repo.SensorRepository;
import com.dungr.recruitmenttaskr.service.ISensorService;
import com.dungr.recruitmenttaskr.service.SensorService;
import com.dungr.recruitmenttaskr.util.JSONConverter;

@Path("/sensors")
public class SensorController {

	// This variable is static and initialized here, to simulate proper behavior of
	// @POST method with list in repository (changes are saved for every session)
	private static ISensorRepository sensorRepository = new SensorRepository();

	private ISensorService sensorService = null;

	public SensorController() {
		sensorService = new SensorService();
		// Original initialization (without list in repository)
		// sensorRepository = new SensorRepository();
	}

	public SensorController(ISensorService sensorService, ISensorRepository sensorRepository) {
		this.sensorService = sensorService;
		this.sensorRepository = sensorRepository;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSensors() {
		List<Sensor> sensorList = sensorRepository.getSensors();
		String sensorListJSON = new JSONConverter().convertObjToJSON(sensorList);
		return Response.ok(sensorListJSON).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSensor(@PathParam("id") String id, String body) {
		List<Sensor> sensorList = sensorRepository.getSensors();
		SensorOperation sensorOperation = new JSONConverter().convertJSONToSensorOperation(body);

		Sensor sensor = sensorService.modifySensorValue(sensorList, sensorOperation.getOperation(),
				Integer.valueOf(sensorOperation.getValue()), Integer.valueOf(id));

		return Response.ok(new JSONConverter().convertObjToJSON(sensor)).build();
	}
}
