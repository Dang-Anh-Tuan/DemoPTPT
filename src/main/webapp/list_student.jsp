<%-- 
    Document   : list_student
    Created on : Oct 30, 2022, 10:04:32 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="config_jstl.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List student</title>
        <style>
            table{
                font-size: 20px;
            }

            th, td {
                width: 300px;
                padding: 10px;
            }

            td {
                text-align: center;
            }
        </style>
    </head>
    <body>  
        <h1>Danh sach sinh vien</h1>
        <a href="student/add">Add Student</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Location</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value = "${student.id}"/></td>
                    <td><c:out value = "${student.name}"/></td>
                    <td><c:out value = "${student.age}"/></td>
                    <td><c:out value = "${student.location.name}"/></td>
                    <td>
                        <a href="student/delete?id=${student.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
