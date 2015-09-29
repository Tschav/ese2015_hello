<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<table>
		<tr>
			<td>Id:</td>
			<td><c:out value="${userId}" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><c:out value="${user.firstName}" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><c:out value="${user.lastName}" /></td>
		</tr>
		<tr>
			<td>E-Mail:</td>
			<td><c:out value="${user.email}" /></td>
		</tr>
		<tr>
			<td>Team:</td>
			<td>
				<c:choose>
				<c:when test="${user.team!=null}">
				<c:out value="${user.team.teamName}"></c:out>
				</c:when>
				<c:otherwise>No Team</c:otherwise>
				</c:choose>
			</td>
		</tr>
</table>

<c:if test="${page_error != null }">
	<div class="alert alert-error">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<h4>Error!</h4>
		${page_error}
	</div>
</c:if>

<c:import url="template/footer.jsp" />