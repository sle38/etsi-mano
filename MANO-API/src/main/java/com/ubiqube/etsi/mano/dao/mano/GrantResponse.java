package com.ubiqube.etsi.mano.dao.mano;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@EntityListeners(AuditListener.class)
public class GrantResponse implements BaseEntity, Auditable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id = null;

	@Embedded
	private Audit audit;

	private String vnfdId;

	private String flavourId;

	private String operation;

	private boolean isAutomaticInvocation;

	private String instantiationLevelId;

	// Must be string because VNFM / NFVO are differents.
	private String vnfInstanceId = null;

	// Must be string because VNFM / NFVO are differents.
	private String vnfLcmOpOccId = null;

	@Valid
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn
	private Set<VimConnectionInformation> vimConnections = null;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "grants")
	private Set<ZoneInfoEntity> zones = null;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Set<ZoneGroupInformation> zoneGroups = null;

	private String computeReservationId = null;

	private String networkReservationId = null;

	private String storageReservationId = null;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrantInformationExt> addResources = null;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrantInformationExt> tempResources = null;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrantInformationExt> removeResources = null;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrantInformationExt> updateResources = null;

	@Embedded
	private GrantVimAssetsEntity vimAssets = null;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private Set<ExtVirtualLinkDataEntity> extVirtualLinks = null;

	@Valid
	@OneToMany(mappedBy = "grants", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ExtManagedVirtualLinkDataEntity> extManagedVirtualLinks = null;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> additionalParams = null;

	/**
	 * Flag to say if grants have been, inspected.
	 */
	private Boolean available;

	@Override
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Override
	public Audit getAudit() {
		return audit;
	}

	@Override
	public void setAudit(final Audit audit) {
		this.audit = audit;
	}

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	public String getVnfLcmOpOccId() {
		return vnfLcmOpOccId;
	}

	public void setVnfLcmOpOccId(final String vnfLcmOpOccId) {
		this.vnfLcmOpOccId = vnfLcmOpOccId;
	}

	public Set<VimConnectionInformation> getVimConnections() {
		return vimConnections;
	}

	public void setVimConnections(final Set<VimConnectionInformation> vimConnections) {
		this.vimConnections = vimConnections;
	}

	public Set<ZoneInfoEntity> getZones() {
		return zones;
	}

	public void setZones(final Set<ZoneInfoEntity> zones) {
		this.zones = zones;
	}

	public Set<ZoneGroupInformation> getZoneGroups() {
		return zoneGroups;
	}

	public void setZoneGroups(final Set<ZoneGroupInformation> zoneGroups) {
		this.zoneGroups = zoneGroups;
	}

	public String getComputeReservationId() {
		return computeReservationId;
	}

	public void setComputeReservationId(final String computeReservationId) {
		this.computeReservationId = computeReservationId;
	}

	public String getNetworkReservationId() {
		return networkReservationId;
	}

	public void setNetworkReservationId(final String networkReservationId) {
		this.networkReservationId = networkReservationId;
	}

	public String getStorageReservationId() {
		return storageReservationId;
	}

	public void setStorageReservationId(final String storageReservationId) {
		this.storageReservationId = storageReservationId;
	}

	public Set<GrantInformationExt> getAddResources() {
		return addResources;
	}

	public void setAddResources(final Set<GrantInformationExt> addResources) {
		this.addResources = addResources;
	}

	public Set<GrantInformationExt> getTempResources() {
		return tempResources;
	}

	public void setTempResources(final Set<GrantInformationExt> tempResources) {
		this.tempResources = tempResources;
	}

	public Set<GrantInformationExt> getRemoveResources() {
		return removeResources;
	}

	public void setRemoveResources(final Set<GrantInformationExt> removeResources) {
		this.removeResources = removeResources;
	}

	public Set<GrantInformationExt> getUpdateResources() {
		return updateResources;
	}

	public void setUpdateResources(final Set<GrantInformationExt> updateResources) {
		this.updateResources = updateResources;
	}

	public GrantVimAssetsEntity getVimAssets() {
		return vimAssets;
	}

	public void setVimAssets(final GrantVimAssetsEntity vimAssets) {
		this.vimAssets = vimAssets;
	}

	public Set<ExtVirtualLinkDataEntity> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(final Set<ExtVirtualLinkDataEntity> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public Set<ExtManagedVirtualLinkDataEntity> getExtManagedVirtualLinks() {
		return extManagedVirtualLinks;
	}

	public void setExtManagedVirtualLinks(final Set<ExtManagedVirtualLinkDataEntity> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
	}

	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
	}

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public String getFlavourId() {
		return flavourId;
	}

	public void setFlavourId(final String flavourId) {
		this.flavourId = flavourId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(final String operation) {
		this.operation = operation;
	}

	public boolean isAutomaticInvocation() {
		return isAutomaticInvocation;
	}

	public void setAutomaticInvocation(final boolean isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
	}

	public String isInstantiationLevelId() {
		return instantiationLevelId;
	}

	public void setInstantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(final Boolean available) {
		this.available = available;
	}

	public void addExtManagedVl(final ExtManagedVirtualLinkDataEntity extVl) {
		if (null == extManagedVirtualLinks) {
			extManagedVirtualLinks = new HashSet<>();
		}
		extManagedVirtualLinks.add(extVl);
	}

	public void addZones(final ZoneInfoEntity zone) {
		if (null == zones) {
			zones = new HashSet<>();
		}
		zone.setGrants(this);
		zones.add(zone);

	}

}
