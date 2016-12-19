package com.site.utils;

import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.site.sys.X;

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
		if (sessionNonce.isEmpty())
			return "session nonce is empty";
		
		StringBuffer sb = new StringBuffer();
		Iterator<String> sessionIdKeys = sessionNonce.keySet().iterator();
		while(sessionIdKeys.hasNext()){
			String id = sessionIdKeys.next();
			if (sb.toString().isEmpty()){
				sb.append("nonce list: ");
			}else{
				sb.append(",");
			}
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

	public boolean validate(HttpServletRequest request) {
		String nonceValue = request.getParameter("nonceValue");
		String nonceName = request.getParameter("nonceName");
		if (!isHttpRequestNonceValid(request, nonceName, nonceValue))
			return false;
		Enumeration<String> ens = request.getAttributeNames();
		while(ens.hasMoreElements()){
			String ns = ens.nextElement();
			X.log("attr " + ns);
		}
		// get session id of the request
		String sessionId = request.getRequestedSessionId();
		Hashtable<String, String> nonceList = sessionNonce.get(sessionId);
		if (nonceList == null || nonceList.isEmpty())
			return false;
		X.log("session id " + sessionId);
		X.log("nonce value " + nonceValue);
		X.log("nonce name " + nonceName);
		boolean isValid = nonceList.get(nonceName).contentEquals(nonceValue);
		if (isValid)
			invalidateNonce(request, nonceName, nonceValue, nonceList);
		return isValid;
	}
	
	public void invalidateNonce(HttpServletRequest request, String nonceName, String nonceValue, Hashtable<String, String> list){
		if (!list.isEmpty())
			list.remove(nonceName, nonceValue);
		if (list.isEmpty()){
			String sessionId = request.getRequestedSessionId();
			sessionNonce.remove(sessionId);
		}
		X.log(list.toString());
	}
	
	public void invalidateNonce(HttpServletRequest request){
		String nonceValue = request.getParameter("nonceValue");
		String nonceName = request.getParameter("nonceName");
		if (!isHttpRequestNonceValid(request, nonceName, nonceValue))
			return;
		Hashtable<String, String> list = getNonceList(nonceValue, request);
		invalidateNonce(request, nonceName, nonceValue, list);
	}
	
	private Hashtable<String, String> getNonceList(String nonceValue, HttpServletRequest request){
		String sessionId = request.getRequestedSessionId();
		Hashtable<String, String> nonceList = sessionNonce.get(sessionId);
		return nonceList;
	}
	
	private boolean isHttpRequestNonceValid(HttpServletRequest request, String nonceName, String nonceValue){
		return ((nonceValue != null && !nonceValue.isEmpty()) && (nonceName !=null && !nonceName.isEmpty()) && (!sessionNonce.isEmpty()));
	}
}
