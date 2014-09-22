<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Pizzeria Il Grasso</title>
<link href="css/hhpizza_basic.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="jumbotron">
				<h1>Terveutloa Il Grassoon!</h1>
				<p>Pääsette nauttimaan paikkakunnan parhaista pizzoista aina
					edulliseen hintaan!</p>
			</div>
		</div>
		<div class="content">
			<div class="media">
				<a class="pull-left" href="#"> <img class="media-object"
					src="..." alt="...">
				</a>
				<div class="media-body">
					<h4 class="media-heading">${hello}</h4>
					<p>${world}</p>
				</div>

				<h2>
					<a href="pizzat/kaikki">Pizzat</a>
				</h2>

			</div>
		</div>
		<!-- Tämä div työntää footerin pohjalle. Jättäkää tyhjäksi -->
		<div class="push"></div>
	</div>
	<div class="footer">
		<p>Tänne laitetaan footer osio</p>
	</div>
</body>
</html>