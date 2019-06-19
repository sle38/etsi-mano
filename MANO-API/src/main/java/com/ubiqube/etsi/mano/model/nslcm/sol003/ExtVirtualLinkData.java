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

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type represents an external VL.
 */
@ApiModel(description = "This type represents an external VL. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-13T10:04:39.223+02:00")
public class ExtVirtualLinkData {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("vimConnectionId")
	private String vimConnectionId = null;

	@JsonProperty("resourceProviderId")
	private String resourceProviderId = null;

	@JsonProperty("resourceId")
	private String resourceId = null;

	@JsonProperty("extCps")
	private List<VnfExtCpData> extCps = new ArrayList<VnfExtCpData>();

	@JsonProperty("extLinkPorts")
	private List<ExtLinkPortData> extLinkPorts = null;

	public ExtVirtualLinkData id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * The identifier of the external VL instance. The identifier is assigned by the
	 * NFV-MANO entity that manages this VL instance.
	 * 
	 * @return id
	 **/
	@JsonProperty("id")
	@ApiModelProperty(required = true, value = "The identifier of the external VL instance. The identifier is assigned by the NFV-MANO entity that manages this VL instance. ")
	@NotNull
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ExtVirtualLinkData vimConnectionId(String vimConnectionId) {
		this.vimConnectionId = vimConnectionId;
		return this;
	}

	/**
	 * Identifier of the VIM connection to manage this resource. This attribute
	 * shall only be supported and present if VNF-related resource management in
	 * direct mode is applicable.
	 * 
	 * @return vimConnectionId
	 **/
	@JsonProperty("vimConnectionId")
	@ApiModelProperty(value = "Identifier of the VIM connection to manage this resource. This attribute shall only be supported and present if VNF-related resource management in direct mode is applicable. ")
	public String getVimConnectionId() {
		return vimConnectionId;
	}

	public void setVimConnectionId(String vimConnectionId) {
		this.vimConnectionId = vimConnectionId;
	}

	public ExtVirtualLinkData resourceProviderId(String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
		return this;
	}

	/**
	 * Identifies the entity responsible for the management of this resource. This
	 * attribute shall only be supported and present if VNF-related resource
	 * management in indirect mode is applicable. The identification scheme is
	 * outside the scope of the present document.
	 * 
	 * @return resourceProviderId
	 **/
	@JsonProperty("resourceProviderId")
	@ApiModelProperty(value = "Identifies the entity responsible for the management of this resource. This attribute shall only be supported and present if VNF-related resource management in indirect mode is applicable. The identification scheme is outside the scope of the present document. ")
	public String getResourceProviderId() {
		return resourceProviderId;
	}

	public void setResourceProviderId(String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
	}

	public ExtVirtualLinkData resourceId(String resourceId) {
		this.resourceId = resourceId;
		return this;
	}

	/**
	 * The identifier of the resource in the scope of the VIM or the resource
	 * provider.
	 * 
	 * @return resourceId
	 **/
	@JsonProperty("resourceId")
	@ApiModelProperty(required = true, value = "The identifier of the resource in the scope of the VIM or the resource provider. ")
	@NotNull
	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public ExtVirtualLinkData extCps(List<VnfExtCpData> extCps) {
		this.extCps = extCps;
		return this;
	}

	public ExtVirtualLinkData addExtCpsItem(VnfExtCpData extCpsItem) {
		this.extCps.add(extCpsItem);
		return this;
	}

	/**
	 * External CPs of the VNF to be connected to this external VL.
	 * 
	 * @return extCps
	 **/
	@JsonProperty("extCps")
	@ApiModelProperty(required = true, value = "External CPs of the VNF to be connected to this external VL. ")
	@NotNull
	public List<VnfExtCpData> getExtCps() {
		return extCps;
	}

	public void setExtCps(List<VnfExtCpData> extCps) {
		this.extCps = extCps;
	}

	public ExtVirtualLinkData extLinkPorts(List<ExtLinkPortData> extLinkPorts) {
		this.extLinkPorts = extLinkPorts;
		return this;
	}

	public ExtVirtualLinkData addExtLinkPortsItem(ExtLinkPortData extLinkPortsItem) {
		if (this.extLinkPorts == null) {
			this.extLinkPorts = new ArrayList<ExtLinkPortData>();
		}
		this.extLinkPorts.add(extLinkPortsItem);
		return this;
	}

	/**
	 * Externally provided link ports to be used to connect external connection
	 * points to this external VL. If this attribute is not present, the VNFM shall
	 * create the link ports on the external VL.
	 * 
	 * @return extLinkPorts
	 **/
	@JsonProperty("extLinkPorts")
	@ApiModelProperty(value = "Externally provided link ports to be used to connect external connection points to this external VL. If this attribute is not present, the VNFM shall create the link ports on the external VL.  ")
	public List<ExtLinkPortData> getExtLinkPorts() {
		return extLinkPorts;
	}

	public void setExtLinkPorts(List<ExtLinkPortData> extLinkPorts) {
		this.extLinkPorts = extLinkPorts;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ExtVirtualLinkData {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    vimConnectionId: ").append(toIndentedString(vimConnectionId)).append("\n");
		sb.append("    resourceProviderId: ").append(toIndentedString(resourceProviderId)).append("\n");
		sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
		sb.append("    extCps: ").append(toIndentedString(extCps)).append("\n");
		sb.append("    extLinkPorts: ").append(toIndentedString(extLinkPorts)).append("\n");
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