package org.xmx0632.management.web.admin;

public class ApiStat {

	private String name;
	private int counter;

	public ApiStat(String name, int counter) {
		this.name = name;
		this.counter = counter;
	}

	public String getName() {
		return name;
	}

	public int getCounter() {
		return counter;
	}

}
