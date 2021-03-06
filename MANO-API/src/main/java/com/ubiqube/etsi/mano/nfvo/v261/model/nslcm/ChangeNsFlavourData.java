package com.ubiqube.etsi.mano.nfvo.v261.model.nslcm;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type specifies an existing NS instance for which the DF needs to be
 * changed. This specifies the new DF, the instantiationLevel of the new DF that
 * may be used and the additional parameters as input for the flavour change. It
 * shall comply with the provisions defined in Table 6.5.3.39-1.
 */
@ApiModel(description = "This type specifies an existing NS instance for which the DF needs to be changed. This specifies the new DF, the instantiationLevel of the new DF that may be used and the additional parameters as input for the flavour change. It shall comply with the provisions defined in Table 6.5.3.39-1. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T16:49:58.135+01:00")

public class ChangeNsFlavourData {
	@JsonProperty("newNsFlavourId")
	private String newNsFlavourId = null;

	@JsonProperty("instantiationLevelId")
	private String instantiationLevelId = null;

	public ChangeNsFlavourData newNsFlavourId(final String newNsFlavourId) {
		this.newNsFlavourId = newNsFlavourId;
		return this;
	}

	/**
	 * Identifier of an existing VNFFG to be updated for the NS Instance.
	 * 
	 * @return newNsFlavourId
	 **/
	@ApiModelProperty(required = true, value = "Identifier of an existing VNFFG to be updated for the NS Instance. ")
	@NotNull

	public String getNewNsFlavourId() {
		return newNsFlavourId;
	}

	public void setNewNsFlavourId(final String newNsFlavourId) {
		this.newNsFlavourId = newNsFlavourId;
	}

	public ChangeNsFlavourData instantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
		return this;
	}

	/**
	 * Identifier of the instantiation level of the deployment flavour to be
	 * instantiated. If not present, the default instantiation level as declared in
	 * the NSD is instantiated.
	 * 
	 * @return instantiationLevelId
	 **/
	@ApiModelProperty(value = "Identifier of the instantiation level of the deployment flavour to be instantiated. If not present, the default instantiation level as declared in the NSD is instantiated. ")

	public String getInstantiationLevelId() {
		return instantiationLevelId;
	}

	public void setInstantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ChangeNsFlavourData changeNsFlavourData = (ChangeNsFlavourData) o;
		return Objects.equals(this.newNsFlavourId, changeNsFlavourData.newNsFlavourId) &&
				Objects.equals(this.instantiationLevelId, changeNsFlavourData.instantiationLevelId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(newNsFlavourId, instantiationLevelId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ChangeNsFlavourData {\n");

		sb.append("    newNsFlavourId: ").append(toIndentedString(newNsFlavourId)).append("\n");
		sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
