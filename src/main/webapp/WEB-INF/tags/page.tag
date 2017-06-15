<%@ tag description="Page Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageCss" fragment="true" required="false" %>
<%@ attribute name="pageJs" fragment="true" required="false" %>
<html lang="${not empty lang?lang:'en'}">
<t:head/>
<jsp:doBody/>
<jsp:invoke fragment="pageJs"/>
<t:js/>
</html>