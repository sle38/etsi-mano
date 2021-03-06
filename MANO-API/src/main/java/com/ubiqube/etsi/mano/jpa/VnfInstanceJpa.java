package com.ubiqube.etsi.mano.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.ubiqube.etsi.mano.dao.mano.VnfInstance;

public interface VnfInstanceJpa extends CrudRepository<VnfInstance, UUID> {

	int countByVnfPkgId(UUID fromString);

	Optional<VnfInstance> findByVnfPkg_IdAndNsInstance_Id(UUID vnfPackageId, UUID nsInstanceid);
}
