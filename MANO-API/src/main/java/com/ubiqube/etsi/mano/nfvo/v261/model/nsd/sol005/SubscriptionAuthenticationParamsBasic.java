package com.ubiqube.etsi.mano.nfvo.v261.model.nsd.sol005;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Parameters for authentication/authorization using BASIC. Shall be present if
 * authType is \&quot;BASIC\&quot; and the contained information has not been
 * provisioned out of band. Shall be absent otherwise.
 */
@ApiModel(description = "Parameters for authentication/authorization using BASIC. Shall be present if authType is \"BASIC\" and the contained information has not been provisioned out of band. Shall be absent otherwise. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-25T16:34:13.188+01:00")

public class SubscriptionAuthenticationParamsBasic {
	@JsonProperty("userName")
	private String userName = null;

	@JsonProperty("password")
	private String password = null;

	public SubscriptionAuthenticationParamsBasic userName(final String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * Username to be used in HTTP Basic authentication. Shall be present if it has
	 * not been provisioned out of band.
	 * 
	 * @return userName
	 **/
	@ApiModelProperty(value = "Username to be used in HTTP Basic authentication. Shall be present if it has not been provisioned out of band. ")

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public SubscriptionAuthenticationParamsBasic password(final String password) {
		this.password = password;
		return this;
	}

	/**
	 * Password to be used in HTTP Basic authentication. Shall be present if it has
	 * not been provisioned out of band.
	 * 
	 * @return password
	 **/
	@ApiModelProperty(value = "Password to be used in HTTP Basic authentication. Shall be present if it has not been provisioned out of band. ")

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final SubscriptionAuthenticationParamsBasic subscriptionAuthenticationParamsBasic = (SubscriptionAuthenticationParamsBasic) o;
		return Objects.equals(this.userName, subscriptionAuthenticationParamsBasic.userName) &&
				Objects.equals(this.password, subscriptionAuthenticationParamsBasic.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName, password);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SubscriptionAuthenticationParamsBasic {\n");

		sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
