<%@taglib prefix="nonce" uri="/WEB-INF/taglibs/nonce.tld"%>
<p>Just saying Hello!!! +++</p>
<nonce:input noncename="nonce-hello" req="${pageContext.request}"/>
