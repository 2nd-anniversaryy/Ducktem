package com.ducktem.ducktemapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatter {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");

	public static Date NOW() {
		return new Date(System.currentTimeMillis());
	}

	public static String nTimeAgo(Date regDate) {

		long today = System.currentTimeMillis();

		long sec = (today - regDate.getTime()) / 1000;
		long minute = (today - regDate.getTime()) / 60000;
		long hour = (today - regDate.getTime()) / 3600000;
		long days = sec / (24 * 60 * 60);

		if (sec < 60) {
			return sec + "초 전";
		} else if (minute < 60) {
			return minute + "분 전";
		} else if (hour < 24) {
			return hour + "시간 전";
		} else if (days < 30) {
			return days + "일 전";
		}

		return "오래전";
	}
}
