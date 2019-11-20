<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Portfolio Main page</title>
</head>
<body>
  <h1>My Portfolio Main Page</h1>
  <hr>

  <h2>1. Personal Data</h2>
  
  <h2>2. Company Career</h2>
   
  <table border="1">
  <tr>
  <td>company</td>
  <td>department</td>
  <td>part</td>
  <td>title</td>
  <td>date</td>
  <td>Edit</td>
  <td>Delete</td>
  </tr>
  
<c:if test="${not empty companyPostList}">
        <c:forEach var="o" items="${companyPostList}">
            <tr>
                <td>${o.company}</td>
                <td>${o.department}</td>
                <td>${o.part}</td>
                <td>${o.title}</td>   
                <td>${o.start_date_cp} ~ ${o.end_date_cp} </td>
                <td><a href="edit-company-post?id=${o.id_cp}">Edit</a></td>
                <td><a href="delete-company-post?id=${o.id_cp}">Delete</a></td>   
            </tr>
        </c:forEach>
</c:if>

  </table>
  <form action="create-company-post" method="get"><input type="submit" value="CREATE NEW COMPANY INFO"/></form>
  
  
  
  
  <h2>3. Education Career</h2>

    <table border="1">
  <tr>
  <td>Education intuition</td>
  <td>host</td>
  <td>date</td>
  <td>location</td>
  <td>title</td>
  <td>Edit</td>
  <td>Delete</td>
  </tr>
  <c:if test="${not empty eduPostList}">
        <c:forEach var="o" items="${eduPostList}">
            <tr>
                <td>${o.edu_intuition}</td>
                <td>${o.edu_host}</td>
                <td>${o.start_date_ep} ~ ${o.end_date_ep}</td>   
                <td>${o.location_ep} </td>
                <td>${o.title_ep} </td>
                <td><a href="edit-edu-post?id=${o.id_ep}">Edit</a></td>
                <td><a href="delete-edu-post?id=${o.id_ep}">Delete</a></td>   
            </tr>
        </c:forEach>
</c:if>
</table>
<form action="create-edu-post" method="get"><input type="submit" value="CREATE NEW EDUCATION INFO"/></form>
  <h2>4. Award Career</h2>

</body>
</html>