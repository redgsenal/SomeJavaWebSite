<%@ include file="/views/header.jsp"%>
<p>Login</p>
<form:form nameAttr="login" actionAttr="user_verify" idAttr="userform" classAttr="userentryform" methodAttr="post" req="${pageContext.request}"/>
<input:entry typeAttr="text" nameAttr="username" idAttr="user" classAttr="username"/>
<input:entry typeAttr="submit" nameAttr="submitBtn" idAttr="submitBtnId" classAttr="submitForm"/>
</form>
<nonce:hidden req="${pageContext.request}"/>
<%@ include file="/views/footer.jsp"%>
