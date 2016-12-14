package com.site.sys;

import java.util.Calendar;

public class X {
	public static void log(String s){
		Calendar cal = Calendar.getInstance();
		s = s == null ? "(null)" : s;
		s = s.isEmpty() ? "(empty)" : s;
		System.out.println(cal.getTime().toString().concat(": ").concat(s));
	}
}
