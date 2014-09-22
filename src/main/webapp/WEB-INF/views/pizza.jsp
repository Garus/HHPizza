<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizza: ${pizza.id}</title>
</head>
<body>
	<div>
		Nimi: <span>${pizza.name}</span>
		<p />
		Hinta: <span>${pizza.price}</span>
		<p />
		Kuvaus: <span>${pizza.description}</span>
		<p />
	</div>
</body>
</html>