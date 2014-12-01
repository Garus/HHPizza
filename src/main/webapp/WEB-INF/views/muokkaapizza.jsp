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
                                                    <c:set var="sum" value="${sum + pizzanaine.getSumma()}"/>
                                                </td>
                                                <td><a class="btn-link" href="muokkaapizza/aine/${tuote.id}/${pizzanaine.tuote.id}">Poista</a></td>
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
                                    <td colspan="2">Yhteensä: </td>
                                    <td><fmt:formatNumber value="${tuote.hinta + sum}" type="currency"/></td>
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
                        </div>
                    </div>
                </c:forEach>
            </div>
            </c:when>
            <c:otherwise>
            Tuotteita ei ole muokattavana!
            </c:otherwise>
            </c:choose>
    </div>
    </section>
    <!-- Tämä div työntää footerin pohjalle. Jättäkää tyhjäksi -->
    <div class="push"></div>
</div>
<div class="footer">
    <p>Tänne laitetaan footer osio</p>
</div>
</body>
</html>