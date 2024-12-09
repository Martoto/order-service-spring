package com.dsalles.boilerplate.springboot.utils;

import java.util.Locale;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public final class ProjectConstants {


	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final Locale ENGLISH_LOCALE = new Locale.Builder().setLanguage("en").setRegion("US").build();

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
