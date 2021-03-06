<?php

require_once '/opt/fmc_repository/Process/Reference/Common/common.php';

function list_args() {
}

foreach ($context['servers_scaled'] as $server) {
	if(!isset($server['is_msa_device'])) {
		continue;
	}
	if ($server['is_msa_device'] == "false") {
		$device_ip_address = $server['floating_ip_address'];
		$response = wait_for_ping_status($device_ip_address, $context);
		$response = json_decode($response, true);
		if ($response['wo_status'] !== ENDED) {
			$response = json_encode($response);
			echo $response;
			exit;
		}
		$server['is_msa_device'] = "true";
	}
}

$response = prepare_json_response(ENDED, "MSA Devices Ping check : OK.", $context, true);
echo $response;

?>