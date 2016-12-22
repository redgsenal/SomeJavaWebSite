<%@taglib prefix="nonce" uri="/WEB-INF/taglibs/nonce.tld"%>
<p>Just saying Hello!!! +++</p>
<nonce:hidden noncename="nonce-hello" req="${pageContext.request}"/>
