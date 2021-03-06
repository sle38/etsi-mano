package com.ubiqube.etsi.mano.nfvo.v261.controller.vnf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.Linkable;
import com.ubiqube.etsi.mano.controller.vnf.VnfSubscriptionManagement;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.notification.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.notification.VnfPackageOnboardingNotification;

@Profile({ "!VNFM" })
@RestController
public class VnfSubscriptionSol005Api implements VnfSubscriptionSol005 {

	private static final Logger LOG = LoggerFactory.getLogger(VnfSubscriptionSol005Api.class);

	private final VnfSubscriptionManagement vnfSubscriptionManagement;
	private final Linkable links = new Sol005Linkable();

	public VnfSubscriptionSol005Api(final VnfSubscriptionManagement _vnfSubscriptionManagement) {
		vnfSubscriptionManagement = _vnfSubscriptionManagement;
		LOG.info("Starting VNF Subscription Package SOL005 Controller.");
	}

	@Override
	public ResponseEntity<List<PkgmSubscription>> subscriptionsGet(@RequestParam(value = "filter", required = false) final String filters) {
		return new ResponseEntity<>(vnfSubscriptionManagement.subscriptionsGet(filters, links), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<PkgmSubscription>> subscriptionsPost(final PkgmSubscriptionRequest subscriptionsPostQuery) {
		// Job
		return new ResponseEntity<>(vnfSubscriptionManagement.subscriptionsPost(subscriptionsPostQuery, links), HttpStatus.OK);
	}

	@Override
	public void subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		vnfSubscriptionManagement.subscriptionsSubscriptionIdDelete(subscriptionId);
	}

	@Override
	public ResponseEntity<PkgmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return new ResponseEntity<>(vnfSubscriptionManagement.subscriptionsSubscriptionIdGet(subscriptionId, links), HttpStatus.OK);

	}

	@Override
	public void vnfPackageChangeNotificationPost(final VnfPackageChangeNotification notificationsMessage) {
		vnfSubscriptionManagement.vnfPackageChangeNotificationPost(notificationsMessage);
	}

	@Override
	public void vnfPackageOnboardingNotificationPost(final VnfPackageOnboardingNotification notificationsMessage) {
		vnfSubscriptionManagement.vnfPackageOnboardingNotificationPost(notificationsMessage);
	}

}
