package com.ppk.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.ppk.edge.entities.MSData;

import feign.Headers;
import feign.RequestLine;

@FeignClient(name = "ppk-boot-micro-a")
public interface MicroAClient {
	
	@Headers(HttpHeaders.CONTENT_TYPE + ":" + MediaType.APPLICATION_JSON_VALUE)
	@RequestLine("GET /ms/v1/data/")
	MSData getMSData();
	
}
