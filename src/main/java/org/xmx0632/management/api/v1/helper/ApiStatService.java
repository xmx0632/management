package org.xmx0632.management.api.v1.helper;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;
import org.xmx0632.management.web.admin.ApiStat;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component
public class ApiStatService {

	private Map<String, AtomicInteger> apiInvokeStat = Maps.newConcurrentMap();

	public int increaseCounter(String apiName) {

		if (apiInvokeStat.containsKey(apiName)) {
			AtomicInteger apiCounter = apiInvokeStat.get(apiName);
			int newCounter = apiCounter.incrementAndGet();
			return newCounter;
		} else {
			int startFrom = 1;
			apiInvokeStat.put(apiName, new AtomicInteger(startFrom));
			return startFrom;
		}
	}

	public String getApiInvokeInfo() {
		StringBuilder sb = new StringBuilder();
		Set<Entry<String, AtomicInteger>> set = apiInvokeStat.entrySet();
		for (Entry<String, AtomicInteger> info : set) {
			sb.append(info.getKey()).append(" ").append(info.getValue())
					.append("\n");
		}
		return sb.toString();
	}

	public List<ApiStat> getStatList() {
		List<ApiStat> stats = Lists.newArrayList();
		Set<Entry<String, AtomicInteger>> set = apiInvokeStat.entrySet();
		for (Entry<String, AtomicInteger> info : set) {
			stats.add(new ApiStat(info.getKey(), info.getValue().intValue()));
		}

		return stats;
	}

	public void reset() {
		apiInvokeStat.clear();
	}
}
