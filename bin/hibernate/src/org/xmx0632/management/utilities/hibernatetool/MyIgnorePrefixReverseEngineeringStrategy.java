package org.xmx0632.management.utilities.hibernatetool;

import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;

public class MyIgnorePrefixReverseEngineeringStrategy extends
		IgnorePrefixReverseEngineeringStrategy {
	public MyIgnorePrefixReverseEngineeringStrategy(
			ReverseEngineeringStrategy delegate) {
		super(delegate);
	}

	@Override
	protected int getPrefixLength() {
		return 3;
	}
}
