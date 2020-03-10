<%--<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>this is springMvc demo </h2>

<c:out value="jstl demo ${key}"/><br/>
    <c:forEach items="${users}" var="user">
    <c:out value="${user.username}"/><br/>
    <c:out value="${user.age}"/><br/>
</c:forEach>

<%=
  getServletConfig().getServletContext().getAttribute("myData")
%>