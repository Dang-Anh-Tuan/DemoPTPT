<%-- 
    Document   : statistic
    Created on : Nov 1, 2022, 10:31:12 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../config_jstl.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistic</title>
    </head>
    <body>
        <h1>Statistic by location </h1>
        <form method="POST">
            <select name="idLocation">
                <c:forEach items="${locations}" var="location">
                    <option value="${location.id}" 
                            ${location.id == student.getLocation().getId() ? 'selected' : ''}
                            >
                        ${location.name}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Statistic">
        </form>
        <a href="/DemoPT/student">Back</a>

    </body>
</html>
