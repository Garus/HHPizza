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
        <link href="css/hhpizza_basic.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pizzeria il Grasso</title>
    </head>
    <body>
            <div class="header">
                <div class="jumbotron">
                    <h1>Tervetuloa Il Grassoon</h1>

                    <p>Parhaat pizzat aina
                        edulliseen hintaan!</p>

                <ul class="nav nav-pills nav-justified" style="margin: auto; width:50%; text-align:center;">
                    <li role="presentation"><a href="tuotteet" class="btn btn-link">Tuotteet</a></li>
                    <c:choose>
                    <c:when test="${sessionScope.ostoskori.getCount() > 0}">
                        <li role="presentation"><a href="ostoskori" class="btn btn-link">Ostoskori: ${sessionScope.ostoskori.getCount()}, yht: <fmt:formatNumber value="${sessionScope.ostoskori.getSum()}" type="currency"/></a></li>
                    </c:when>
                        <c:otherwise>
                            <li role="presentation"><a href="ostoskori" class="btn btn-link">Ostoskori</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                </div>
            </div>
            <div class="content">
                <div class="content-first">
                    <h1>Avoinna</h1>
                    <h3>Maanantai-Torstai 10-22<br/>
                        Perjantai-Launtai 10-05<br/>
                        Sunnuntai 10-20
                    </h3>
                    <h3 style="padding-top:30px;">Tuotteemme:</h3>
                    <c:choose>
                        <c:when test="${kategoriat.size()>0}">
                            <c:forEach items="${kategoriat}" var="kategoria"><span style="font-size:large;">
                                <%--<a href="<spring:url value="/${kategoria.kategoriaNimi}" />">${kategoria.kategoriaNimi}</a>--%>

                                <a href="<spring:url value="/tuotteet/${kategoria.kategoriaNimi}" /> "
                                   >${kategoria.kategoriaNimi}</a></span><br/>

                            </c:forEach>  
                        </ul>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
                </div>
                <div class="content-second">
                    <img src="img/tarjous.jpg" height="350"/>
                    <p style="font-style: italic; font-size: small">Tarjoukset vain ravintolassa</p>
                </div>
                <div class="content-third">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3959.918602572212!2d25.011898060703754!3d60.24759159764025!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sfi!4v1418331112374" width="400" height="350" frameborder="0" style="border:0"></iframe>
                </div>
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