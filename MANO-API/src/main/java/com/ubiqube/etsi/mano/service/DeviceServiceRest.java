package com.ubiqube.etsi.mano.service;

import java.net.URI;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ubiqube.api.commons.id.DeviceId;
import com.ubiqube.api.entities.device.Manufacturer;
import com.ubiqube.api.entities.device.Model;
import com.ubiqube.api.entities.device.SimpleDevice;
import com.ubiqube.api.exception.ServiceException;
import com.ubiqube.api.interfaces.device.DeviceService;

@Service
public class DeviceServiceRest implements DeviceService {

	private final static UbiRest rest = new UbiRest();

	@Override
	public DeviceId getDeviceId(String nsInstanceId) throws ServiceException {
		final URI uri = rest.uriBuilder()
				.pathSegment("device/v1/reference/" + nsInstanceId)
				.build()
				.toUri();
		return rest.get(uri, DeviceIdModel.class);
	}

	static class DeviceIdModel implements DeviceId {
		public long id;			// : 125,
		public String prefix;		// : "TST",
		public String ubiId;		// : "TST125",
		public String name;		// : "self",
		public String externalReference; // : "TST125",
		public long operatorId;		// : 0,
		public String displayName;	// : "self - TST125",
		public String displayNameForJsps; // : "self - TST125"

		public String getUbiId() {
			return ubiId;
		}
	}

	@Override
	public void deleteDevice(DeviceId deviceId, String name) throws ServiceException {
		final URI uri = rest.uriBuilder()
				.pathSegment("device/reference/" + deviceId.getUbiId())
				.build()
				.toUri();
		rest.delete(uri, String.class);
	}

	@Override
	public SimpleDevice getDeviceModeleAndManId(DeviceId deviceId) throws ServiceException {
		final URI uri = rest.uriBuilder()
				.pathSegment("device/v1/device")
				.queryParam("deviceId", deviceId)
				.build()
				.toUri();
		return rest.get(uri, SimpleDeviceModel.class);
	}

	static class SimpleDeviceModel implements SimpleDevice {

		public DeviceId getUbiqubeId() {
			return null;
		}

		public String getName() {
			return null;
		}
	}

	@Override
	public Map<Long, Manufacturer> getAvailableManufacturers() throws ServiceException {
		final URI uri = rest.uriBuilder()
				.pathSegment("device/v1/manufacturers")
				.build()
				.toUri();
		return rest.get(uri, ListOfManufacturers.class);
	}

	static class ManufacturerModel implements Manufacturer {
		public ModelModel model;
		public String name;

		public Model getModel(long modelId) {
			return model;
		}

		public String getName() {
			return name;
		}
	}

	static class ModelModel implements Model {
		public String name;

		public String getName() {
			return name;
		}
	}

	static class ListOfManufacturers extends HashMap<Long, Manufacturer> {
	}

}
