package com.dungr.recruitmenttaskr.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "operation", "value" })
public class SensorOperation {

	@JsonProperty("operation")
	private String operation;
	@JsonProperty("value")
	private String value;

	@JsonProperty("operation")
	public String getOperation() {
		return operation;
	}

	@JsonProperty("operation")
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

}