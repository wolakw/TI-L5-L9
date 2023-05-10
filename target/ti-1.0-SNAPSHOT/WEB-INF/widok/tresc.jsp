<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String jakaStrona = "/WEB-INF/widok/"+request.getParameter("jaka_strona")+".jsp"; %>
<jsp:include page="<%=jakaStrona%>"/>