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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type represents a VNF instance.
 */
@ApiModel(description = "This type represents a VNF instance. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-13T10:04:39.223+02:00")
public class VnfInstance {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("vnfInstanceName")
	private String vnfInstanceName = null;

	@JsonProperty("vnfInstanceDescription")
	private String vnfInstanceDescription = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("vnfProvider")
	private String vnfProvider = null;

	@JsonProperty("vnfProductName")
	private String vnfProductName = null;

	@JsonProperty("vnfSoftwareVersion")
	private String vnfSoftwareVersion = null;

	@JsonProperty("vnfdVersion")
	private String vnfdVersion = null;

	@JsonProperty("vnfPkgId")
	private String vnfPkgId = null;

	@JsonProperty("vnfConfigurableProperties")
	private KeyValuePairs vnfConfigurableProperties = null;

	@JsonProperty("vimConnectionInfo")
	private List<VimConnectionInfo> vimConnectionInfo = null;

	/**
	 * The instantiation state of the VNF.
	 */
	public enum InstantiationStateEnum {
		NOT_INSTANTIATED("NOT_INSTANTIATED"),

		INSTANTIATED("INSTANTIATED");

		private final String value;

		InstantiationStateEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static InstantiationStateEnum fromValue(String text) {
			for (final InstantiationStateEnum b : InstantiationStateEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("instantiationState")
	private InstantiationStateEnum instantiationState = null;

	@JsonProperty("instantiatedVnfInfo")
	private VnfInstanceInstantiatedVnfInfo instantiatedVnfInfo = null;

	@JsonProperty("metadata")
	private KeyValuePairs metadata = null;

	@JsonProperty("extensions")
	private KeyValuePairs extensions = null;

	@JsonProperty("_links")
	private VnfInstanceLinks links = null;

	public VnfInstance id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of the VNF instance.
	 * 
	 * @return id
	 **/
	@JsonProperty("id")
	@ApiModelProperty(required = true, value = "Identifier of the VNF instance. ")
	@NotNull
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VnfInstance vnfInstanceName(String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
		return this;
	}

	/**
	 * Name of the VNF instance. This attribute can be modified with the PATCH
	 * method.
	 * 
	 * @return vnfInstanceName
	 **/
	@JsonProperty("vnfInstanceName")
	@ApiModelProperty(value = "Name of the VNF instance. This attribute can be modified with the PATCH method. ")
	public String getVnfInstanceName() {
		return vnfInstanceName;
	}

	public void setVnfInstanceName(String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
	}

	public VnfInstance vnfInstanceDescription(String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
		return this;
	}

	/**
	 * Human-readable description of the VNF instance. This attribute can be
	 * modified with the PATCH method.
	 * 
	 * @return vnfInstanceDescription
	 **/
	@JsonProperty("vnfInstanceDescription")
	@ApiModelProperty(value = "Human-readable description of the VNF instance. This attribute can be modified with the PATCH method. ")
	public String getVnfInstanceDescription() {
		return vnfInstanceDescription;
	}

	public void setVnfInstanceDescription(String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
	}

	public VnfInstance vnfdId(String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * Identifier of the VNFD on which the VNF instance is based.
	 * 
	 * @return vnfdId
	 **/
	@JsonProperty("vnfdId")
	@ApiModelProperty(required = true, value = "Identifier of the VNFD on which the VNF instance is based. ")
	@NotNull
	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfInstance vnfProvider(String vnfProvider) {
		this.vnfProvider = vnfProvider;
		return this;
	}

	/**
	 * Provider of the VNF and the VNFD. The value is copied from the VNFD.
	 * 
	 * @return vnfProvider
	 **/
	@JsonProperty("vnfProvider")
	@ApiModelProperty(required = true, value = "Provider of the VNF and the VNFD. The value is copied from the VNFD. ")
	@NotNull
	public String getVnfProvider() {
		return vnfProvider;
	}

	public void setVnfProvider(String vnfProvider) {
		this.vnfProvider = vnfProvider;
	}

	public VnfInstance vnfProductName(String vnfProductName) {
		this.vnfProductName = vnfProductName;
		return this;
	}

	/**
	 * Name to identify the VNF Product. The value is copied from the VNFD.
	 * 
	 * @return vnfProductName
	 **/
	@JsonProperty("vnfProductName")
	@ApiModelProperty(required = true, value = "Name to identify the VNF Product. The value is copied from the VNFD. ")
	@NotNull
	public String getVnfProductName() {
		return vnfProductName;
	}

	public void setVnfProductName(String vnfProductName) {
		this.vnfProductName = vnfProductName;
	}

	public VnfInstance vnfSoftwareVersion(String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		return this;
	}

	/**
	 * Software version of the VNF. The value is copied from the VNFD.
	 * 
	 * @return vnfSoftwareVersion
	 **/
	@JsonProperty("vnfSoftwareVersion")
	@ApiModelProperty(required = true, value = "Software version of the VNF. The value is copied from the VNFD. ")
	@NotNull
	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public VnfInstance vnfdVersion(String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
		return this;
	}

	/**
	 * Identifies the version of the VNFD. The value is copied from the VNFD.
	 * 
	 * @return vnfdVersion
	 **/
	@JsonProperty("vnfdVersion")
	@ApiModelProperty(required = true, value = "Identifies the version of the VNFD. The value is copied from the VNFD. ")
	@NotNull
	public String getVnfdVersion() {
		return vnfdVersion;
	}

	public void setVnfdVersion(String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
	}

	public VnfInstance vnfPkgId(String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
		return this;
	}

	/**
	 * Identifier of information held by the NFVO about the specific VNF package on
	 * which the VNF is based. This identifier was allocated by the NFVO. This
	 * attribute can be modified with the PATCH method. Modifying the value of this
	 * attribute shall not be performed when conflicts exist between the previous
	 * and the newly referred VNF package, i.e. when the new VNFD is not changed
	 * with respect to the previous VNFD apart from referencing to other VNF
	 * software images. In order to avoid misalignment of the VnfInstance with the
	 * current VNF&#39;s on-boarded VNF Package, the values of attributes in the
	 * VnfInstance that have corresponding attributes in the VNFD shall be kept in
	 * sync with the values in the VNFD.
	 * 
	 * @return vnfPkgId
	 **/
	@JsonProperty("vnfPkgId")
	@ApiModelProperty(required = true, value = "Identifier of information held by the NFVO about the specific VNF package on which the VNF is based. This identifier was allocated by the NFVO. This attribute can be modified with the PATCH method. Modifying the value of this attribute shall not be performed when conflicts exist between the previous and the newly referred VNF package, i.e. when the new VNFD is not changed with respect to the previous VNFD apart from referencing to other VNF software images. In order to avoid misalignment of the VnfInstance with the current VNF's on-boarded VNF Package, the values of attributes in the VnfInstance that have corresponding attributes in the VNFD shall be kept in sync with the values in the VNFD. ")
	@NotNull
	public String getVnfPkgId() {
		return vnfPkgId;
	}

	public void setVnfPkgId(String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
	}

	public VnfInstance vnfConfigurableProperties(KeyValuePairs vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
		return this;
	}

	/**
	 * Current values of the configurable properties of the VNF instance.
	 * Configurable properties referred in this attribute are declared in the VNFD.
	 * ETSI GS NFV-SOL 001 specifies the structure and format of the VNFD based on
	 * TOSCA specifications. VNF configurable properties are sometimes also referred
	 * to as configuration parameters applicable to a VNF. Some of these are set
	 * prior to instantiation and cannot be modified if the VNF is instantiated,
	 * some are set prior to instantiation (are part of initial configuration) and
	 * can be modified later, and others can be set only after instantiation. The
	 * applicability of certain configuration may depend on the VNF and the required
	 * operation of the VNF at a certain point in time. These configurable
	 * properties include the following standard attributes, which are declared in
	 * the VNFD if auto-scaling and/or auto-healing are supported by the VNF: *
	 * isAutoscaleEnabled: If present, the VNF supports auto-scaling. If set to
	 * true, auto-scaling is currently enabled. If set to false, auto-scaling is
	 * currently disabled. * isAutohealEnabled: If present, the VNF supports
	 * auto-healing. If set to true, auto-healing is currently enabled. If set to
	 * false, auto-healing is currently disabled. This attribute can be modified
	 * with the PATCH method.
	 * 
	 * @return vnfConfigurableProperties
	 **/
	@JsonProperty("vnfConfigurableProperties")
	@ApiModelProperty(value = "Current values of the configurable properties of the VNF instance.  Configurable properties referred in this attribute are declared in the VNFD. ETSI GS NFV-SOL 001 specifies the structure and format of the VNFD based on TOSCA specifications. VNF configurable properties are sometimes also referred to as configuration parameters applicable to a VNF. Some of these are set prior to instantiation and cannot be modified if the VNF is instantiated, some are set prior to instantiation (are part of initial configuration) and can be modified later, and others can be set only after instantiation. The applicability of certain configuration may depend on the VNF and the required operation of the VNF at a certain point in time. These configurable properties include the following standard attributes, which are declared in the VNFD if auto-scaling and/or auto-healing are supported by the VNF:  * isAutoscaleEnabled: If present, the VNF supports auto-scaling. If   set to true, auto-scaling is currently enabled. If set to false,   auto-scaling is currently disabled.  * isAutohealEnabled: If present, the VNF supports auto-healing. If   set to true, auto-healing is currently enabled. If set to false,   auto-healing is currently disabled.  This attribute can be modified with the PATCH method. ")
	public KeyValuePairs getVnfConfigurableProperties() {
		return vnfConfigurableProperties;
	}

	public void setVnfConfigurableProperties(KeyValuePairs vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
	}

	public VnfInstance vimConnectionInfo(List<VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
		return this;
	}

	public VnfInstance addVimConnectionInfoItem(VimConnectionInfo vimConnectionInfoItem) {
		if (this.vimConnectionInfo == null) {
			this.vimConnectionInfo = new ArrayList<VimConnectionInfo>();
		}
		this.vimConnectionInfo.add(vimConnectionInfoItem);
		return this;
	}

	/**
	 * Information about VIM connections to be used for managing the resources for
	 * the VNF instance. This attribute shall only be supported and present if
	 * VNF-related resource management in direct mode is applicable. This attribute
	 * can be modified with the PATCH method.
	 * 
	 * @return vimConnectionInfo
	 **/
	@JsonProperty("vimConnectionInfo")
	@ApiModelProperty(value = "Information about VIM connections to be used for managing the resources for the VNF instance. This attribute shall only be supported and present if VNF-related resource management in direct mode is applicable. This attribute can be modified with the PATCH method. ")
	public List<VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(List<VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	public VnfInstance instantiationState(InstantiationStateEnum instantiationState) {
		this.instantiationState = instantiationState;
		return this;
	}

	/**
	 * The instantiation state of the VNF.
	 * 
	 * @return instantiationState
	 **/
	@JsonProperty("instantiationState")
	@ApiModelProperty(required = true, value = "The instantiation state of the VNF. ")
	@NotNull
	public InstantiationStateEnum getInstantiationState() {
		return instantiationState;
	}

	public void setInstantiationState(InstantiationStateEnum instantiationState) {
		this.instantiationState = instantiationState;
	}

	public VnfInstance instantiatedVnfInfo(VnfInstanceInstantiatedVnfInfo instantiatedVnfInfo) {
		this.instantiatedVnfInfo = instantiatedVnfInfo;
		return this;
	}

	/**
	 * Get instantiatedVnfInfo
	 * 
	 * @return instantiatedVnfInfo
	 **/
	@JsonProperty("instantiatedVnfInfo")
	@ApiModelProperty(value = "")
	public VnfInstanceInstantiatedVnfInfo getInstantiatedVnfInfo() {
		return instantiatedVnfInfo;
	}

	public void setInstantiatedVnfInfo(VnfInstanceInstantiatedVnfInfo instantiatedVnfInfo) {
		this.instantiatedVnfInfo = instantiatedVnfInfo;
	}

	public VnfInstance metadata(KeyValuePairs metadata) {
		this.metadata = metadata;
		return this;
	}

	/**
	 * Additional VNF-specific metadata describing the VNF instance. Metadata that
	 * are writeable are declared in the VNFD. This attribute can be modified with
	 * the PATCH method.
	 * 
	 * @return metadata
	 **/
	@JsonProperty("metadata")
	@ApiModelProperty(value = "Additional VNF-specific metadata describing the VNF instance. Metadata that are writeable are declared in the VNFD. This attribute can be modified with the PATCH method. ")
	public KeyValuePairs getMetadata() {
		return metadata;
	}

	public void setMetadata(KeyValuePairs metadata) {
		this.metadata = metadata;
	}

	public VnfInstance extensions(KeyValuePairs extensions) {
		this.extensions = extensions;
		return this;
	}

	/**
	 * VNF-specific attributes that affect the lifecycle management of this VNF
	 * instance by the VNFM, or the lifecycle management scripts. Extensions that
	 * are writeable are declared in the VNFD. This attribute can be modified with
	 * the PATCH method.
	 * 
	 * @return extensions
	 **/
	@JsonProperty("extensions")
	@ApiModelProperty(value = "VNF-specific attributes that affect the lifecycle management of this VNF instance by the VNFM, or the lifecycle management scripts. Extensions that are writeable are declared in the VNFD. This attribute can be modified with the PATCH method. ")
	public KeyValuePairs getExtensions() {
		return extensions;
	}

	public void setExtensions(KeyValuePairs extensions) {
		this.extensions = extensions;
	}

	public VnfInstance links(VnfInstanceLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 * 
	 * @return links
	 **/
	@JsonProperty("_links")
	@ApiModelProperty(value = "")
	public VnfInstanceLinks getLinks() {
		return links;
	}

	public void setLinks(VnfInstanceLinks links) {
		this.links = links;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfInstance {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    vnfInstanceName: ").append(toIndentedString(vnfInstanceName)).append("\n");
		sb.append("    vnfInstanceDescription: ").append(toIndentedString(vnfInstanceDescription)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfProvider: ").append(toIndentedString(vnfProvider)).append("\n");
		sb.append("    vnfProductName: ").append(toIndentedString(vnfProductName)).append("\n");
		sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
		sb.append("    vnfdVersion: ").append(toIndentedString(vnfdVersion)).append("\n");
		sb.append("    vnfPkgId: ").append(toIndentedString(vnfPkgId)).append("\n");
		sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
		sb.append("    vimConnectionInfo: ").append(toIndentedString(vimConnectionInfo)).append("\n");
		sb.append("    instantiationState: ").append(toIndentedString(instantiationState)).append("\n");
		sb.append("    instantiatedVnfInfo: ").append(toIndentedString(instantiatedVnfInfo)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
