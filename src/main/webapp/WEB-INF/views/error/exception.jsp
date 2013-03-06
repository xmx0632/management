<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>出错啦</title>
</head>

<body>
<div>
	<h1><span>出错啦.</span></h1>
<pre style="font-size: larger;">
请联系管理员  
 _____________
(  <a href="<c:url value="/"/>">>返回首页</a>  )
 ------------- 
       O 
        O   ^__^
         o  (oo)_______
            (__)       )\/\
                ||----w |
                ||     ||


${exception.message }

</pre>
</div>
</body>
</html>