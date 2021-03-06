package com.ubiqube.etsi.mano.controller.vnf;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.factory.VnfPackageFactory;
import com.ubiqube.etsi.mano.model.vnf.SubscriptionAuthentication;
import com.ubiqube.etsi.mano.model.vnf.SubscriptionObject;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.notification.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.notification.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.repository.SubscriptionRepository;
import com.ubiqube.etsi.mano.service.event.Notifications;

@Service
public class VnfSubscriptionManagement {
	private final Notifications notifications;
	private final SubscriptionRepository subscriptionRepository;

	public VnfSubscriptionManagement(final Notifications _notifications, final SubscriptionRepository _subscriptionRepository) {
		super();
		this.notifications = _notifications;
		this.subscriptionRepository = _subscriptionRepository;
	}

	public List<PkgmSubscription> subscriptionsGet(final String filter, final Linkable links) {
		final List<SubscriptionObject> result = subscriptionRepository.query(filter);
		final List<PkgmSubscription> response = result.stream()
				.map(SubscriptionObject::getPkgmSubscription)
				.collect(Collectors.toList());
		response.stream().forEach(x -> x.setLinks(links.createSubscriptionsPkgmSubscriptionLinks(x.getId())));
		return response;
	}

	public List<PkgmSubscription> subscriptionsPost(@Nonnull final PkgmSubscriptionRequest subscriptionsPostQuery, final Linkable links) {
		// Response
		final ArrayList<PkgmSubscription> response = new ArrayList<>();
		final String callback = subscriptionsPostQuery.getCallbackUri();
		@Valid
		final PkgmNotificationsFilter filter = subscriptionsPostQuery.getFilter();
		final PkgmSubscription subscription = VnfPackageFactory.createSubscriptionsPkgmSubscription(callback, filter);

		// TODO: Check test endpoint.
		final SubscriptionObject subscriptionObject = new SubscriptionObject(subscriptionsPostQuery.getAuthentication(), subscription);
		subscriptionObject.setApi(links.getApi());
		subscriptionRepository.save(subscriptionObject);
		subscription.setLinks(links.createSubscriptionsPkgmSubscriptionLinks(subscription.getId()));
		response.add(subscription);
		return response;
	}

	public void vnfPackageChangeNotificationPost(@Nonnull final VnfPackageChangeNotification notificationsMessage) {
		final UUID subscriptionId = UUID.fromString(notificationsMessage.getSubscriptionId());

		final SubscriptionObject subscriptionsRepository = subscriptionRepository.get(subscriptionId);
		final SubscriptionAuthentication auth = subscriptionsRepository.getSubscriptionAuthentication();
		final String callbackUri = subscriptionsRepository.getPkgmSubscription().getCallbackUri();

		notifications.doNotification(notificationsMessage, callbackUri, auth);
	}

	public void vnfPackageOnboardingNotificationPost(@Nonnull final VnfPackageOnboardingNotification notificationsMessage) {
		final UUID subscriptionId = UUID.fromString(notificationsMessage.getSubscriptionId());
		final SubscriptionObject subscriptionsRepository = subscriptionRepository.get(subscriptionId);
		final PkgmSubscription req = subscriptionsRepository.getPkgmSubscription();
		final String cbUrl = req.getCallbackUri();
		final com.ubiqube.etsi.mano.model.vnf.SubscriptionAuthentication auth = subscriptionsRepository.getSubscriptionAuthentication();

		notifications.doNotification(notificationsMessage, cbUrl, auth);
	}

	public void subscriptionsSubscriptionIdDelete(@Nonnull final String _subscriptionId) {
		final UUID subscriptionId = UUID.fromString(_subscriptionId);
		subscriptionRepository.get(subscriptionId);
		subscriptionRepository.delete(subscriptionId);
	}

	public PkgmSubscription subscriptionsSubscriptionIdGet(@Nonnull final String _subscriptionId, final Linkable links) {
		return subscriptionRepository.get(UUID.fromString(_subscriptionId)).getPkgmSubscription().links(links.createSubscriptionsPkgmSubscriptionLinks(_subscriptionId));
	}

}
