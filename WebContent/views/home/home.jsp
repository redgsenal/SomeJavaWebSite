<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>This is the HOME content.</p>
<c:forEach var="i" begin="1" end="5" step="1">
	<c:out value="${i}" />
	<br />
</c:forEach>