<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Pizzeria Il Grasso - ${tuote.nimi}</title>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <div class="jumbotron">
            <h1>Tervetuloa Il Grassoon</h1>

            <p>Pääsette nauttimaan paikkakunnan parhaista pizzoista aina
                edulliseen hintaan!</p>
            <ul class="nav nav-pills nav-justified" style="margin: auto; width:50%; text-align:center;">
                <li role="presentation" class="active"><a class="btn btn-link" href="<spring:url value="/tuotteet" />">Tuotteet</a></li>
                <c:choose>
                    <c:when test="${sessionScope.ostoskori.getCount() > 0}">
                        <li role="presentation"><a href="<spring:url value="/ostoskori" />" class="btn btn-link">Ostoskori: ${sessionScope.ostoskori.getCount()}, yht: <fmt:formatNumber value="${sessionScope.ostoskori.getSum()}" type="currency"/></a></li>
                    </c:when>
                    <c:otherwise>
                        <li role="presentation"><a href="<spring:url value="/ostoskori" />" class="btn btn-link">Ostoskori</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">

            <div class="caption">
                <h3>${tuote.nimi}</h3>

                <p>${tuote.kuvaus}</p>

                <p>Hinta: <fmt:formatNumber value="${tuote.hinta + sum}" type="currency"/></p>

                <br>

                <p>
                    <a href="<spring:url value="/ostoskori/muokkaapizza/id?id=${tuote.id}" /> "
                       class="btn btn-default">Muokkaa</a> &nbsp;
                    <a href="<spring:url value="/ostoskori/lisaa?id=${tuote.id}" /> "
                       class="btn btn-primary">Lisää koriin</a> &nbsp;<input action="action" value="Takaisin"
                                                                             type="button" class="btn btn-default"
                                                                             onclick="history.go(-1);"/>
                </p>
            </div>
        </div>
    </div>
            <div class="footer">
                <div class="bottom-first">
                    <a href="../terms/terms.html"><p>Käyttöehdot</p>
                </div>
                <div class="bottom-second">
                    <p><a href="tuotteet/admin">Admin-tuotteet</a><br/>
                        <a href="kayttajat/">Admin-käyttäjät</a></p>
                    <p>Copyright © 2014 il Grasso</p>
                </div>
            </div>
    </body>
</html>