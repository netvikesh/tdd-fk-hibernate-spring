<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="Header Tag" pageEncoding="UTF-8" %>
<%@ attribute name="pageCss" fragment="true" required="false" %>
<%@ attribute name="pageJs" fragment="true" required="false" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<c:if test="${not empty pageDescription}">
    <meta name="description" content="${pageDescription}">
</c:if>
<link rel="icon" href="/favicon.ico">
<title>${not empty title?title:""}</title>
<t:css/>
<jsp:invoke fragment="pageCss"/>