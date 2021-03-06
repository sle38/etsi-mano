/*
 * SOL003 - VNF Lifecycle Management interface
 * SOL003 - VNF Lifecycle Management interface definition  IMPORTANT: Please note that this file might be not aligned to the current version of the ETSI Group Specification it refers to. In case of discrepancies the published ETSI Group Specification takes precedence.  In clause 4.3.2 of ETSI GS NFV-SOL 003 v2.4.1, an attribute-based filtering mechanism is defined. This mechanism is currently not included in the corresponding OpenAPI design for this GS version. Changes to the attribute-based filtering mechanism are being considered in v2.5.1 of this GS for inclusion in the corresponding future ETSI NFV OpenAPI design. Please report bugs to https://forge.etsi.org/bugzilla/buglist.cgi?component=Nfv-Openapis&list_id=61&product=NFV&resolution=
 *
 * OpenAPI spec version: 1.1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.ubiqube.etsi.mano.vnfm.v261.model.nslcm;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.model.KeyValuePairs;

import io.swagger.annotations.ApiModelProperty;

/**
 * ScaleVnfRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-13T10:04:39.223+02:00")
public class ScaleVnfRequest {
	/**
	 * Indicates the type of the scale operation requested. Permitted values: *
	 * SCALE_OUT: adding additional VNFC instances to the VNF to increase capacity *
	 * SCALE_IN: removing VNFC instances from the VNF in order to release unused
	 * capacity.
	 */
	public enum TypeEnum {
		OUT("SCALE_OUT"),

		IN("SCALE_IN");

		private final String value;

		TypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(final String text) {
			for (final TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("type")
	private TypeEnum type = null;

	@JsonProperty("aspectId")
	private String aspectId = null;

	@JsonProperty("numberOfSteps")
	private Integer numberOfSteps = null;

	@JsonProperty("additionalParams")
	private KeyValuePairs additionalParams = null;

	public ScaleVnfRequest type(final TypeEnum type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the type of the scale operation requested. Permitted values: *
	 * SCALE_OUT: adding additional VNFC instances to the VNF to increase capacity *
	 * SCALE_IN: removing VNFC instances from the VNF in order to release unused
	 * capacity.
	 *
	 * @return type
	 **/
	@JsonProperty("type")
	@ApiModelProperty(required = true, value = "Indicates the type of the scale operation requested. Permitted values: * SCALE_OUT: adding additional VNFC instances to the VNF to increase   capacity * SCALE_IN: removing VNFC instances from the VNF in order to release   unused capacity. ")
	@NotNull
	public TypeEnum getType() {
		return type;
	}

	public void setType(final TypeEnum type) {
		this.type = type;
	}

	public ScaleVnfRequest aspectId(final String aspectId) {
		this.aspectId = aspectId;
		return this;
	}

	/**
	 * Identifier of the scaling aspect.
	 *
	 * @return aspectId
	 **/
	@JsonProperty("aspectId")
	@ApiModelProperty(required = true, value = "Identifier of the scaling aspect. ")
	@NotNull
	public String getAspectId() {
		return aspectId;
	}

	public void setAspectId(final String aspectId) {
		this.aspectId = aspectId;
	}

	public ScaleVnfRequest numberOfSteps(final Integer numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
		return this;
	}

	/**
	 * Number of scaling steps to be executed as part of this Scale VNF operation.
	 * It shall be a positive number and the default value shall be 1.
	 *
	 * @return numberOfSteps
	 **/
	@JsonProperty("numberOfSteps")
	@ApiModelProperty(value = "Number of scaling steps to be executed as part of this Scale VNF operation. It shall be a positive number and the default value shall be 1. ")
	public Integer getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(final Integer numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public ScaleVnfRequest additionalParams(final KeyValuePairs additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	/**
	 * Additional parameters passed by the NFVO as input to the scaling process,
	 * specific to the VNF being scaled, as declared in the VNFD as part of
	 * \&quot;ScaleVnfOpConfig\&quot;.
	 *
	 * @return additionalParams
	 **/
	@JsonProperty("additionalParams")
	@ApiModelProperty(value = "Additional parameters passed by the NFVO as input to the scaling process, specific to the VNF being scaled, as declared in the VNFD as part of \"ScaleVnfOpConfig\". ")
	public KeyValuePairs getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final KeyValuePairs additionalParams) {
		this.additionalParams = additionalParams;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ScaleVnfRequest {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    aspectId: ").append(toIndentedString(aspectId)).append("\n");
		sb.append("    numberOfSteps: ").append(toIndentedString(numberOfSteps)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
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
