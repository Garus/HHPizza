<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link href="../css/hhtuote_basic.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pizzeria Il Grasso</title>
</head>
<body>
    <div class="wrapper">
        <div class="header">
            <div class="jumbotron">
                <h1>Tervetuloa Il Grassoon</h1>
                <p>Pääsette nauttimaan paikkakunnan parhaista pizzoista aina
                        edulliseen hintaan!</p>
            </div>
        </div>
        <div class="content">
            <div>
                    Nimi: <span>${tuote.name}</span>
                    <p />
                    Hinta: <span>${tuote.price}</span>
                    <p />
                    Kuvaus: <span>${tuote.description}</span>
                    <p />
            </div>
        </div>
</body>
</html>