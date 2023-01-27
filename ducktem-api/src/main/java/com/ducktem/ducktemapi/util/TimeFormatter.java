package com.ducktem.ducktemapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatter {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");

	public static String NOW() {
		return format.format(new Date());
	}
}
