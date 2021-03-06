package com.ubiqube.etsi.mano.dao.mano;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VduInstantiationLevel implements Serializable {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	private VnfCompute vnfCompute;

	private String levelName;

	private int numberOfInstances;

	public VduInstantiationLevel() {
		// Nothing.
	}

	public VduInstantiationLevel(final int _numberOfInstance) {
		numberOfInstances = _numberOfInstance;
	}

	public VduInstantiationLevel(final String _levelName, final int _numberOfInstance) {
		levelName = _levelName;
		numberOfInstances = _numberOfInstance;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public VnfCompute getVnfCompute() {
		return vnfCompute;
	}

	public void setVnfCompute(final VnfCompute vnfCompute) {
		this.vnfCompute = vnfCompute;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(final String levelName) {
		this.levelName = levelName;
	}

	public int getNumberOfInstances() {
		return numberOfInstances;
	}

	public void setNumberOfInstances(final int numberOfInstances) {
		this.numberOfInstances = numberOfInstances;
	}

}
