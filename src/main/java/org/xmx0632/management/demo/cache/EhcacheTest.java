package org.xmx0632.management.demo.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringContextTestCase;

/**
 * 演示Ehcache的配置.
 * 
 * 配置见applicationContext-ehcache.xml与ehcache.xml
 * 
 * @author calvin
 */
@ContextConfiguration(locations = { "/ehcache/applicationContext-ehcache.xml" })
public class EhcacheTest extends SpringContextTestCase {

	@Autowired
	private Cache cache;

	@Test
	public void demo() {

		String key = "foo";
		String value = "boo";

		put(key, value);
		Object result = get(key);

		assertEquals(value, result);
	}

	@Test
	public void demo1() {

		String key = "foo1";
		Object result = get(key);

		assertNull(result);
	}

	public Object get(String key) {
		Element element = cache.get(key);
		if (element == null) {
			return null;
		}
		return element.getObjectValue();
	}

	public void put(String key, Object value) {
		Element element = new Element(key, value);
		cache.put(element);
	}
}
