package com.ubiqube.etsi.mano.model.nsperfo.sol003;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * VnfInstanceSubscriptionFilterVersions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-01T16:01:09.127+02:00")

public class VnfInstanceSubscriptionFilterVersions {
	@JsonProperty("vnfSoftwareVersion")
	private String vnfSoftwareVersion = null;

	@JsonProperty("vnfdVersions")
	@Valid
	private List<String> vnfdVersions = null;

	public VnfInstanceSubscriptionFilterVersions vnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		return this;
	}

	/**
	 * Software version to match.
	 * 
	 * @return vnfSoftwareVersion
	 **/
	@ApiModelProperty(required = true, value = "Software version to match. ")
	@NotNull

	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public VnfInstanceSubscriptionFilterVersions vnfdVersions(final List<String> vnfdVersions) {
		this.vnfdVersions = vnfdVersions;
		return this;
	}

	public VnfInstanceSubscriptionFilterVersions addVnfdVersionsItem(final String vnfdVersionsItem) {
		if (this.vnfdVersions == null) {
			this.vnfdVersions = new ArrayList<>();
		}
		this.vnfdVersions.add(vnfdVersionsItem);
		return this;
	}

	/**
	 * If present, match VNF instances that belong to VNF products with certain VNFD
	 * versions, a certain software version and a certain product name, from one
	 * particular provider.
	 * 
	 * @return vnfdVersions
	 **/
	@ApiModelProperty(value = "If present, match VNF instances that belong to VNF products with certain VNFD versions, a certain software version and a certain product name, from one particular provider. ")

	public List<String> getVnfdVersions() {
		return vnfdVersions;
	}

	public void setVnfdVersions(final List<String> vnfdVersions) {
		this.vnfdVersions = vnfdVersions;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfInstanceSubscriptionFilterVersions vnfInstanceSubscriptionFilterVersions = (VnfInstanceSubscriptionFilterVersions) o;
		return Objects.equals(this.vnfSoftwareVersion, vnfInstanceSubscriptionFilterVersions.vnfSoftwareVersion) &&
				Objects.equals(this.vnfdVersions, vnfInstanceSubscriptionFilterVersions.vnfdVersions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfSoftwareVersion, vnfdVersions);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfInstanceSubscriptionFilterVersions {\n");

		sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
		sb.append("    vnfdVersions: ").append(toIndentedString(vnfdVersions)).append("\n");
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