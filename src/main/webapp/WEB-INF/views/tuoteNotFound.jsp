<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/htmlcharset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/
ss/bootstrap.min.css">
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<title>Welcome</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="hero-unit center">
					<h1>
						${invalidTuoteId} <small><font
							face="Tahoma" color="red">${exception}</font></small>
					</h1>
					<br />
					<p>
						The page you requested could not be found, either contact your
						webmaster or try again. Use your browsers <b>Back</b> button to
						navigate to the page you have previously come from
					</p>
					<p>
						<b>Or you could just press this neat little button:</b>
					</p>
					<a href="<spring:url value="/" /> " class="btn btn-large btn-info"><i
						class="icon-home icon-white"></i>Etusivulle</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
