package com.ubiqube.etsi.mano.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ubiqube.etsi.mano.exception.GenericException;
import com.ubiqube.etsi.mano.model.nsd.sol005.NsDescriptorsNsdInfo;
import com.ubiqube.etsi.mano.model.nsd.sol005.PnfDescriptorsPnfdInfo;
import com.ubiqube.etsi.mano.model.nslcm.sol003.VnfInstance;
import com.ubiqube.etsi.mano.model.nslcm.sol003.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsInstance;
import com.ubiqube.etsi.mano.model.nslcm.sol005.NsLcmOpOccsNsLcmOpOcc;
import com.ubiqube.etsi.mano.model.vnf.sol005.VnfPkgInfo;

/**
 * Maybe we should rename this class ;)
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
public class ClassPathConverter {
	private final Map<Class<?>, String> path = new HashMap<>();

	public ClassPathConverter() {
		path.put(NsDescriptorsNsdInfo.class, "nsd");
		path.put(NsLcmOpOccsNsLcmOpOcc.class, "nsd-lcm-op-occs");
		path.put(NsInstance.class, "nsd-instances");

		path.put(VnfPkgInfo.class, "vnf-packages");
		path.put(VnfLcmOpOcc.class, "vnf-lcm-op-occs");
		path.put(VnfInstance.class, "vnf-instances");

		path.put(PnfDescriptorsPnfdInfo.class, "pnfd");

	}

	public Set<Class<?>> getList() {
		return Collections.unmodifiableSet(path.keySet());
	}

	/**
	 *
	 * @param clazz
	 * @return Should be a Path ?
	 */
	public String convert(final Class<?> clazz) {
		final String ret = path.get(clazz);
		if (null == ret) {
			throw new GenericException("Class " + clazz + " doesn't have a path.");
		}
		return ret;
	}
}