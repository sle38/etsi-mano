package com.ubiqube.etsi.mano.service.event.quartz;

import java.util.UUID;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubiqube.etsi.mano.dao.mano.OnboardingStateType;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.repository.VnfPackageRepository;

/**
 * A kind of VNF rollback. We need to kepp track of the state while uploading.
 * This service will switch back the VNF state on failure.
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
public class UriUploadListener implements JobListener {

	private static final Logger LOG = LoggerFactory.getLogger(UriUploadListener.class);
	private final VnfPackageRepository vnfPackageRepository;

	public UriUploadListener(final VnfPackageRepository vnfPackageRepository) {
		super();
		this.vnfPackageRepository = vnfPackageRepository;
	}

	@Override
	public String getName() {
		return "VNF Package URI Uploader Listener.";
	}

	@Override
	public void jobToBeExecuted(final JobExecutionContext context) {
		LOG.info("Job jobToBeExecuted.");

	}

	@Override
	public void jobExecutionVetoed(final JobExecutionContext context) {
		LOG.info("Job Vetoed.");
	}

	@Override
	public void jobWasExecuted(final JobExecutionContext context, final JobExecutionException jobException) {
		if ((null == jobException) || jobException.getMessage().isEmpty()) {
			return;
		}

		final JobDataMap datamap = context.getJobDetail().getJobDataMap();
		final String vnfPkgId = (String) datamap.get("objectId");
		LOG.info("Rollbacking vnf package {}", vnfPkgId);
		final VnfPackage vnfPackage = vnfPackageRepository.get(UUID.fromString(vnfPkgId));
		vnfPackage.setOnboardingState(OnboardingStateType.CREATED);
		vnfPackageRepository.save(vnfPackage);
		LOG.info("Rollback successfull.");
	}

}
