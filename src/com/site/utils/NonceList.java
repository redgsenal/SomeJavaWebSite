package com.site.utils;

import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class NonceList {
	private Hashtable<String, Hashtable<String, String>> sessionNonce = new Hashtable<String, Hashtable<String, String>>();
	
	public String getNonceValue(String sessionId, String nonceName){
		Hashtable<String, String> nonceItems = (Hashtable<String, String>) sessionNonce.get(sessionId);
		if (nonceItems.isEmpty())
			return "";		
		return (String) nonceItems.get(nonceName);
	}
	
	public String generateNonce(String requestedSessionId, String nonceName) {
		String nonceValue = "";
		try {
			nonceValue = SiteRand.generateRandomString(12);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		return nonceValue;
	}

	public void add(String requestedSessionId, String nonceName, String nonceValue) {
		Hashtable<String, String> nonceItems = new Hashtable<String, String>();
		if (nonceItems.containsKey(nonceName))
			nonceItems.replace(nonceName, nonceValue);
		else
			nonceItems.put(nonceName, nonceValue);
		
		sessionNonce.put(requestedSessionId, nonceItems);		
	}
	
	public Hashtable<String, Hashtable<String, String>> getSessionNonce(){
		return sessionNonce;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("nonce list: ");
		Iterator<String> sessionIdKeys = sessionNonce.keySet().iterator();
		while(sessionIdKeys.hasNext()){
			String id = sessionIdKeys.next();			
			sb.append("session_id => ").append(id).append("[");
			Hashtable<String, String> nonceList = (Hashtable<String, String>) sessionNonce.get(id);
			Iterator<String> nonceNames = nonceList.keySet().iterator();
			while(nonceNames.hasNext()){
				String nonceName = nonceNames.next();
				String nonceValue = nonceList.get(nonceName);
				sb.append("{nonce_name => ").append(nonceName).append(", ");
				sb.append("nonce_value => ").append(nonceValue).append("}");
			}
			sb.append("]");
		}
		return sb.toString();
	}
}
