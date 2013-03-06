package org.xmx0632.management.utilities.encode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springside.modules.utils.Encodes;

public class Encoder extends Encodes {

	private static final Pattern reUnicode = Pattern
			.compile("\\\\u([0-9a-zA-Z]{4})");

	public static String decodeUnicode(String s) {
		Matcher m = reUnicode.matcher(s);
		StringBuffer sb = new StringBuffer(s.length());
		while (m.find()) {
			m.appendReplacement(sb,
					Character.toString((char) Integer.parseInt(m.group(1), 16)));
		}
		m.appendTail(sb);
		return sb.toString();
	}
}
