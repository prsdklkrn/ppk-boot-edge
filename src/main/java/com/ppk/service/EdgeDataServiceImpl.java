package com.ppk.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ppk.edge.entities.MSData;
import com.ppk.feign.MicroAClient;
import com.ppk.feign.MicroBClient;
import com.ppk.ms.entities.EdgeData;
import com.ppk.rx.CustomObservable;
import com.ppk.transformer.EdgeDataTransformer;

import rx.Observable;

@Service
public class EdgeDataServiceImpl implements EdgeDataService {

	private final CustomObservable	customObservable;
	private final MicroAClient		microAClient;
	private final MicroBClient		microBClient;

	public EdgeDataServiceImpl(
			CustomObservable customObservable,
			MicroAClient microAClient,
			MicroBClient microBClient) {
		this.customObservable = customObservable;
		this.microAClient = microAClient;
		this.microBClient = microBClient;
	}

	@Override
	public EdgeData getEdgeData() {
		Observable<MSData> microAObservable = customObservable.getObservable(() -> microAClient.getMSData());
		Observable<Map<String, String>> microBObservable = customObservable
				.getObservable(() -> microBClient.getContent());
		return merge(microAObservable, microBObservable);
	}

	private EdgeData merge(Observable<MSData> microAObservable, Observable<Map<String, String>> microBObservable) {
		return Observable.zip(microAObservable, microBObservable, new EdgeDataTransformer()).toBlocking().single();
	}

}
