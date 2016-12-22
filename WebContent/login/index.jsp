<%@ include file="/views/header.jsp"%>
<p>Login</p>

<input:form name="login" action="user_verify" class="userForm" id="userform" class="userentryform"/>
<nonce:input req="${pageContext.request}"/>
<%@ include file="/views/footer.jsp"%>
