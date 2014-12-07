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
            <h1>Toimitusosoite</h1>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="tilaus" class="form-horizontal">
        <fieldset>
            <legend>Toimitusosoite:</legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="toimitustapa"/>Toimitustapa</label>
                <div class="col-lg-10">
                    <form:input id="toimitustapa" path="toimitustapa" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="maksutapa"/>Maksutapa</label>
                <div class="col-lg-10">
                    <form:input id="maksutapa" path="maksutapa" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="osoite">Osoite</label>

                <div class="col-lg-10">
                    <form:input id="osoite" path="osoite" type="text" class="form:input-large"/>
                </div>
            </div>

            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button id="back" class="btn btn-default" name="_eventId_backTokysyyAsiakkaanTiedot">Takaisin
                    </button>

                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value="Seuraava" name="_eventId_toimitusTiedotOk"/>
                    <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Peruuta</button>
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>
