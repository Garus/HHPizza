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
    <style type="text/css">
        .hh-shoppingcart {
            margin: 20px;
        }
    </style>
    <title>Pizzeria Il Grasso</title>
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
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="hh-shoppingcart">
            <c:choose>
                <c:when test="${ostoskori.count>0}">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Tuote</th>
                            <th>Kuvaus</th>
                            <th>Hinta</th>
                            <th>Määrä</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ostoskori.tuotteet}" var="korinTuote" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}.</td>
                                <%--<a href="<spring:url value="/tuotteet/tuote?id=${korinTuote.tuote.id}" /> ">${korinTuote.tuote.nimi}</a>--%>
                                <td><span>${korinTuote.tuote.nimi}</span>
                            <c:choose>
                                <c:when test="${korinTuote.tuote.aineet.size() > 0}">
                                    <c:forEach items="${korinTuote.tuote.aineet}" var="pizzanaine" varStatus="stat">
                                        <br>${pizzanaine.maara}x ${pizzanaine.tuote.nimi}
                                            &nbsp;<fmt:formatNumber value="${pizzanaine.tuote.hinta}"
                                                                        type="currency"/>
                                                <c:set var="sum" value="${sum + pizzanaine.getSumma()}"/>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <%--<tr>--%>
                                        <%--<td colspan="3"></td>--%>
                                        <%--<td>Ei lisäaineita</td>--%>
                                    <%--</tr>--%>
                                </c:otherwise>
                            </c:choose>
                                </td>
                                <td>${korinTuote.tuote.kuvaus}</td>
                                <td><fmt:formatNumber value="${korinTuote.tuote.getSumma()}" type="currency"/></td>
                                <td>${korinTuote.maara}</td>
                                <td valign="middle" align="right">
                                    <a href="<spring:url value="/ostoskori/lisaalkm?id=${korinTuote.tuote.id}" /> "
                                       class="btn btn-warning">+</a>
                                    <a href="<spring:url value="/ostoskori/vahenna?id=${korinTuote.tuote.id}" /> "
                                       class="btn btn-warning">-</a>
                                <%--</td>--%>
                                <%--<td valign="middle" align="right">--%>
                                    <a href="<spring:url value="/ostoskori/poista?id=${korinTuote.tuote.id}" /> "
                                       class="btn btn-warning">Poista</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="2"></td>
                            <td colspan="4" align="right">Tuotteita yhteensä: ${ostoskori.count} <br/> Summa:
                                <fmt:formatNumber
                                        value="${ostoskori.sum}" type="currency"/><br>
                                <a href="<spring:url value="/tilaus" /> "
                                   class="btn btn-inverse">Tilaa tuotteet</a></td>
                        </tr>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    Ostoskorissa ei ole tuotteita!<br>
                    <a href="<spring:url value="/tuotteet" />">Tuotteet</a>
                </c:otherwise>
            </c:choose>
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
