package com.ubiqube.etsi.mano.controller.nslcm.sol005;

import static com.ubiqube.etsi.mano.Constants.ensureInstantiated;
import static com.ubiqube.etsi.mano.Constants.ensureIsEnabled;
import static com.ubiqube.etsi.mano.Constants.ensureIsOnboarded;
import static com.ubiqube.etsi.mano.Constants.ensureNotInstantiated;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubiqube.etsi.mano.exception.GenericException;
import com.ubiqube.etsi.mano.exception.NotFoundException;
import com.ubiqube.etsi.mano.factory.LcmFactory;
import com.ubiqube.etsi.mano.factory.NsInstanceFactory;
import com.ubiqube.etsi.mano.json.MapperForView;
import com.ubiqube.etsi.mano.model.nsd.NsdPkgIndex;
import com.ubiqube.etsi.mano.model.nsd.NsdPkgInstance;
import com.ubiqube.etsi.mano.model.nsd.NsdPkgOperation;
import com.ubiqube.etsi.mano.model.nsd.sol005.NsDescriptorsNsdInfo;
import com.ubiqube.etsi.mano.model.nsd.sol005.NsDescriptorsNsdInfo.NsdUsageStateEnum;
import com.ubiqube.etsi.mano.model.nslcm.sol003.VnfInstance;
import com.ubiqube.etsi.mano.model.nslcm.sol005.InlineResponse200;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesCreateNsRequest;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstance;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstance.NsStateEnum;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceIdHealPostQuery;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceIdInstantiatePostQuery;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceIdScalePostQuery;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceIdTerminatePostQuery;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceIdUpdatePostQuery;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceLinks;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceLinksSelf;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesNsInstanceVnfInstance;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstancesPostQuery;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsLcmOpOccsNsLcmOpOcc;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsLcmOpOccsNsLcmOpOcc.LcmOperationTypeEnum;
import com.ubiqube.etsi.mano.model.vnf.sol005.VnfPkgInfo;
import com.ubiqube.etsi.mano.repository.NsInstanceRepository;
import com.ubiqube.etsi.mano.repository.NsdRepository;
import com.ubiqube.etsi.mano.repository.VnfPackageRepository;
import com.ubiqube.etsi.mano.repository.msa.LcmOpOccsMsa;
import com.ubiqube.etsi.mano.service.MsaExecutor;
import com.ubiqube.etsi.mano.service.VnfmInterface;

@Profile({ "default", "NFVO" })
@RestController
public class NsInstancesSol005Api implements NsInstancesSol005 {
	private static final Logger LOG = LoggerFactory.getLogger(NsLcmSol005Api.class);

	private final NsdRepository nsdRepository;
	private final NsInstanceRepository nsInstanceRepository;

	private final MsaExecutor msaExecutor;

	private final LcmOpOccsMsa lcmOpOccsMsa;

	private final VnfmInterface vnfm;
	private final VnfPackageRepository vnfPackageRepository;

	public NsInstancesSol005Api(final NsdRepository _nsdRepository, final NsInstanceRepository _nsInstanceRepository, final MsaExecutor _msaExecutor, final LcmOpOccsMsa _lcmOpOccsMsa, final VnfPackageRepository _vnfPackageRepository, final VnfmInterface _vnfm) {
		nsdRepository = _nsdRepository;
		nsInstanceRepository = _nsInstanceRepository;
		msaExecutor = _msaExecutor;
		lcmOpOccsMsa = _lcmOpOccsMsa;
		vnfPackageRepository = _vnfPackageRepository;
		vnfm = _vnfm;
		LOG.debug("Starting Ns Instance SOL005 Controller.");
	}

	/**
	 * Query multiple NS instances.
	 *
	 * Query NS Instances. The GET method queries information about multiple NS
	 * instances. This method shall support the URI query parameters, request and
	 * response data structures, and response codes, as specified in the Tables
	 * 6.4.2.3.2-1 and 6.4.2.3.2-2.
	 *
	 */
	@Override
	public ResponseEntity<String> nsInstancesGet(final String accept, final String filter, final String allFields, final String fields, final String excludeFields, final String excludeDefault) {
		final List<NsInstancesNsInstance> result = nsInstanceRepository.query(filter);
		result.stream().forEach(x -> x.setLinks(makeLink(x.getId())));
		final ObjectMapper mapper = MapperForView.getMapperForView(excludeFields, fields, null, null);
		try {
			return new ResponseEntity<>(mapper.writeValueAsString(result), HttpStatus.OK);
		} catch (final JsonProcessingException e) {
			throw new GenericException(e);
		}
	}

	/**
	 * Delete NS instance resource.
	 *
	 * Delete NS Identifier This method deletes an individual NS instance resource.
	 *
	 */
	@Override
	public void nsInstancesNsInstanceIdDelete(final String nsInstanceId) {
		final NsInstancesNsInstance nsInstance = nsInstanceRepository.get(nsInstanceId);
		ensureNotInstantiated(nsInstance);

		nsInstanceRepository.delete(nsInstanceId);
	}

	/**
	 * Read an individual NS instance resource.
	 *
	 * The GET method retrieves information about a NS instance by reading an
	 * individual NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<InlineResponse200> nsInstancesNsInstanceIdGet(final String nsInstanceId) {
		final InlineResponse200 resp = new InlineResponse200();
		final NsInstancesNsInstance nsInstance = nsInstanceRepository.get(nsInstanceId);
		nsInstance.setLinks(makeLink(nsInstanceId));
		resp.setNsInstance(nsInstance);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	/**
	 * Heal a NS instance.
	 *
	 * The POST method requests to heal a NS instance resource. This method shall
	 * follow the provisions specified in the Tables 6.4.7.3.1-1 and 6.4.7.3.1-2 for
	 * URI query parameters, request and response data structures, and response
	 * codes.
	 *
	 */
	@Override
	public ResponseEntity<NsInstancesNsInstance> nsInstancesNsInstanceIdHealPost(final String nsInstanceId, final NsInstancesNsInstanceIdHealPostQuery body) {
		final NsInstancesNsInstance nsInstancesNsInstance = nsInstanceRepository.get(nsInstanceId);
		ensureInstantiated(nsInstancesNsInstance);
		final NsLcmOpOccsNsLcmOpOcc lcmOpOccs = LcmFactory.createNsLcmOpOccsNsLcmOpOcc(nsInstanceId, LcmOperationTypeEnum.HEAL);
		lcmOpOccsMsa.save(lcmOpOccs);
		throw new GenericException("TODO");
	}

	/**
	 * Instantiate a NS.
	 *
	 * The POST method requests to instantiate a NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstancesNsInstance> nsInstancesNsInstanceIdInstantiatePost(final String nsInstanceId, final NsInstancesNsInstanceIdInstantiatePostQuery body) {
		final NsInstancesNsInstance nsInstancesNsInstance = nsInstanceRepository.get(nsInstanceId);
		ensureInstantiated(nsInstancesNsInstance);
		final NsLcmOpOccsNsLcmOpOcc lcmOpOccs = LcmFactory.createNsLcmOpOccsNsLcmOpOcc(nsInstanceId, LcmOperationTypeEnum.INSTANTIATE);
		lcmOpOccsMsa.save(lcmOpOccs);
		// Contact OSS/BSS
		final String nsdId = nsInstancesNsInstance.getNsdId();
		final NsDescriptorsNsdInfo nsdInfo = nsdRepository.get(nsdId);
		nsdInfo.setNsdUsageState(NsdUsageStateEnum.IN_USE);
		final Map<String, Object> userData = nsdInfo.getUserDefinedData();

		final String res = msaExecutor.onNsInstantiate(nsdId, userData);
		LOG.info("Creating a MSA Job: {}", res);
		nsInstancesNsInstance.setNsState(NsStateEnum.INSTANTIATED);
		nsInstanceRepository.save(nsInstancesNsInstance);
		userData.put("msaProcessId", res);
		nsdRepository.save(nsdInfo);
		addNsdOperation(nsdId, res, nsInstanceId, LcmOperationTypeEnum.TERMINATE);
		nsInstancesNsInstance.setLinks(makeLink(nsInstanceId));
		return new ResponseEntity<>(nsInstancesNsInstance, HttpStatus.OK);
	}

	/**
	 * Scale a NS instance.
	 *
	 * The POST method requests to scale a NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstancesNsInstance> nsInstancesNsInstanceIdScalePost(final String nsInstanceId, final String accept, final String contentType, final NsInstancesNsInstanceIdScalePostQuery body) {
		final NsInstancesNsInstance nsInstancesNsInstance = nsInstanceRepository.get(nsInstanceId);
		ensureInstantiated(nsInstancesNsInstance);
		final NsLcmOpOccsNsLcmOpOcc lcmOpOccs = LcmFactory.createNsLcmOpOccsNsLcmOpOcc(nsInstanceId, LcmOperationTypeEnum.SCALE);
		lcmOpOccsMsa.save(lcmOpOccs);
		throw new GenericException("TODO");
	}

	/**
	 * Terminate a NS instance.
	 *
	 * Terminate NS task. The POST method terminates a NS instance. This method can
	 * only be used with a NS instance in the INSTANTIATED state. Terminating a NS
	 * instance does not delete the NS instance identifier, but rather transitions
	 * the NS into the NOT_INSTANTIATED state. This method shall support the URI
	 * query parameters, request and response data structures, and response codes,
	 * as specified in the Tables 6.4.8.3.1-1 and 6.8.8.3.1-2.
	 *
	 */
	@Override
	public ResponseEntity<NsInstancesNsInstance> nsInstancesNsInstanceIdTerminatePost(final String nsInstanceId, final String accept, final String contentType, final NsInstancesNsInstanceIdTerminatePostQuery body) {
		final NsInstancesNsInstance nsInstancesNsInstance = nsInstanceRepository.get(nsInstanceId);
		ensureInstantiated(nsInstancesNsInstance);
		final NsLcmOpOccsNsLcmOpOcc lcmOpOccs = LcmFactory.createNsLcmOpOccsNsLcmOpOcc(nsInstanceId, LcmOperationTypeEnum.TERMINATE);
		lcmOpOccsMsa.save(lcmOpOccs);
		final String nsdId = nsInstancesNsInstance.getNsdId();
		final NsDescriptorsNsdInfo nsdInfo = nsdRepository.get(nsdId);
		final Map<String, Object> userData = nsdInfo.getUserDefinedData();

		final NsdPkgIndex nsdPkgIndex = vnfPackageRepository.loadObject(nsdId, NsdPkgIndex.class, "indexes.json");
		final NsdPkgInstance instance = nsdPkgIndex.getNsdPkgInstance(nsdId);

		msaExecutor.onNsInstanceTerminate(userData);

		nsInstancesNsInstance.setNsState(NsStateEnum.NOT_INSTANTIATED);
		nsInstanceRepository.save(nsInstancesNsInstance);
		userData.remove("msaProcessId");
		nsdRepository.save(nsdInfo);
		nsInstancesNsInstance.setLinks(makeLink(nsInstanceId));
		return new ResponseEntity<>(nsInstancesNsInstance, HttpStatus.OK);
	}

	/**
	 * Updates a NS instance.
	 *
	 * Scale NS instance. The POST method requests to scale a NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstancesNsInstance> nsInstancesNsInstanceIdUpdatePost(final String nsInstanceId, final String accept, final String contentType, final NsInstancesNsInstanceIdUpdatePostQuery body) {
		final NsInstancesNsInstance nsInstancesNsInstance = nsInstanceRepository.get(nsInstanceId);
		ensureInstantiated(nsInstancesNsInstance);
		final NsLcmOpOccsNsLcmOpOcc lcmOpOccs = LcmFactory.createNsLcmOpOccsNsLcmOpOcc(nsInstanceId, LcmOperationTypeEnum.UPDATE);
		lcmOpOccsMsa.save(lcmOpOccs);
		throw new GenericException("TODO");
	}

	/**
	 * Create a NS instance resource.
	 *
	 * The POST method creates a new NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<InlineResponse200> nsInstancesPost(final NsInstancesPostQuery body) {
		final NsInstancesCreateNsRequest req = body.getCreateNsRequest();
		if (req.getNsdId() == null) {
			throw new NotFoundException("NsdId field is empty.");
		}
		final NsDescriptorsNsdInfo nsd = nsdRepository.get(req.getNsdId());
		ensureIsOnboarded(nsd);
		ensureIsEnabled(nsd);
		nsd.setNsdUsageState(NsdUsageStateEnum.IN_USE);
		nsdRepository.save(nsd);

		final NsInstancesNsInstance nsInstancesNsInstance = NsInstanceFactory.createNsInstancesNsInstance(req.getNsdId(), req.getNsDescription(), req.getNsName(), nsd.getNestedNsdInfoIds());
		nsInstanceRepository.save(nsInstancesNsInstance);

		final List<NsInstancesNsInstanceVnfInstance> vnfInstances = new ArrayList<>();
		final List<String> vnfs = nsd.getVnfPkgIds();
		for (final String id : vnfs) {
			final VnfPkgInfo vnf = vnfPackageRepository.get(id);
			ensureIsOnboarded(vnf);
			ensureIsEnabled(vnf);
			final VnfInstance vnfInstance = vnfm.createVnfInstance(vnf, "VNF instance hold by: " + nsInstancesNsInstance.getId(), id);
			final NsInstancesNsInstanceVnfInstance nsInstancesNsInstanceVnfInstance = NsInstanceFactory.createNsInstancesNsInstanceVnfInstance(vnfInstance, vnf);
			vnfInstances.add(nsInstancesNsInstanceVnfInstance);
		}

		nsInstancesNsInstance.setVnfInstance(vnfInstances);
		nsInstanceRepository.save(nsInstancesNsInstance);

		final NsdPkgIndex nsdIndex = nsdRepository.loadObject(req.getNsdId(), NsdPkgIndex.class, "indexes.json");
		nsdIndex.addNsdPkgInstance(new NsdPkgInstance(nsInstancesNsInstance.getId()));
		nsdRepository.storeObject(req.getNsdId(), nsdIndex, "indexes.json");

		nsInstancesNsInstance.setLinks(makeLink(nsInstancesNsInstance.getId()));
		final InlineResponse200 resp = new InlineResponse200();
		resp.setNsInstance(nsInstancesNsInstance);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	private static NsInstancesNsInstanceLinks makeLink(@Nonnull final String id) {
		final NsInstancesNsInstanceLinks nsInstanceLinks = new NsInstancesNsInstanceLinks();
		final NsInstancesNsInstanceLinksSelf heal = new NsInstancesNsInstanceLinksSelf();
		heal.setHref(linkTo(methodOn(NsInstancesSol005.class).nsInstancesNsInstanceIdHealPost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setHeal(heal);

		final NsInstancesNsInstanceLinksSelf instantiate = new NsInstancesNsInstanceLinksSelf();
		instantiate.setHref(linkTo(methodOn(NsInstancesSol005.class).nsInstancesNsInstanceIdInstantiatePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setInstantiate(instantiate);
		// nsInstanceLinks.setNestedNsInstances(nestedNsInstances);
		final NsInstancesNsInstanceLinksSelf scale = new NsInstancesNsInstanceLinksSelf();
		scale.setHref(linkTo(methodOn(NsInstancesSol005.class).nsInstancesNsInstanceIdScalePost(id, null, null, null)).withSelfRel().getHref());
		nsInstanceLinks.setScale(scale);

		final NsInstancesNsInstanceLinksSelf self = new NsInstancesNsInstanceLinksSelf();
		self.setHref(linkTo(methodOn(NsInstancesSol005.class).nsInstancesNsInstanceIdGet(id)).withSelfRel().getHref());
		nsInstanceLinks.setSelf(self);

		final NsInstancesNsInstanceLinksSelf terminate = new NsInstancesNsInstanceLinksSelf();
		terminate.setHref(linkTo(methodOn(NsInstancesSol005.class).nsInstancesNsInstanceIdTerminatePost(id, null, null, null)).withSelfRel().getHref());
		nsInstanceLinks.setTerminate(terminate);

		final NsInstancesNsInstanceLinksSelf update = new NsInstancesNsInstanceLinksSelf();
		update.setHref(linkTo(methodOn(NsInstancesSol005.class).nsInstancesNsInstanceIdUpdatePost(id, null, null, null)).withSelfRel().getHref());
		nsInstanceLinks.setUpdate(update);
		return nsInstanceLinks;
	}

	private NsLcmOpOccsNsLcmOpOcc addNsdOperation(final String _nsdId, final String _processId, final String _nsInstanceId, final LcmOperationTypeEnum _lcmOperationType) {
		final NsLcmOpOccsNsLcmOpOcc lcmOpOccs = LcmFactory.createNsLcmOpOccsNsLcmOpOcc(_nsInstanceId, _lcmOperationType);
		lcmOpOccsMsa.save(lcmOpOccs);
		final NsdPkgIndex nsdPkgIndex = vnfPackageRepository.loadObject(_nsdId, NsdPkgIndex.class, "indexes.json");
		final NsdPkgOperation nsdPkgOperation = new NsdPkgOperation(lcmOpOccs.getId(), _processId);
		final NsdPkgInstance instance = nsdPkgIndex.getNsdPkgInstance(_nsInstanceId);
		instance.getOperations().add(nsdPkgOperation);

		vnfPackageRepository.storeObject(_nsdId, nsdPkgIndex, "indexes.json");
		return lcmOpOccs;
	}

}