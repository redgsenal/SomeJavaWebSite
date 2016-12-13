<!-- always put taglibs on top first --> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="style" uri="/WEB-INF/taglibs/css.tld"%>
<%@taglib prefix="script" uri="/WEB-INF/taglibs/script.tld"%>
<%@taglib prefix="url" uri="/WEB-INF/taglibs/url.tld"%>
<%@taglib prefix="image" uri="/WEB-INF/taglibs/image.tld"%>
<%@page import="com.site.utils.SiteProperties"%>
<%
	SiteProperties props = new SiteProperties();
%>
<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title><%=props.getSiteTitle(this)%></title>
        <meta name="description" content="<%=props.getSiteDescription(this)%>">
        <meta name="viewport" content="width=device-width, initial-scale=1">

		<meta property="og:url" content="" />
		<meta property="og:type" content="website" />
		<meta property="og:site_name" content="<%=props.getSiteName(this)%>" />
		<meta property="og:title" content="<%=props.getSiteTitle(this)%>" />
		<meta property="og:description" content="<%=props.getSiteDescription(this)%>" />
		<meta property="og:image" content="<url:path req="${pageContext.request}" path="<%=props.getSiteShareImage(this)%>"/>" />
		<meta property="og:locale" content="en_GB" />

        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        
        <style:path req="${pageContext.request}" href="css/normalize.css"/>
        <style:path req="${pageContext.request}" href="css/main.css"/>
        <style:path req="${pageContext.request}" href="css/styles.css"/>
        <script:path req="${pageContext.request}" src="js/vendors/modernizr-2.8.3.min.js"/>
    </head>
    <body>
    <p>Head</p>
    <image:path req="${pageContext.request}" path="images/sample.jpg" classname="image-box"/>