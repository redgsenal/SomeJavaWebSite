<%@ include file="/views/header.jsp"%>
<div class="wrapper">
	<form action="/SomeWebSite/VerifyUser" method="POST">
		<label>Name: </label><input type="text" name="username">
		<nonce:input req="${pageContext.request}"/>
		<input type="submit" value="Submit">
	</form>
</div>

<%@ include file="/views/footer.jsp"%>
