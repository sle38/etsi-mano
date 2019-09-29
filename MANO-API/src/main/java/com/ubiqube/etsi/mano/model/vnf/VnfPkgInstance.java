package com.ubiqube.etsi.mano.model.vnf;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VnfPkgInstance {
	private String instanceId;
	private final List<VnfPkgOperation> operations = new ArrayList<>();

	public VnfPkgInstance() {
		// Nothing.
	}

	public VnfPkgInstance(final String _instanceId) {
		instanceId = _instanceId;
	}

	@JsonProperty("InstanceId")
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(final String instanceId) {
		this.instanceId = instanceId;
	}

	@JsonProperty("Operations")
	public List<VnfPkgOperation> getOperations() {
		return operations;
	}

}