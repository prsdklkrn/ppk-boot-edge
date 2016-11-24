package com.ppk.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import feign.Headers;
import feign.RequestLine;

@FeignClient(name = "ppk-boot-micro-b")
public interface MicroBClient {

	@Headers(HttpHeaders.CONTENT_TYPE + ":" + MediaType.APPLICATION_JSON_VALUE)
	@RequestLine("GET /ms/v2/content/")
	Map<String, String> getContent();

}
