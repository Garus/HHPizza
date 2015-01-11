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
                <li role="presentation" class="active"><a class="btn btn-link" href="<spring:url value="/" />">Etusivu</a></li>
                <li role="presentation" class="active"><a class="btn btn-link" href="<spring:url value="/tuotteet" />">Tuotteet</a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.ostoskori.getCount() > 0}">
                        <li role="presentation"><a href="<spring:url value="/ostoskori" />" class="btn btn-link">Ostoskori: ${sessionScope.ostoskori.getCount()},
                            yht: <fmt:formatNumber value="${sessionScope.ostoskori.getSum()}" type="currency"/></a></li>
                    </c:when>
                    <c:otherwise>
                        <li role="presentation"><a href="<spring:url value="/ostoskori" />" class="btn btn-link">Ostoskori</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
    <div class="content">
        <section id="center-panel-grid">
            <c:choose>
            <c:when test="${tuotteet.size()>0}">
            <h3>Muokattavana olevat tuotteet (${tuotteet.size()})</h3>

            <div class="container">
                <c:forEach items="${tuotteet}" var="tuote">
                    <div class="row" style="padding: 10px">
                        <div>
                            <h3>${tuote.nimi}, ${tuote.id}</h3>

                            <p>${tuote.kuvaus}</p>
                            <table class="table">
                                <tr>
                                    <td>Pizza</td>
                                    <td></td>
                                    <td><fmt:formatNumber value="${tuote.hinta}" type="currency"/></td>
                                    <td></td>
                                </tr>

                                <c:choose>
                                    <c:when test="${tuote.aineet.size() > 0}">
                                        <c:forEach items="${tuote.aineet}" var="pizzanaine" varStatus="stat">
                                            <tr>
                                                <td>${pizzanaine.tuote.nimi}</td>
                                                <td>${pizzanaine.maara}</td>
                                                <td>&nbsp;<fmt:formatNumber value="${pizzanaine.tuote.hinta}"
                                                                            type="currency"/>
                                                        <%--<c:set var="sum" value="${sum + pizzanaine.getSumma()}"/>--%>
                                                </td>
                                                <td><a class="btn-link"
                                                       href="muokkaapizza/aine/${tuote.id}/${pizzanaine.tuote.id}">Poista</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="3"></td>
                                            <td>Ei lisäaineita</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                                <tr>
                                    <td colspan="2">Yhteensä:</td>
                                    <td><fmt:formatNumber value="${tuote.getSumma()}" type="currency"/></td>
                                    <td></td>
                                </tr>
                            </table>
                            <form method="get" action="muokkaapizza/lisaa">
                                <label for="aineet"><input type="submit" value="Lisää pizzaan"
                                                           class="btn btn-sm"/></label>
                                <form:select path="lisaAineet" name="aine" id="aineet" items="${lisaAineet}"
                                             itemValue="id"
                                             itemLabel="nimi"/>
                                <input type="hidden" value="${tuote.id}" name="pizza"/>
                            </form>
                            <a href="<spring:url value="/ostoskori/lisaamuokattu?id=${tuote.id}" /> "
                               class="btn btn-primary">Lisää koriin</a>
                            <a href="<spring:url value="/ostoskori/muokkaapizza/poista/${tuote.id}" /> "
                               class="btn btn-link">Poista</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            </c:when>
            <c:otherwise>
            Tuotteita ei ole muokattavana!<br>
            <a href="<spring:url value="/tuotteet" />">Tuotteet</a>
            </c:otherwise>
            </c:choose>
    </div>
    </section>
    <div class="footer">
        <div class="bottom-first">
            <a href="terms/terms.html">Käyttöehdot</a>
        </div>
        <div class="bottom-second">
            <p><a href="<spring:url value="/tuotteet/admin" />">Admin-tuotteet</a><br/>
                <a href="<spring:url value="/kayttajat" />">Admin-käyttäjät</a>
            </p>
            <p>Copyright © 2014 il Grasso</p>
        </div>
    </div>
</div>
</body>
</html>