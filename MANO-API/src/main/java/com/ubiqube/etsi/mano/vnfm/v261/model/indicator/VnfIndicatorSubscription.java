package com.ubiqube.etsi.mano.vnfm.v261.model.indicator;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This type represents a subscription related to notifications about VNF
 * indicator value changes.
 */
@ApiModel(description = "This type represents a subscription related to notifications about VNF indicator value changes. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-01T15:58:19.438+02:00")

public class VnfIndicatorSubscription {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("filter")
	private VnfIndicatorNotificationsFilter filter = null;

	@JsonProperty("callbackUri")
	private String callbackUri = null;

	@JsonProperty("_links")
	private VnfIndicatorSubscriptionLinks links = null;

	public VnfIndicatorSubscription id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of this \"Individual subscription\" resource.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "Identifier of this \"Individual subscription\" resource. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public VnfIndicatorSubscription filter(final VnfIndicatorNotificationsFilter filter) {
		this.filter = filter;
		return this;
	}

	/**
	 * Filter settings for this subscription, to define the subset of all
	 * notifications this subscription relates to. A particular notification is sent
	 * to the subscriber if the filter matches, or if there is no filter.
	 * 
	 * @return filter
	 **/
	@ApiModelProperty(value = "Filter settings for this subscription, to define the subset of all notifications this subscription relates to. A particular notification is sent to the subscriber if the filter matches, or if there is no filter. ")

	@Valid

	public VnfIndicatorNotificationsFilter getFilter() {
		return filter;
	}

	public void setFilter(final VnfIndicatorNotificationsFilter filter) {
		this.filter = filter;
	}

	public VnfIndicatorSubscription callbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
		return this;
	}

	/**
	 * The URI of the endpoint to send the notification to.
	 * 
	 * @return callbackUri
	 **/
	@ApiModelProperty(required = true, value = "The URI of the endpoint to send the notification to. ")
	@NotNull

	public String getCallbackUri() {
		return callbackUri;
	}

	public void setCallbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
	}

	public VnfIndicatorSubscription links(final VnfIndicatorSubscriptionLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 * 
	 * @return links
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public VnfIndicatorSubscriptionLinks getLinks() {
		return links;
	}

	public void setLinks(final VnfIndicatorSubscriptionLinks links) {
		this.links = links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfIndicatorSubscription vnfIndicatorSubscription = (VnfIndicatorSubscription) o;
		return Objects.equals(this.id, vnfIndicatorSubscription.id) &&
				Objects.equals(this.filter, vnfIndicatorSubscription.filter) &&
				Objects.equals(this.callbackUri, vnfIndicatorSubscription.callbackUri) &&
				Objects.equals(this.links, vnfIndicatorSubscription.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, filter, callbackUri, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfIndicatorSubscription {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
		sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
		sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
