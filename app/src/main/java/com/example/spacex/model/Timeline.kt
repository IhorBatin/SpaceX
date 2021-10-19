package com.example.spacex.model

import com.squareup.moshi.Json

data class Timeline(

	@Json(name="beco")
	val beco: Int? = null,

	@Json(name="second_stage_ignition")
	val secondStageIgnition: Int? = null,

	@Json(name="side_core_boostback")
	val sideCoreBoostback: Int? = null,

	@Json(name="payload_deploy")
	val payloadDeploy: Int? = null,

	@Json(name="stage1_lox_loading")
	val stage1LoxLoading: Int? = null,

	@Json(name="seco-2")
	val seco2: Int? = null,

	@Json(name="seco-1")
	val seco1: Int? = null,

	@Json(name="stage2_lox_loading")
	val stage2LoxLoading: Int? = null,

	@Json(name="ignition")
	val ignition: Int? = null,

	@Json(name="seco-4")
	val seco4: Int? = null,

	@Json(name="prelaunch_checks")
	val preLaunchChecks: Int? = null,

	@Json(name="seco-3")
	val seco3: Int? = null,

	@Json(name="stage2_rp1_loading")
	val stage2Rp1Loading: Int? = null,

	@Json(name="center_core_landing")
	val centerCoreLanding: Int? = null,

	@Json(name="side_core_landing")
	val sideCoreLanding: Int? = null,

	@Json(name="liftoff")
	val liftoff: Int? = null,

	@Json(name="center_stage_sep")
	val centerStageSep: Int? = null,

	@Json(name="stage1_rp1_loading")
	val stage1Rp1Loading: Int? = null,

	@Json(name="side_core_entry_burn")
	val sideCoreEntryBurn: Int? = null,

	@Json(name="webcast_liftoff")
	val webcastLiftoff: Int? = null,

	@Json(name="second_stage_restart")
	val secondStageRestart: Int? = null,

	@Json(name="propellant_pressurization")
	val propellantPressurization: Int? = null,

	@Json(name="engine_chill")
	val engineChill: Int? = null,

	@Json(name="meco")
	val meco: Int? = null,

	@Json(name="go_for_prop_loading")
	val goForPropLoading: Int? = null,

	@Json(name="fairing_deploy")
	val fairingDeploy: Int? = null,

	@Json(name="go_for_launch")
	val goForLaunch: Int? = null,

	@Json(name="center_core_entry_burn")
	val centerCoreEntryBurn: Int? = null,

	@Json(name="side_core_sep")
	val sideCoreSep: Int? = null,

	@Json(name="maxq")
	val maxq: Int? = null,

	@Json(name="rp1_loading")
	val rp1Loading: Int? = null,

	@Json(name="first_stage_landing")
	val firstStageLanding: Int? = null,

	@Json(name="first_stage_entry_burn")
	val firstStageEntryBurn: Int? = null,

	@Json(name="stage_sep")
	val stageSep: Int? = null,

	@Json(name="first_stage_boostback_burn")
	val firstStageBoostBackBurn: Int? = null,

	@Json(name="dragon_solar_deploy")
	val dragonSolarDeploy: Int? = null,

	@Json(name="dragon_bay_door_deploy")
	val dragonBayDoorDeploy: Int? = null,

	@Json(name="dragon_separation")
	val dragonSeparation: Int? = null,

	@Json(name="first_stage_landing_burn")
	val firstStageLandingBurn: Int? = null,

	@Json(name="payload_deploy_2")
	val payloadDeploy2: Int? = null,

	@Json(name="payload_deploy_1")
	val payloadDeploy1: Int? = null,

	@Json(name="center_core_boostback")
	val centerCoreBoostBack: Int? = null,

	@Json(name="webcast_launch")
	val webcastLaunch: Int? = null
)