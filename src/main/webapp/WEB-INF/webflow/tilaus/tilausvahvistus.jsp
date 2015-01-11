<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Tilausvahvistus</title>
</head>

<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Tilausvahvistus</h1>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <form:form modelAttribute="tilaus" class="form-horizontal">
            <input type="hidden" name="_flowExecutionKey"
                   value="${flowExecutionKey}"/>

            <div
                    class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                <div class="text-center">
                    <h1>Tilausvahvistus</h1>
                </div>
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <address>
                            <strong>Asiakastiedot</strong> <br>
                                ${tilaus.tilaaja.nimi}<br>
                                ${tilaus.tilaaja.osoite.katuOsoite}
                            <br>
                                ${tilaus.tilaaja.osoite.postinumero.postiNumero}, ${tilaus.tilaaja.osoite.postinumero.postiToimiPaikka}
                            <br>
                                ${tilaus.tilaaja.puhelin}
                            <br>
                                ${tilaus.tilaaja.email}
                            <br>
                        </address>
                    </div>
                </div>
                <%--<div class="row">--%>
                    <%--<div class="col-xs-6 col-sm-6 col-md-6">--%>
                        <%--<address>--%>
                            <%--<strong>Toimitustiedot</strong> <br>--%>
                                <%--${tilaus.maksutapa}<br>--%>
                                <%--${tilaus.toimitustapa}--%>
                            <%--<br>--%>
                                <%--${tilaus.osoite}--%>
                        <%--</address>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <div class="row">

                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Tuote</th>
                            <th>#</th>
                            <th class="text-center">Hinta</th>
                            <th class="text-center">Yhteensä</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="korinTuote" items="${tilaus.ostoskori.tuotteet}">
                            <tr>
                                <td class="col-md-9"><em>${korinTuote.tuote.nimi}</em></td>
                                <td class="col-md-1" style="text-align: center">
                                        ${korinTuote.maara}</td>
                                <td class="col-md-1 text-center"><fmt:formatNumber value="${korinTuote.tuote.hinta}"
                                                                                   type="currency"/></td>
                                <td class="col-md-1 text-center"><fmt:formatNumber value="${korinTuote.summa}"
                                                                                   type="currency"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td class="text-right"><strong>Yhteensä:</strong></td>
                            <td>
                                <strong><fmt:formatNumber value="${tilaus.ostoskori.sum}" type="currency"/></strong>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <button id="back" class="btn btn-default"
                            name="_eventId_backTokysyyAsiakkaanTiedot">Takaisin
                    </button>

                    <button type="submit" class="btn btn-success"
                            name="_eventId_tilausVahvistettu">
                        Vahvista tilaus<span class="glyphicon glyphicon-chevron-right"></span>
                    </button>
                    <button id="btnCancel" class="btn btn-default"
                            name="_eventId_cancel">Peruuta
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
