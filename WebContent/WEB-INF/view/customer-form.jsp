<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> <!-- Bootstrap CSS --> <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>Customer Registration Form</title>
</head>
<body>
<h3>Customer Form for ${mode}</h3>
<form action="save" method="post">
<div class="form-inline">
<table class="table table-bordered table-striped">
	<input type="hidden" name="customerId" value="${customer.customerId}" class="form-control mb-4 col-4"/>
	<tr>
	<td> First Name : </td>
	<td>
	<input type="text" name="firstName" value="${customer.firstName}" placeholder="First Name" required=true class="form-control mb-4 col-4">
	</td>
	</tr>
	<tr>
	<td> Last Name : </td>
	<td>
	<input type="text" name="lastName" value="${customer.lastName}" placeholder="Last Name" required=true class="form-control mb-4 col-4">
	</td>
	</tr>
	<tr>
	<td> Email : </td>
	<td>
	<input type="text" name="email" value="${customer.email}" placeholder="Email" required=true class="form-control mb-4 col-4">
	</td>
	</tr>
	</table>
	<button type="submit" class="btn btn-info col-2">Save</button>

</div>
</form>
<a href="list">Back to Customers List</a>
</body>
</html>