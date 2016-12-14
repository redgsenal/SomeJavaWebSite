package com.site.utils;

import java.util.Hashtable;

import com.site.sys.X;

public class NonceList {
	Hashtable<String, Hashtable> sessionNonce = new Hashtable<String, Hashtable>();
	public NonceList(String sessionId, String nonceName, String nonceValue) {
		Hashtable<String, String> nonceItems = new Hashtable<String, String>();
		if (nonceItems.containsKey(nonceName))
			nonceItems.replace(nonceName, nonceValue);
		else
			nonceItems.put(nonceName, nonceValue);
		
		sessionNonce.put(sessionId, nonceItems);
		
		X.log("nonce setup " + sessionId + " " + nonceName + " " + nonceValue);
	}
	
	public String getNonceValue(String sessionId, String nonceName){
		Hashtable nonceItems = (Hashtable) sessionNonce.get(sessionId);
		if (nonceItems.isEmpty())
			return null;
		return (String) nonceItems.get(nonceName);
	}
}
