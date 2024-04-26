<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:list>
	<acme:list-column code="any.progress-log.list.label.recordId" path="recordId" width="40%"/>
	<acme:list-column code="any.progress-log.list.label.completeness" path="completeness" width="20%"/>
	<acme:list-column code="any.progress-log.list.label.comment" path="comment" width="40%"/>	
</acme:list>
