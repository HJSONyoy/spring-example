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
  <h1>Create Edu career form</h1>
  <hr>
  <form method=post action="create-edu-post" modelAttribute="eduPost">
 교육명:<input type="text" name="edu_intuition"/><br>
 교육기관명:<input type="text" name="edu_host"/><br>
 시작날짜(YYYY-MM-DD):<input type="text" name="start_date_ep"/><br>
 종료날짜(YYYY-MM-DD):<input type="text" name="end_date_ep"/><br>
 장소:<input type="text" name="location_ep"/><br>
 교육개요:<input type="text" name="title_ep"/><br>
<!--  <label for="radio-1">Hidden<input type="radio" name="hide_cp" id="radio-1" value="1" /></label><br> -->
 내용 : <textarea name="content_ep" rows="50" cols="30" wrap="off" style="width:80%"></textarea><br>
 <input type="submit" value="작성완료"/>
  </form>
  <hr>

</body>
</html>