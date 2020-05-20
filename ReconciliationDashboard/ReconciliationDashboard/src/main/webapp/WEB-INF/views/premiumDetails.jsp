<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Premium Details</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="css/premium.css" rel="stylesheet">
</head>
<body>
<div id="i1">Dashboard<span id="i2">Reconciliation Dashboard</span></div>
<div class="container">
<div id="i3">
<form action="/premiumDetails" enctype="multipart/form-data" method="post">
<input type="file" name="file">
<input type="reset" value="clear">
<input type="submit" value="upload" name="submit">
<div id="error1">${message}</div>
<div id="success">${msg}</div>
</form>
</div>
<div id="search-box">
<form action="/fileUpload" method="get">
<input type="text" name="search" placeholder="Enter your Name...">
</form>
</div>
<div class="sidenav">
  <a href="#about">Dashboard</a>
  <a href="#services">Invoice</a>
  <a href="#clients">Remit & EOB (HMO)</a>
  <a href="#contact">Remit & EOB (FACETS)</a>
</div>

<table class="table table-striped">
<caption>Reconciliation Details</caption>
<thead><tr><th>Member ID</th><th>Member Name</th><th>Member Last Name</th><th>Contact Number</th><th>Salary</th></tr></thead>
<tbody>
<tr><td>${premium.memberId}</td><td>${premium.memberName}</td><td>${premium.memberLastName}</td><td>${premium.contactNumber}</td><td>${premium.salary}</td></tr>
<c:forEach items="${premiumlist}" var="list">
<tr><td>${list.memberId}</td><td>${list.memberName}</td><td>${list.memberLastName}</td><td>${list.contactNumber}</td><td>${list.salary}</td></tr>
</c:forEach>
</tbody>
</table>
</div>
<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>