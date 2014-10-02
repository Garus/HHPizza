<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Pizzeria Il Grasso</title>
</head>
<body>
	<section class="container"> <form:form
		modelAttribute="uusipizza" class="form horizontal">
		<fieldset>
			<legend>Uusi pizza</legend>
			<!-- 
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="id">
					Pizza ID </label>
				<div class="col-lg-10">
					<form:input id="id" path="id" type="text" class="form:input-large" />
				</div>
			</div>
			-->
			<div class="form-group">
				<label class="control-label col-lg-2" for="name"><spring:message
						code="uusipizza.form.name.label" /></label>
				<div class="col-lg-10">
					<form:input id="name" path="name" type="text" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="name"><spring:message
						code="uusipizza.form.price.label" /></label>
				<div class="col-lg-10">
					<form:input id="price" path="price" type="text" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="description"><spring:message
						code="uusipizza.form.description.label" /></label>
				<div class="col-lg-10">
					<form:textarea id="description" path="description" rows="2" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn primary"
						value="Lisää pizza" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>