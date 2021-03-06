<?php

require_once '/opt/fmc_repository/Process/Reference/Common/common.php';

function list_args() {
}

//$servers_serialized = $context['servers'];
//$servers_json = unserialize($servers_serialized);
//$servers_array = json_decode($servers_json, true);

if (isset($context['servers'])) {
	$servers_array = $context['servers'];

	logToFile(debug_dump($servers_array, "SERVERS ARRAY ::: ============>:\n"));


	foreach ($servers_array as &$server) {
			if (empty($server['device_id'])) {
				continue;
			}
			$device_id = substr($server['device_id'], 3);
			$response = _device_delete($device_id);
			$response = json_decode($response, true);
			if ($response['wo_status'] !== ENDED) {
				$response = json_encode($response);
				echo $response;
				exit;
			}
	}
}

$response = prepare_json_response(ENDED, "MSA Devices deleted successfully.", $context, true);
echo $response;

?>
