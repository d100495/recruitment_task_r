package com.dungr.recruitmenttaskr.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "engine", "type", "name", "value", "min_value", "max_value", "master-sensor-id",
		"location" })

public class Sensor {

	@JsonProperty("id")
	private String id;
	@JsonProperty("engine")
	private String engine;
	@JsonProperty("type")
	private String type;
	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private Integer value;
	@JsonProperty("min_value")
	private Integer minValue;
	@JsonProperty("max_value")
	private Integer maxValue;
	@JsonProperty("master-sensor-id")
	private String masterSensorId;
	@JsonProperty("location")
	private String location;

	@Override
	public String toString() {
		return "Id: " + getId() + "\n Name: " + getName() + "\n Engine: " + getEngine() + "\n MasterSensorID: "
				+ getMasterSensorId() + "\n Value: " + getValue() + "\n Location: " + getLocation() + "\n Type: "
				+ getType() + "\n MaxValue: " + getMaxValue() + "\n MinValue: " + getMinValue();
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("engine")
	public String getEngine() {
		return engine;
	}

	@JsonProperty("engine")
	public void setEngine(String engine) {
		this.engine = engine;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("value")
	public Integer getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(Integer value) {
		this.value = value;
	}

	@JsonProperty("min_value")
	public Integer getMinValue() {
		return minValue;
	}

	@JsonProperty("min_value")
	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	@JsonProperty("max_value")
	public Integer getMaxValue() {
		return maxValue;
	}

	@JsonProperty("max_value")
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	@JsonProperty("master-sensor-id")
	public String getMasterSensorId() {
		return masterSensorId;
	}

	@JsonProperty("master-sensor-id")
	public void setMasterSensorId(String masterSensorId) {
		this.masterSensorId = masterSensorId;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

}
