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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type represents attribute modifications that were performed on an
 * \&quot;Individual VNF instance\&quot; resource. The attributes that can be
 * included consist of those requested to be modified explicitly in the
 * \&quot;VnfInfoModificationRequest\&quot; data structure, and additional
 * attributes of the \&quot;VnfInstance\&quot; data structure that were modified
 * implicitly e.g. when modifying the referenced VNF package.
 */
@ApiModel(description = "This type represents attribute modifications that were performed on an \"Individual VNF instance\" resource. The attributes that can be included consist of those requested to be modified explicitly in the \"VnfInfoModificationRequest\" data structure, and additional attributes of the \"VnfInstance\" data structure that were modified implicitly e.g. when modifying the referenced VNF package. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-13T10:04:39.223+02:00")
public class VnfInfoModifications {
	@JsonProperty("vnfInstanceName")
	private String vnfInstanceName = null;

	@JsonProperty("vnfInstanceDescription")
	private String vnfInstanceDescription = null;

	@JsonProperty("vnfConfigurableProperties")
	private KeyValuePairs vnfConfigurableProperties = null;

	@JsonProperty("metadata")
	private KeyValuePairs metadata = null;

	@JsonProperty("extensions")
	private KeyValuePairs extensions = null;

	@JsonProperty("vimConnectionInfo")
	private List<VimConnectionInfo> vimConnectionInfo = null;

	@JsonProperty("vnfPkgId")
	private String vnfPkgId = null;

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

	public VnfInfoModifications vnfInstanceName(String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfInstanceName\&quot; attribute in \&quot;VnfInstance\&quot;.
	 * 
	 * @return vnfInstanceName
	 **/
	@JsonProperty("vnfInstanceName")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfInstanceName\" attribute in \"VnfInstance\". ")
	public String getVnfInstanceName() {
		return vnfInstanceName;
	}

	public void setVnfInstanceName(String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
	}

	public VnfInfoModifications vnfInstanceDescription(String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfInstanceDescription\&quot; attribute in \&quot;VnfInstance\&quot;.
	 * 
	 * @return vnfInstanceDescription
	 **/
	@JsonProperty("vnfInstanceDescription")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfInstanceDescription\" attribute in \"VnfInstance\". ")
	public String getVnfInstanceDescription() {
		return vnfInstanceDescription;
	}

	public void setVnfInstanceDescription(String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
	}

	public VnfInfoModifications vnfConfigurableProperties(KeyValuePairs vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfConfigurableProperties\&quot; attribute in
	 * \&quot;VnfInstance\&quot;.
	 * 
	 * @return vnfConfigurableProperties
	 **/
	@JsonProperty("vnfConfigurableProperties")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfConfigurableProperties\" attribute in \"VnfInstance\". ")
	public KeyValuePairs getVnfConfigurableProperties() {
		return vnfConfigurableProperties;
	}

	public void setVnfConfigurableProperties(KeyValuePairs vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
	}

	public VnfInfoModifications metadata(KeyValuePairs metadata) {
		this.metadata = metadata;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;metadata\&quot; attribute in \&quot;VnfInstance\&quot;.
	 * 
	 * @return metadata
	 **/
	@JsonProperty("metadata")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"metadata\" attribute in \"VnfInstance\". ")
	public KeyValuePairs getMetadata() {
		return metadata;
	}

	public void setMetadata(KeyValuePairs metadata) {
		this.metadata = metadata;
	}

	public VnfInfoModifications extensions(KeyValuePairs extensions) {
		this.extensions = extensions;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;extensions\&quot; attribute in \&quot;VnfInstance\&quot;.
	 * 
	 * @return extensions
	 **/
	@JsonProperty("extensions")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"extensions\" attribute in \"VnfInstance\". ")
	public KeyValuePairs getExtensions() {
		return extensions;
	}

	public void setExtensions(KeyValuePairs extensions) {
		this.extensions = extensions;
	}

	public VnfInfoModifications vimConnectionInfo(List<VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
		return this;
	}

	public VnfInfoModifications addVimConnectionInfoItem(VimConnectionInfo vimConnectionInfoItem) {
		if (this.vimConnectionInfo == null) {
			this.vimConnectionInfo = new ArrayList<VimConnectionInfo>();
		}
		this.vimConnectionInfo.add(vimConnectionInfoItem);
		return this;
	}

	/**
	 * If present, this attribute signals modifications of certain entries in the
	 * \&quot;vimConnectionInfo\&quot; attribute array in \&quot;VnfInstance\&quot;.
	 * 
	 * @return vimConnectionInfo
	 **/
	@JsonProperty("vimConnectionInfo")
	@ApiModelProperty(value = "If present, this attribute signals modifications of certain entries in the \"vimConnectionInfo\" attribute array in \"VnfInstance\". ")
	public List<VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(List<VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	public VnfInfoModifications vnfPkgId(String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfPkgId\&quot; attribute in \&quot;VnfInstance\&quot;.
	 * 
	 * @return vnfPkgId
	 **/
	@JsonProperty("vnfPkgId")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfPkgId\" attribute in \"VnfInstance\". ")
	public String getVnfPkgId() {
		return vnfPkgId;
	}

	public void setVnfPkgId(String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
	}

	public VnfInfoModifications vnfdId(String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \&quot;vnfdId\&quot;
	 * attribute in \&quot;VnfInstance\&quot;. If present, this attribute (which
	 * depends on the value of the \&quot;vnfPkgId\&quot; attribute) was modified
	 * implicitly following a request to modify the \&quot;vnfPkgId\&quot;
	 * attribute, by copying the value of this attribute from the VNFD in the VNF
	 * Package identified by the \&quot;vnfPkgId” attribute.
	 * 
	 * @return vnfdId
	 **/
	@JsonProperty("vnfdId")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfdId\" attribute in \"VnfInstance\".  If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")
	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfInfoModifications vnfProvider(String vnfProvider) {
		this.vnfProvider = vnfProvider;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfProvider\&quot; attribute in \&quot;VnfInstance\&quot;. If present,
	 * this attribute (which depends on the value of the \&quot;vnfPkgId\&quot;
	 * attribute) was modified implicitly following a request to modify the
	 * \&quot;vnfPkgId\&quot; attribute, by copying the value of this attribute from
	 * the VNFD in the VNF Package identified by the \&quot;vnfPkgId” attribute.
	 * 
	 * @return vnfProvider
	 **/
	@JsonProperty("vnfProvider")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfProvider\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")
	public String getVnfProvider() {
		return vnfProvider;
	}

	public void setVnfProvider(String vnfProvider) {
		this.vnfProvider = vnfProvider;
	}

	public VnfInfoModifications vnfProductName(String vnfProductName) {
		this.vnfProductName = vnfProductName;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfProductName\&quot; attribute in \&quot;VnfInstance\&quot;. If
	 * present, this attribute (which depends on the value of the
	 * \&quot;vnfPkgId\&quot; attribute) was modified implicitly following a request
	 * to modify the \&quot;vnfPkgId\&quot; attribute, by copying the value of this
	 * attribute from the VNFD in the VNF Package identified by the \&quot;vnfPkgId”
	 * attribute.
	 * 
	 * @return vnfProductName
	 **/
	@JsonProperty("vnfProductName")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfProductName\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")
	public String getVnfProductName() {
		return vnfProductName;
	}

	public void setVnfProductName(String vnfProductName) {
		this.vnfProductName = vnfProductName;
	}

	public VnfInfoModifications vnfSoftwareVersion(String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfSoftwareVersion\&quot; attribute in \&quot;VnfInstance\&quot;.
	 * 
	 * @return vnfSoftwareVersion
	 **/
	@JsonProperty("vnfSoftwareVersion")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfSoftwareVersion\" attribute in \"VnfInstance\".  ")
	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public VnfInfoModifications vnfdVersion(String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \&quot;vnfdVersion\&quot; attribute in \&quot;VnfInstance\&quot;. If present,
	 * this attribute (which depends on the value of the \&quot;vnfPkgId\&quot;
	 * attribute) was modified implicitly following a request to modify the
	 * \&quot;vnfPkgId\&quot; attribute, by copying the value of this attribute from
	 * the VNFD in the VNF Package identified by the \&quot;vnfPkgId” attribute.
	 * 
	 * @return vnfdVersion
	 **/
	@JsonProperty("vnfdVersion")
	@ApiModelProperty(value = "If present, this attribute signals modifications of the \"vnfdVersion\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")
	public String getVnfdVersion() {
		return vnfdVersion;
	}

	public void setVnfdVersion(String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfInfoModifications {\n");

		sb.append("    vnfInstanceName: ").append(toIndentedString(vnfInstanceName)).append("\n");
		sb.append("    vnfInstanceDescription: ").append(toIndentedString(vnfInstanceDescription)).append("\n");
		sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    vimConnectionInfo: ").append(toIndentedString(vimConnectionInfo)).append("\n");
		sb.append("    vnfPkgId: ").append(toIndentedString(vnfPkgId)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfProvider: ").append(toIndentedString(vnfProvider)).append("\n");
		sb.append("    vnfProductName: ").append(toIndentedString(vnfProductName)).append("\n");
		sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
		sb.append("    vnfdVersion: ").append(toIndentedString(vnfdVersion)).append("\n");
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
