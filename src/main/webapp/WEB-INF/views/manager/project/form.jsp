<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:form>
	<acme:input-textbox code="manager.project.form.label.code" path="code"/>	
	<acme:input-textbox code="manager.project.form.label.title" path="title"/>	
	<acme:input-textarea code="manager.project.form.label.abstracto" path="abstracto"/>
	<acme:input-integer code="manager.project.form.label.cost" path="cost"/>
	<acme:input-url code="manager.project.form.label.link" path="link"/>
	<acme:input-checkbox code="manager.project.form.label.fatalErrors" path="fatalErrors"/>
	
<jstl:choose>
    <jstl:when test="${draftMode == true}">
        <jstl:choose>
            <jstl:when test="${acme:anyOf(_command, 'show|update|delete|publish')}">
                <acme:button code="manager.project.form.button.user-stories" action="/manager/user-story/list-for-project?projectId=${id}"/>
                <acme:submit code="manager.project.form.button.update" action="/manager/project/update"/>
                <acme:submit code="manager.project.form.button.delete" action="/manager/project/delete"/>
                <acme:submit code="manager.project.form.button.publish" action="/manager/project/publish"/>
            </jstl:when>
            <jstl:when test="${_command == 'create'}">
                <acme:submit code="manager.project.form.button.create" action="/manager/project/create"/>
            </jstl:when>
        </jstl:choose>
    </jstl:when>
    <jstl:otherwise>
        <acme:button code="manager.project.form.button.user-stories" action="/manager/user-story/list-for-project?projectId=${id}"/>
    </jstl:otherwise>
</jstl:choose>


</acme:form>




