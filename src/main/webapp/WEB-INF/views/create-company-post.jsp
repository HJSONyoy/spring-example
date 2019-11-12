<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; \charset=ISO-8859-1">
<title>Spring Boot</title>
<link rel="stylesheet" href="/css/custom.css">
</head>
<body>
  <h1>Create company career form</h1>
  <hr>
  <form method=post action="create-company-post" modelAttribute="companyPost">
  회사명:<input type="text" name="company"/><br>
  부서명:<input type="text" name="department"/><br>
 소파트/셀:<input type="text" name="part"/><br>
 시작날짜(YYYY-MM-DD):<input type="text" name="start_date_cp"/><br>
 종료날짜(YYYY-MM-DD):<input type="text" name="end_date_cp"/><br>
 담당업무:<input type="text" name="title"/><br>
<!--  <label for="radio-1">Hidden<input type="radio" name="hide_cp" id="radio-1" value="1" /></label><br> -->
 내용 : <textarea name="content" rows="50" cols="30" wrap="off" style="width:80%"></textarea><br>
 <input type="submit" value="작성완료"/>
  </form>
  <hr>

</body>
</html>