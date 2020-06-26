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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Parameters for authentication/authorization using OAUTH2_CLIENT_CREDENTIALS.
 * Shall be present if authType is \&quot;OAUTH2_CLIENT_CREDENTIALS\&quot; and
 * the contained information has not been provisioned out of band. Shall be
 * absent otherwise.
 */
@ApiModel(description = "Parameters for authentication/authorization using OAUTH2_CLIENT_CREDENTIALS. Shall be present if authType is \"OAUTH2_CLIENT_CREDENTIALS\" and the contained information has not been provisioned out of band. Shall be absent otherwise. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-13T10:04:39.223+02:00")
public class SubscriptionAuthenticationParamsOauth2ClientCredentials {
	@JsonProperty("clientId")
	private String clientId = null;

	@JsonProperty("clientPassword")
	private String clientPassword = null;

	@JsonProperty("tokenEndpoint")
	private String tokenEndpoint = null;

	public SubscriptionAuthenticationParamsOauth2ClientCredentials clientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	/**
	 * Client identifier to be used in the access token request of the OAuth 2.0
	 * client credentials grant type. Shall be present if it has not been
	 * provisioned out of band. The clientId and clientPassword passed in a
	 * subscription shall not be the same as the clientId and clientPassword that
	 * are used to obtain authorization for API requests. Client credentials may
	 * differ between subscriptions. The value of clientPassword should be generated
	 * by a random process.
	 * 
	 * @return clientId
	 **/
	@JsonProperty("clientId")
	@ApiModelProperty(value = "Client identifier to be used in the access token request of the OAuth 2.0 client credentials grant type.  Shall be present if it has not been provisioned out of band. The clientId and clientPassword passed in a subscription shall not be the same as the clientId and clientPassword that are used to obtain authorization for API requests. Client credentials may differ between subscriptions. The value of clientPassword should be generated by a random process. ")
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public SubscriptionAuthenticationParamsOauth2ClientCredentials clientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
		return this;
	}

	/**
	 * Client password to be used in the access token request of the OAuth 2.0
	 * client credentials grant type. Shall be present if it has not been
	 * provisioned out of band. The clientId and clientPassword passed in a
	 * subscription shall not be the same as the clientId and clientPassword that
	 * are used to obtain authorization for API requests. Client credentials may
	 * differ between subscriptions. The value of clientPassword should be generated
	 * by a random process.
	 * 
	 * @return clientPassword
	 **/
	@JsonProperty("clientPassword")
	@ApiModelProperty(value = "Client password to be used in the access token request of the OAuth 2.0 client credentials grant type.  Shall be present if it has not been provisioned out of band. The clientId and clientPassword passed in a subscription shall not be the same as the clientId and clientPassword that are used to obtain authorization for API requests. Client credentials may differ between subscriptions. The value of clientPassword should be generated by a random process. ")
	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public SubscriptionAuthenticationParamsOauth2ClientCredentials tokenEndpoint(String tokenEndpoint) {
		this.tokenEndpoint = tokenEndpoint;
		return this;
	}

	/**
	 * The token endpoint from which the access token can be obtained. Shall be
	 * present if it has not been provisioned out of band.
	 * 
	 * @return tokenEndpoint
	 **/
	@JsonProperty("tokenEndpoint")
	@ApiModelProperty(value = "The token endpoint from which the access token can be obtained. Shall be present if it has not been provisioned out of band. ")
	public String getTokenEndpoint() {
		return tokenEndpoint;
	}

	public void setTokenEndpoint(String tokenEndpoint) {
		this.tokenEndpoint = tokenEndpoint;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SubscriptionAuthenticationParamsOauth2ClientCredentials {\n");

		sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
		sb.append("    clientPassword: ").append(toIndentedString(clientPassword)).append("\n");
		sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
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