package org.xmx0632.management.api.v1.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.xmx0632.management.api.v1.helper.ApiStatService;

public class ApiStatTest {

	@InjectMocks
	private ApiStatService apiStat;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIncreaseCounter() {
		int counter = apiStat.increaseCounter("apiName");
		assertEquals(1, counter);

		counter = apiStat.increaseCounter("apiName");
		assertEquals(2, counter);
	}

	@Test
	public void testGetApiInvokeInfo() {
		String info = apiStat.getApiInvokeInfo();
		assertEquals("", info);
	}

	@Test
	public void testGetApiInvokeInfo1() {
		apiStat.increaseCounter("apiName");
		assertEquals("apiName 1", apiStat.getApiInvokeInfo().trim());

		apiStat.increaseCounter("apiName");
		assertEquals("apiName 2", apiStat.getApiInvokeInfo().trim());
	}

	@Test
	public void testGetStatList() {
		assertEquals(0, apiStat.getStatList().size());

		apiStat.increaseCounter("apiName");

		assertEquals(1, apiStat.getStatList().size());
	}
}
