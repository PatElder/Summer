<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>


<spring:url value="/go/main.css" var="mainCSS" />
<spring:url value="/go/script.js" var="scriptJS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="${mainCSS}" rel="stylesheet" />
<script src="${scriptJS}"></script>
<!-- Finish adding tags -->

<title>Blue Summer</title>
<style type="text/css">
body {
	background-image: url('./issues/DBError.png');
}
</style>
</head>
<body>${message}
	<br>
	<div
		style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">

		<h2>Checkout this font color. Loaded from 'main.css' file under '/css/go/' folder</h2>

		<div id="welcomeMessage"></div>



		<br> <br> Click <a
			href="https://crunchify.com/category/java-tutorials/"
			target="_blank">here</a> for all Java and <a
			href='https://crunchify.com/category/spring-mvc/' target='_blank'>here</a>
		for all Spring MVC, Web Development examples.<br>
	</div>
</body>
</html>