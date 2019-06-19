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

package com.ubiqube.etsi.mano.model.nslcm.sol003;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Links to resources related to this resource.
 */
@ApiModel(description = "Links to resources related to this resource. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-13T10:04:39.223+02:00")
public class VnfInstanceLinks {
	@JsonProperty("self")
	private Link self = null;

	@JsonProperty("indicators")
	private Link indicators = null;

	@JsonProperty("instantiate")
	private Link instantiate = null;

	@JsonProperty("terminate")
	private Link terminate = null;

	@JsonProperty("scale")
	private Link scale = null;

	@JsonProperty("scaleToLevel")
	private Link scaleToLevel = null;

	@JsonProperty("changeFlavour")
	private Link changeFlavour = null;

	@JsonProperty("heal")
	private Link heal = null;

	@JsonProperty("operate")
	private Link operate = null;

	@JsonProperty("changeExtConn")
	private Link changeExtConn = null;

	public VnfInstanceLinks self(Link self) {
		this.self = self;
		return this;
	}

	/**
	 * URI of this resource.
	 * 
	 * @return self
	 **/
	@JsonProperty("self")
	@ApiModelProperty(required = true, value = "URI of this resource.")
	@NotNull
	public Link getSelf() {
		return self;
	}

	public void setSelf(Link self) {
		this.self = self;
	}

	public VnfInstanceLinks indicators(Link indicators) {
		this.indicators = indicators;
		return this;
	}

	/**
	 * Indicators related to this VNF instance, if applicable.
	 * 
	 * @return indicators
	 **/
	@JsonProperty("indicators")
	@ApiModelProperty(value = "Indicators related to this VNF instance, if applicable.")
	public Link getIndicators() {
		return indicators;
	}

	public void setIndicators(Link indicators) {
		this.indicators = indicators;
	}

	public VnfInstanceLinks instantiate(Link instantiate) {
		this.instantiate = instantiate;
		return this;
	}

	/**
	 * Link to the \&quot;instantiate\&quot; task resource, if the related operation
	 * is possible based on the current status of this VNF instance resource (i.e.
	 * VNF instance in NOT_INSTANTIATED state).
	 * 
	 * @return instantiate
	 **/
	@JsonProperty("instantiate")
	@ApiModelProperty(value = "Link to the \"instantiate\" task resource, if the related operation is possible based on the current status of this VNF instance resource (i.e. VNF instance in NOT_INSTANTIATED state). ")
	public Link getInstantiate() {
		return instantiate;
	}

	public void setInstantiate(Link instantiate) {
		this.instantiate = instantiate;
	}

	public VnfInstanceLinks terminate(Link terminate) {
		this.terminate = terminate;
		return this;
	}

	/**
	 * Link to the \&quot;terminate\&quot; task resource, if the related operation
	 * is possible based on the current status of this VNF instance resource (i.e.
	 * VNF instance is in INSTANTIATED state).
	 * 
	 * @return terminate
	 **/
	@JsonProperty("terminate")
	@ApiModelProperty(value = "Link to the \"terminate\" task resource, if the related operation is possible based on the current status of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state). ")
	public Link getTerminate() {
		return terminate;
	}

	public void setTerminate(Link terminate) {
		this.terminate = terminate;
	}

	public VnfInstanceLinks scale(Link scale) {
		this.scale = scale;
		return this;
	}

	/**
	 * Link to the \&quot;scale\&quot; task resource, if the related operation is
	 * supported for this VNF instance, and is possible based on the current status
	 * of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state).
	 * 
	 * @return scale
	 **/
	@JsonProperty("scale")
	@ApiModelProperty(value = "Link to the \"scale\" task resource, if the related operation is supported for this VNF instance, and is possible based on the current status of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state). ")
	public Link getScale() {
		return scale;
	}

	public void setScale(Link scale) {
		this.scale = scale;
	}

	public VnfInstanceLinks scaleToLevel(Link scaleToLevel) {
		this.scaleToLevel = scaleToLevel;
		return this;
	}

	/**
	 * Link to the \&quot;scale_to_level\&quot; task resource, if the related
	 * operation is supported for this VNF instance, and is possible based on the
	 * current status of this VNF instance resource (i.e. VNF instance is in
	 * INSTANTIATED state).
	 * 
	 * @return scaleToLevel
	 **/
	@JsonProperty("scaleToLevel")
	@ApiModelProperty(value = "Link to the \"scale_to_level\" task resource, if the related operation is supported for this VNF instance, and is possible based on the current status of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state). ")
	public Link getScaleToLevel() {
		return scaleToLevel;
	}

	public void setScaleToLevel(Link scaleToLevel) {
		this.scaleToLevel = scaleToLevel;
	}

	public VnfInstanceLinks changeFlavour(Link changeFlavour) {
		this.changeFlavour = changeFlavour;
		return this;
	}

	/**
	 * Link to the \&quot;change_flavour\&quot; task resource, if the related
	 * operation is supported for this VNF instance, and is possible based on the
	 * current status of this VNF instance resource (i.e. VNF instance is in
	 * INSTANTIATED state).
	 * 
	 * @return changeFlavour
	 **/
	@JsonProperty("changeFlavour")
	@ApiModelProperty(value = "Link to the \"change_flavour\" task resource, if the related operation is supported for this VNF instance, and is possible based on the current status of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state). ")
	public Link getChangeFlavour() {
		return changeFlavour;
	}

	public void setChangeFlavour(Link changeFlavour) {
		this.changeFlavour = changeFlavour;
	}

	public VnfInstanceLinks heal(Link heal) {
		this.heal = heal;
		return this;
	}

	/**
	 * Link to the \&quot;heal\&quot; task resource, if the related operation is
	 * supported for this VNF instance, and is possible based on the current status
	 * of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state).
	 * 
	 * @return heal
	 **/
	@JsonProperty("heal")
	@ApiModelProperty(value = "Link to the \"heal\" task resource, if the related operation is supported for this VNF instance, and is possible based on the current status of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state). ")
	public Link getHeal() {
		return heal;
	}

	public void setHeal(Link heal) {
		this.heal = heal;
	}

	public VnfInstanceLinks operate(Link operate) {
		this.operate = operate;
		return this;
	}

	/**
	 * Link to the \&quot;operate\&quot; task resource, if the related operation is
	 * supported for this VNF instance, and is possible based on the current status
	 * of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state).
	 * 
	 * @return operate
	 **/
	@JsonProperty("operate")
	@ApiModelProperty(value = "Link to the \"operate\" task resource, if the related operation is supported for this VNF instance, and is possible based on the current status of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state). ")
	public Link getOperate() {
		return operate;
	}

	public void setOperate(Link operate) {
		this.operate = operate;
	}

	public VnfInstanceLinks changeExtConn(Link changeExtConn) {
		this.changeExtConn = changeExtConn;
		return this;
	}

	/**
	 * Link to the \&quot;change_ext_conn\&quot; task resource, if the related
	 * operation is possible based on the current status of this VNF instance
	 * resource (i.e. VNF instance is in INSTANTIATED state).
	 * 
	 * @return changeExtConn
	 **/
	@JsonProperty("changeExtConn")
	@ApiModelProperty(value = "Link to the \"change_ext_conn\" task resource, if the related operation is possible based on the current status of this VNF instance resource (i.e. VNF instance is in INSTANTIATED state). ")
	public Link getChangeExtConn() {
		return changeExtConn;
	}

	public void setChangeExtConn(Link changeExtConn) {
		this.changeExtConn = changeExtConn;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfInstanceLinks {\n");

		sb.append("    self: ").append(toIndentedString(self)).append("\n");
		sb.append("    indicators: ").append(toIndentedString(indicators)).append("\n");
		sb.append("    instantiate: ").append(toIndentedString(instantiate)).append("\n");
		sb.append("    terminate: ").append(toIndentedString(terminate)).append("\n");
		sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
		sb.append("    scaleToLevel: ").append(toIndentedString(scaleToLevel)).append("\n");
		sb.append("    changeFlavour: ").append(toIndentedString(changeFlavour)).append("\n");
		sb.append("    heal: ").append(toIndentedString(heal)).append("\n");
		sb.append("    operate: ").append(toIndentedString(operate)).append("\n");
		sb.append("    changeExtConn: ").append(toIndentedString(changeExtConn)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
