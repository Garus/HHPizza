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
    <link href="/css/hhpizza_basic.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Uusi kayttaja</title>
</head>
<body>
<div class="header">
    <div class="jumbotron">
        <h1>Tervetuloa Il Grassoon</h1>

        <p>Pääsette nauttimaan paikkakunnan parhaista pizzoista aina
            edulliseen hintaan!</p>
    </div>
</div>
<div class="content">

    <section class="container"><form:form
            modelAttribute="uusikayttaja" class="form horizontal">
        <form:hidden path="luotuPvm" id="luotuPvm"/>
        <fieldset>
            <legend>Uusi käyttajä</legend>
            <%--<div class="form-group">--%>
                <%--<label class="control-label " for="id"><spring:message--%>
                        <%--code="uusikayttaja.form.id.label"/></label>--%>

                <%--<div >--%>
                    <%--<label class="control-label " id="id">${uusikayttaja.id}</label>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label class="control-label " for="luotuPvm"><spring:message--%>
                        <%--code="uusikayttaja.form.luotu.label"/></label>--%>

                <%--<div >--%>
                    <%--<div >--%>
                        <%--<form:input id="luotuPvm" path="luotuPvm" type="text"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="form-group">
                <label class="control-label " for="kayttajaTunnus"><spring:message
                        code="uusikayttaja.form.tunnus.label"/></label>

                <div >
                    <div >
                        <form:input id="kayttajaTunnus" path="kayttajaTunnus" type="text"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label " for="nimi"><spring:message
                        code="uusikayttaja.form.name.label"/></label>

                <div >
                    <form:input id="nimi" path="nimi" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label " for="rooli"><spring:message
                        code="uusikayttaja.form.role.label"/></label>

                <form:select path="rooli.id" id="rooli" items="${roolit}" itemValue="id" itemLabel="rooli"/>
            </div>
            <div class="form-group">
                <div>
                    <input type="submit" id="btnAdd" class="btn btn primary"
                           value="${!empty kayttaja.id ? 'Lisää kayttaja' : 'Tallenna'}">
                    &nbsp;<input action="action" value="Takaisin"
                                 type="button" class="btn btn-default"
                                 onclick="history.go(-1);"/>
                </div>
            </div>
        </fieldset>
    </form:form></section>
</div>
</body>
</html>