<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link href="<spring:url value="/css/hhpizza_basic.css" />"
          rel="stylesheet">
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
        <h1>Ei toteutusta vielä.</h1>

        <div><c:choose><c:when test="${answer eq 42}"><h2>${answer}: The answer to life, the universe and
            everything</h2></c:when><c:otherwise>${answer}</c:otherwise></c:choose></div>
    </div>
            <div class="footer">
                <div class="bottom-first">
                    <a href="terms/terms.html"><p>Käyttöehdot</p>
                </div>
                <div class="bottom-second">
                    <p><a href="tuotteet/admin">Admin-tuotteet</a><br/>
                        <a href="kayttajat/">Admin-käyttäjät</a></p>
                    <p>Copyright © 2014 il Grasso</p>
                </div>
            </div>
    </body>
</html>
