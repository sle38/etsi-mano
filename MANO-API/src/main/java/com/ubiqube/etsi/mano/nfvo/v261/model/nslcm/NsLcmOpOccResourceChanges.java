package com.ubiqube.etsi.mano.nfvo.v261.model.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This attribute contains information about the cumulative changes to
 * virtualised resources that were performed so far by the LCM operation since
 * its start, if applicable
 */
@ApiModel(description = "This attribute contains information about the cumulative changes to virtualised resources that were performed so far by the LCM operation since its start, if applicable ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-07T10:02:43.347+02:00")

public class NsLcmOpOccResourceChanges {
	@JsonProperty("affectedVnfs")
	@Valid
	private List<AffectedVnf> affectedVnfs = new ArrayList<>();

	@JsonProperty("affectedPnfs")
	@Valid
	private List<AffectedPnf> affectedPnfs = null;

	@JsonProperty("affectedVls")
	@Valid
	private List<AffectedVl> affectedVls = null;

	@JsonProperty("affectedVnffgs")
	@Valid
	private List<AffectedVnffg> affectedVnffgs = null;

	@JsonProperty("affectedNss")
	@Valid
	private List<AffectedNs> affectedNss = null;

	@JsonProperty("affectedSaps")
	@Valid
	private List<AffectedSap> affectedSaps = null;

	public NsLcmOpOccResourceChanges affectedVnfs(final List<AffectedVnf> affectedVnfs) {
		this.affectedVnfs = affectedVnfs;
		return this;
	}

	public NsLcmOpOccResourceChanges addAffectedVnfsItem(final AffectedVnf affectedVnfsItem) {
		if (this.affectedVnfs == null) {
			this.affectedVnfs = new ArrayList<>();
		}
		this.affectedVnfs.add(affectedVnfsItem);
		return this;
	}

	/**
	 * Information about the VNF instances that were affected during the lifecycle
	 * operation, if this notification represents the result of a lifecycle
	 * operation.
	 *
	 * @return affectedVnfs
	 **/
	@ApiModelProperty(value = "Information about the VNF instances that were affected during the lifecycle operation, if this notification represents the result of a lifecycle operation. ")

	@Valid

	public List<AffectedVnf> getAffectedVnfs() {
		return affectedVnfs;
	}

	public void setAffectedVnfs(final List<AffectedVnf> affectedVnfs) {
		this.affectedVnfs = affectedVnfs;
	}

	public NsLcmOpOccResourceChanges affectedPnfs(final List<AffectedPnf> affectedPnfs) {
		this.affectedPnfs = affectedPnfs;
		return this;
	}

	public NsLcmOpOccResourceChanges addAffectedPnfsItem(final AffectedPnf affectedPnfsItem) {
		if (this.affectedPnfs == null) {
			this.affectedPnfs = new ArrayList<>();
		}
		this.affectedPnfs.add(affectedPnfsItem);
		return this;
	}

	/**
	 * Information about the PNF instances that were affected during the lifecycle
	 * operation, if this notification represents the result of a lifecycle
	 * operation.
	 *
	 * @return affectedPnfs
	 **/
	@ApiModelProperty(value = "Information about the PNF instances that were affected during the lifecycle operation, if this notification represents the result of a lifecycle operation. ")

	@Valid

	public List<AffectedPnf> getAffectedPnfs() {
		return affectedPnfs;
	}

	public void setAffectedPnfs(final List<AffectedPnf> affectedPnfs) {
		this.affectedPnfs = affectedPnfs;
	}

	public NsLcmOpOccResourceChanges affectedVls(final List<AffectedVl> affectedVls) {
		this.affectedVls = affectedVls;
		return this;
	}

	public NsLcmOpOccResourceChanges addAffectedVlsItem(final AffectedVl affectedVlsItem) {
		if (this.affectedVls == null) {
			this.affectedVls = new ArrayList<>();
		}
		this.affectedVls.add(affectedVlsItem);
		return this;
	}

	/**
	 * Information about the VL instances that were affected during the lifecycle
	 * operation, if this notification represents the result of a lifecycle
	 * operation.
	 *
	 * @return affectedVls
	 **/
	@ApiModelProperty(value = "Information about the VL instances that were affected during the lifecycle operation, if this notification represents the result of a lifecycle operation. ")

	@Valid

	public List<AffectedVl> getAffectedVls() {
		return affectedVls;
	}

	public void setAffectedVls(final List<AffectedVl> affectedVls) {
		this.affectedVls = affectedVls;
	}

	public NsLcmOpOccResourceChanges affectedVnffgs(final List<AffectedVnffg> affectedVnffgs) {
		this.affectedVnffgs = affectedVnffgs;
		return this;
	}

	public NsLcmOpOccResourceChanges addAffectedVnffgsItem(final AffectedVnffg affectedVnffgsItem) {
		if (this.affectedVnffgs == null) {
			this.affectedVnffgs = new ArrayList<>();
		}
		this.affectedVnffgs.add(affectedVnffgsItem);
		return this;
	}

	/**
	 * Information about the VNFFG instances that were affected during the lifecycle
	 * operation, if this notification represents the result of a lifecycle
	 * operation. See note
	 *
	 * @return affectedVnffgs
	 **/
	@ApiModelProperty(value = "Information about the VNFFG instances that were affected during the lifecycle operation, if this notification represents the result of a lifecycle operation. See note ")

	@Valid

	public List<AffectedVnffg> getAffectedVnffgs() {
		return affectedVnffgs;
	}

	public void setAffectedVnffgs(final List<AffectedVnffg> affectedVnffgs) {
		this.affectedVnffgs = affectedVnffgs;
	}

	public NsLcmOpOccResourceChanges affectedNss(final List<AffectedNs> affectedNss) {
		this.affectedNss = affectedNss;
		return this;
	}

	public NsLcmOpOccResourceChanges addAffectedNssItem(final AffectedNs affectedNssItem) {
		if (this.affectedNss == null) {
			this.affectedNss = new ArrayList<>();
		}
		this.affectedNss.add(affectedNssItem);
		return this;
	}

	/**
	 * Information about the nested NS instances that were affected during the
	 * lifecycle operation, if this notification represents the result of a
	 * lifecycle operation. See note.
	 *
	 * @return affectedNss
	 **/
	@ApiModelProperty(value = "Information about the nested NS instances that were affected during the lifecycle operation, if this notification represents the result of a lifecycle operation. See note. ")

	@Valid

	public List<AffectedNs> getAffectedNss() {
		return affectedNss;
	}

	public void setAffectedNss(final List<AffectedNs> affectedNss) {
		this.affectedNss = affectedNss;
	}

	public NsLcmOpOccResourceChanges affectedSaps(final List<AffectedSap> affectedSaps) {
		this.affectedSaps = affectedSaps;
		return this;
	}

	public NsLcmOpOccResourceChanges addAffectedSapsItem(final AffectedSap affectedSapsItem) {
		if (this.affectedSaps == null) {
			this.affectedSaps = new ArrayList<>();
		}
		this.affectedSaps.add(affectedSapsItem);
		return this;
	}

	/**
	 * Information about the nested NS instances that were affected during the
	 * lifecycle operation, if this notification represents the result of a
	 * lifecycle operation. See note.
	 *
	 * @return affectedSaps
	 **/
	@ApiModelProperty(value = "Information about the nested NS instances that were affected during the lifecycle operation, if this notification represents the result of a lifecycle operation. See note. ")

	@Valid

	public List<AffectedSap> getAffectedSaps() {
		return affectedSaps;
	}

	public void setAffectedSaps(final List<AffectedSap> affectedSaps) {
		this.affectedSaps = affectedSaps;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final NsLcmOpOccResourceChanges nsLcmOpOccResourceChanges = (NsLcmOpOccResourceChanges) o;
		return Objects.equals(this.affectedVnfs, nsLcmOpOccResourceChanges.affectedVnfs) &&
				Objects.equals(this.affectedPnfs, nsLcmOpOccResourceChanges.affectedPnfs) &&
				Objects.equals(this.affectedVls, nsLcmOpOccResourceChanges.affectedVls) &&
				Objects.equals(this.affectedVnffgs, nsLcmOpOccResourceChanges.affectedVnffgs) &&
				Objects.equals(this.affectedNss, nsLcmOpOccResourceChanges.affectedNss) &&
				Objects.equals(this.affectedSaps, nsLcmOpOccResourceChanges.affectedSaps);
	}

	@Override
	public int hashCode() {
		return Objects.hash(affectedVnfs, affectedPnfs, affectedVls, affectedVnffgs, affectedNss, affectedSaps);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsLcmOpOccResourceChanges {\n");

		sb.append("    affectedVnfs: ").append(toIndentedString(affectedVnfs)).append("\n");
		sb.append("    affectedPnfs: ").append(toIndentedString(affectedPnfs)).append("\n");
		sb.append("    affectedVls: ").append(toIndentedString(affectedVls)).append("\n");
		sb.append("    affectedVnffgs: ").append(toIndentedString(affectedVnffgs)).append("\n");
		sb.append("    affectedNss: ").append(toIndentedString(affectedNss)).append("\n");
		sb.append("    affectedSaps: ").append(toIndentedString(affectedSaps)).append("\n");
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
