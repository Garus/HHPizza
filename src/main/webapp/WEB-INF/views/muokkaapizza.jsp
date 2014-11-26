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
        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">

            <div class="caption">
                <h3>Muokattavana olevat tuotteet</h3>

                <c:forEach items="${tuotteet}" var="tuote">
                    ${tuote.id} &nbsp; ${tuote.nimi} &nbsp; <fmt:formatNumber value="${tuote.hinta}"
                                                                                  type="currency"/>
                    <br>
                </c:forEach>

                <label for="aineet">Lisäaineet</label>
                <form:select path="lisaAineet" name="aine" id="aineet" items="${lisaAineet}" itemValue="id"
                             itemLabel="name"/>
            </div>
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