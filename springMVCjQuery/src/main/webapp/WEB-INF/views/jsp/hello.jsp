<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<form id="myform" action="seeResult">
			<br> 
			First name: <input type="text" name="firstName"  name="firstName" id="firstName" value="first"/> <br/> <br/>
			Last name: <input type="text" name="lastName" name="lastName" id="lastName" value="last"/><br /><br />
			<input type="button" name="valider" id="valider" value="valider">
		</form>
	</div>
</div>

<div class="container"></div>

<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

<script>
if(false) {
	$( "#lastName" ).click(function() {
		  alert( "Handler for .click() called." );
		  $("#myform").ajaxSubmit({url: '/hello/', type: 'post'})

		});
}
</script>
<script>
$(document).ready(function(e) {
	  $('#valider').click(function(event){
		    var $form = $('#myform');
		    // .serialize() to send the form input name-value pairs as params.
		    $.ajax({
		        // url can be obtained via the form action attribute passed to the JSP.
		        url: $form.attr("action"),
		        data: $form.serialize(),
		        type: "POST",
		        statusCode: {
		            404: function() {
		                alert("Employee not found");
		            },
		            405: function() {
		                alert("Not allow 405");
		            },
		            415: function() {
		                alert("not allow 415");
		            },
		            500: function() {
		                alert("Failed to update Employee skills");
		            }
		        }
	        });
		    alert($form.serialize());
	   });
	});
</script>
</body>
</html>