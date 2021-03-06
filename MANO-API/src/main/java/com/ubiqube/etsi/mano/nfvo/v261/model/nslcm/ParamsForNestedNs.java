package com.ubiqube.etsi.mano.nfvo.v261.model.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.model.KeyValuePairs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type specifies additional parameters on a per-nested NS instance basis.
 * It shall comply with the provisions defined in Table 6.5.3.21a-1.
 */
@ApiModel(description = "This type specifies additional parameters on a per-nested NS instance basis.  It shall comply with the provisions defined in Table 6.5.3.21a-1. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-07T10:02:43.347+02:00")

public class ParamsForNestedNs {
	@JsonProperty("nsProfileId")
	private String nsProfileId = null;

	@JsonProperty("additionalParam")
	@Valid
	private List<KeyValuePairs> additionalParam = null;

	public ParamsForNestedNs nsProfileId(final String nsProfileId) {
		this.nsProfileId = nsProfileId;
		return this;
	}

	/**
	 * Identifier of a NsProfile to which the additional parameters apply.
	 *
	 * @return nsProfileId
	 **/
	@ApiModelProperty(required = true, value = "Identifier of a NsProfile to which the additional parameters apply. ")
	@NotNull

	public String getNsProfileId() {
		return nsProfileId;
	}

	public void setNsProfileId(final String nsProfileId) {
		this.nsProfileId = nsProfileId;
	}

	public ParamsForNestedNs additionalParam(final List<KeyValuePairs> additionalParam) {
		this.additionalParam = additionalParam;
		return this;
	}

	public ParamsForNestedNs addAdditionalParamItem(final KeyValuePairs additionalParamItem) {
		if (this.additionalParam == null) {
			this.additionalParam = new ArrayList<>();
		}
		this.additionalParam.add(additionalParamItem);
		return this;
	}

	/**
	 * Additional parameters that are to be applied on a per nested NS instance.
	 *
	 * @return additionalParam
	 **/
	@ApiModelProperty(value = "Additional parameters that are to be applied on a per nested NS instance. ")

	@Valid

	public List<KeyValuePairs> getAdditionalParam() {
		return additionalParam;
	}

	public void setAdditionalParam(final List<KeyValuePairs> additionalParam) {
		this.additionalParam = additionalParam;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ParamsForNestedNs paramsForNestedNs = (ParamsForNestedNs) o;
		return Objects.equals(this.nsProfileId, paramsForNestedNs.nsProfileId) &&
				Objects.equals(this.additionalParam, paramsForNestedNs.additionalParam);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nsProfileId, additionalParam);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ParamsForNestedNs {\n");

		sb.append("    nsProfileId: ").append(toIndentedString(nsProfileId)).append("\n");
		sb.append("    additionalParam: ").append(toIndentedString(additionalParam)).append("\n");
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
