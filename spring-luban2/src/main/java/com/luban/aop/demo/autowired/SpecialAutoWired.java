package com.luban.aop.demo.autowired;

import org.springframework.beans.factory.parsing.Location;
import org.springframework.stereotype.Component;

/**
 * Spring对某些对象是不自动注入的
 * 1. Class
 * 2. Char
 * 3. Location
 */
public class SpecialAutoWired {

	private Class clazz;

	private Location location;

	private char charSet;

	private String string;

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public char getCharSet() {
		return charSet;
	}

	public void setCharSet(char charSet) {
		this.charSet = charSet;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
