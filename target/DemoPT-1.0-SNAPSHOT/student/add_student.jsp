<%-- 
    Document   : add_student
    Created on : Oct 31, 2022, 9:16:31 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../config_jstl.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Student</h1>
        <form method="POST">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" placeholder="Enter your name ..."><br>
            <label for="age">Age:</label><br>
            <input type="text" id="age" name="age" placeholder="Enter your age ..."><br><br>
            <select name="idLocation">
                <c:forEach items="${locations}" var="location">
                    <option value="${location.id}">${location.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Submit">
        </form>
        <a href="/DemoPT/student">Back</a>

    </body>
</html>
