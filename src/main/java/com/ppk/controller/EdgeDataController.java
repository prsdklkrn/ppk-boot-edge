package com.ppk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ppk.ms.entities.EdgeData;
import com.ppk.service.EdgeDataService;

@RestController
public class EdgeDataController {

	private final EdgeDataService edgeDataService;

	@Autowired
	public EdgeDataController(EdgeDataService edgeDataService) {
		this.edgeDataService = edgeDataService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EdgeData welcomeMessage() {
		return edgeDataService.getEdgeData();
	}

}
