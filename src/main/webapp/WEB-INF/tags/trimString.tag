<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="value" type="java.lang.String" required="true"%>
<%@ attribute name="maxLength" type="java.lang.Integer" required="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
int length = value == null?0:value.length();
if(length <= maxLength){%>
	<%=value%>
<%}else{
	String sub = value.substring(0, maxLength);
	%>
	<a href="#" class="no_underline_link" data-rel="popover" data-content="<%=value%>" title="<%=sub%>..."><%=sub%>...</a>
<%} %>
