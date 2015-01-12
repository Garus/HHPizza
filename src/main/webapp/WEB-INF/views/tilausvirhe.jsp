<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title></title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger">Virhe tilauksessa!</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/" />" class="btn btn-primary">
                <span class="glyphicon-arrow-left glyphicon"></span>Etusivu
            </a>&nbsp;<a href="<spring:url value="/tuotteet" />" class="btn btn-primary">
            <span class="glyphicon-arrow-left glyphicon"></span>Tuotteet
        </a>
        </p>
    </div>
</section>
</body>
</html>
