package com.ppk.transformer;

import java.util.Map;

import com.ppk.edge.entities.MSData;
import com.ppk.ms.entities.EdgeData;

import rx.functions.Func2;

public class EdgeDataTransformer implements Func2<MSData, Map<String, String>, EdgeData> {

	@Override
	public EdgeData call(MSData microAData, Map<String, String> microBContent) {
		EdgeData ed = new EdgeData();
		ed.setId(microAData.getId());
		ed.setTitle(microAData.getTitle());
		ed.setTotalUse(microAData.getTotalUse());
		ed.setContent(microBContent.get("copy"));
		return ed;
	}

}
