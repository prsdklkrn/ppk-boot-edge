package com.ppk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.ppk.ms.entities.EdgeData;
import com.ppk.service.EdgeDataService;

@RestController
public class EdgeDataController {

	private static final String		EDGE_BASE_METRIC_URL	= "/edge/v1/data";

	private final EdgeDataService	edgeDataService;

	@Autowired
	public EdgeDataController(EdgeDataService edgeDataService) {
		this.edgeDataService = edgeDataService;
	}

	@Timed(name = EDGE_BASE_METRIC_URL + " == [GET]", absolute = true)
	@ExceptionMetered(name = EDGE_BASE_METRIC_URL + " == [GET" + ExceptionMetered.DEFAULT_NAME_SUFFIX
			+ "]", absolute = true)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EdgeData welcomeMessage() {
		return edgeDataService.getEdgeData();
	}

}
