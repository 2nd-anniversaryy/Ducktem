package com.ducktem.ducktemapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ducktem.ducktemapi.exception.ProductException;

public class TimeFormatter {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");

	public static String NOW() {
		return format.format(new Date());
	}

	public static String nTimeAgo(String regDate){
		Date prevDate;
		try{
			prevDate = format.parse(regDate);
  		}catch (ParseException e){
			throw new ProductException(e.getMessage());
  		}

		long today = System.currentTimeMillis();

		long sec = (today-prevDate.getTime()) / 1000;
		long minute = (today-prevDate.getTime()) / 60000;
		long hour = (today-prevDate.getTime()) /3600000;
		long days = sec / (24 * 60 * 60);

		if(sec < 60){
			return sec + "초 전";
		}else if (minute < 60){
			return minute + "분 전";
		}else if(hour < 24) {
			return hour + "시간 전";
		}else if(days < 30) {
			return days + "일 전";
		}

		return "오래전";
	}
}
