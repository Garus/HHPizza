<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customer</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Asiakastiedot</h1>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="tilaus.tilaaja" class="form-horizontal">
        <fieldset>
            <legend>Asiakastiedot</legend>

                <%--<div class="form-group">--%>
                <%--<label class="control-label col-lg-2 col-lg-2" for="id" />Customer Id</label>--%>
                <%--<div class="col-lg-10">--%>
                <%--<form:input id="id" path="id" type="text" class="form:input-large" />--%>
                <%--</div>--%>
                <%--</div>--%>

            <div class="form-group">
                <label class="control-label col-lg-2" for="nimi">Nimi</label>

                <div class="col-lg-10">
                    <form:input id="nimi" path="nimi" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="email">Sähköposti</label>

                <div class="col-lg-10">
                    <form:input id="email" path="email" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="katuOsoite">Katuosoite</label>

                <div class="col-lg-10">
                    <form:input id="katuOsoite" path="osoite.katuOsoite" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="postiNumero">Postinumero</label>

                <div class="col-lg-10">
                    <form:input id="postiNumero" path="osoite.postinumero.postiNumero" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="postiToimiPaikka">Postitoimipaikka</label>

                <div class="col-lg-10">
                    <form:input id="postiToimiPaikka" path="osoite.postinumero.postiToimiPaikka" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="puhelin">Puhelin</label>

                <div class="col-lg-10">
                    <form:input id="puhelin" path="puhelin" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value="Seuraava" name="_eventId_asiakasTiedotOk"/>
                    <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Peruuta</button>
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>
