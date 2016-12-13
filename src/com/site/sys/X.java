package com.site.sys;

import java.util.Calendar;

public class X {
	public static void log(String s){
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime().toString().concat(": ").concat(s));
	}
}
