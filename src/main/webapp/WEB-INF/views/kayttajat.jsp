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
        </div>
    </div>
    <div class="content">
        <div class="hh-kayttajat">
            <c:choose>
                <c:when test="${kayttajat.size()>0}">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Käyttäjätunnus</th>
                            <th>Käyttäjän nimi</th>
                            <th>Rooli</th>
                            <th>Liittymis päivämäärä</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${kayttajat}" var="kayttaja" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${kayttaja.kayttajaTunnus}</td>
                                <td>${kayttaja.nimi}</td>
                                <td>
                                    <select>
                                        <c:forEach items="${roolit}" var="rooli" varStatus="loop">
                                            <option
                                                    <c:if test="${rooli.id eq kayttaja.rooli.id}">selected="selected" </c:if>
                                                    value="${rooli.id}">${rooli.rooli}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td><fmt:formatDate value="${kayttaja.liitymisPvm}" type="both" dateStyle="full"
                                                    timeStyle="short"/></td>
                                <td valign="middle" align="right">
                                    <a href="<spring:url value="/kayttajat/admin/uusi?id=${kayttaja.id}" /> "
                                       class="btn btn-warning">Muokkaa</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td valign="middle" align="right" colspan="6"><a
                                    href="<spring:url value="/kayttajat/admin/uusi" /> "
                                    class="btn btn-inverse">Uusi käyttäjä</a></td>
                        </tr>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    Käyttäjiä ei ole lisätty!
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