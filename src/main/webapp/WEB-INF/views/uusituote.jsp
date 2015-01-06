<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link href="../css/hhpizza_basic.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Uusi tuote</title>
</head>
<body>
<div class="header">
    <div class="jumbotron">
        <h1>Tervetuloa il Grassoon</h1>

        <p>Parhaat pizzat aina
                    edulliseen hintaan!</p>
    </div>
</div>
<div class="content">                

    <section class="container"><form:form
            modelAttribute="uusituote" class="form horizontal">
        <fieldset>
            <legend>Uusi tuote</legend>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name"><spring:message
                        code="uusituote.form.name.label"/></label>

                <div class="col-lg-10">
                    <form:input id="name" path="nimi" type="text"/>
                    <form:errors path="nimi" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name"><spring:message
                        code="uusituote.form.price.label"/></label>

                <div class="col-lg-10">
                    <form:input id="price" path="hinta" type="text"/>
                    <form:errors path="hinta" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="description"><spring:message
                        code="uusituote.form.description.label"/></label>

                <div class="col-lg-10">
                    <form:textarea id="description" path="kuvaus" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn primary"
                           value="${!empty tuote.id ? 'Lisää tuote' : 'Tallenna'}">
                </div>
            </div>
        </fieldset>
    </form:form></section>
</div>
</body>
</html>