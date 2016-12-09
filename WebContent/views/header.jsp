<!-- always put taglibs on top first --> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.site.global.Global"%>
<%@page import="com.site.utils.Utility"%>
<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title><%=Utility.getSiteName(this)%></title>
        <meta name="description" content="<%=Utility.getSiteDescription(this)%>">
        <meta name="viewport" content="width=device-width, initial-scale=1">

		<meta property="og:url" content="" />
		<meta property="og:type" content="website" />
		<meta property="og:site_name" content="SomeWebsite" />
		<meta property="og:title" content="Some Website" />
		<meta property="og:description" content="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." />
		<meta property="og:image" content="" />
		<meta property="og:locale" content="en_GB" />

        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/styles.css">
        <script src="js/vendors/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
    <p>Head</p>
