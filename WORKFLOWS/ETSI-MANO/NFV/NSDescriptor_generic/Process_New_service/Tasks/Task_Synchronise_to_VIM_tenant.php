<?php

/**
 * This file is necessary to include to use all the in-built libraries of /opt/fmc_repository/Reference/Common
 */
require_once '/opt/fmc_repository/Process/Reference/Common/common.php';
require_once '/opt/fmc_repository/Process/Reference/Common/Library/msa_common.php';

/**
 * List all the parameters required by the task
 */
function list_args()
{
  create_var_def('vimTenant', 'Device');
}

check_mandatory_param("vimTenant");

// TODO - Call method to synchronize device (Micro Service)

logToFile(debug_dump($context, "MSA CONTEXT:\n"));

$device_id = substr($context['vimTenant'], 3);

$response = synchronize_objects_and_verify_response($device_id);

logToFile($response);

task_exit(ENDED, "Synchronisation to VIM tenant is successfull.");

?>
