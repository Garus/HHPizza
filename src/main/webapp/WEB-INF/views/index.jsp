<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link href="css/hhpizza_basic.css" rel="stylesheet">
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
        <div class="jumbotron">
            <c:choose>
                <c:when test="${kategoriat.size()>0}">
                    <c:forEach items="${kategoriat}" var="kategoria">
                        <%--<a href="<spring:url value="/${kategoria.kategoriaNimi}" />">${kategoria.kategoriaNimi}</a>--%>
                        <a href="<spring:url value="/tuotteet/${kategoria.kategoriaNimi}" /> "
                        class="btn btn-link">${kategoria.kategoriaNimi}</a>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
        </div>
        <h2>
            <a href="tuotteet/kaikki">Tuotteet</a><br>
            <a href="ostoskori">Ostoskori</a><br>
            <a href="tuotteet/admin">tuotteet/Admin</a><br>
            <a href="kayttajat/">käyttäjät</a>
        </h2>
    </div>
</div>
<!-- Tämä div työntää footerin pohjalle. Jättäkää tyhjäksi -->
<div class="push"></div>
<div class="footer">
    <p>Tänne laitetaan footer osio</p>
</div>
</body>
</html>