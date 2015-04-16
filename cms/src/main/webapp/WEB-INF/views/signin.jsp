<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="org.apache.commons.lang3.RandomStringUtils" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/grid.css' />" rel="stylesheet"> 	
 	<script src="<c:url value='/resources/js/jquery-1.11.2.min.js' />"></script>
 	<script src="<c:url value='/resources/css/js/bootstrap.min.js' />"></script>
	<!--// Bootstrap -->
	
	<!-- jquery validate -->
	<script src="<c:url value='/resources/js/jquery.validate.min.js' />"></script>
	<script src="<c:url value='/resources/js/jquery.form.min.js' />"></script>
	<link href="<c:url value='/resources/css/customvalidator.css' />" rel="stylesheet">
	<!--// jquery validate -->
	
	<script type="text/javascript">
	if(location.href.indexOf('auth=fail')>0){	
		alert('Invalid email or password');
	}

	$(document).ready(function(){
		
	
		$('#signinForm').validate({
	
	            rules: {
	                email: { required: true,
	                         email: true
	                },
	                pwd: { required: true,
	                       minlength: 6
	                }                
	            },
	            messages: {
	               	email: { required: "Please enter your email",
	                			email: "Email Address is not valid" 
	                },
	                pwd: { required: "Please enter your password",
	                    minlength: "Minimum 6 characters required"
	                }                
	            },
	            submitHandler: function (form) {          
	                form.submit();
	            },
	            errorPlacement: function (label, element) {
	                label.addClass('arrow');
	                label.insertAfter(element);
	            }
	            ,wrapper: 'span'
	        });
	});		
	</script>
</head>

<c:choose>
<c:when test="${empty sessionScope.user}">
	
<body>
<div class="container">
 	<div class="page-header">
    	<h2>Sign In Page</h2>
    </div>
        

    <div id="1">
	<form:form id="signinForm" method="post" action="signin"  >			
		<div>
	    	<label id="label_email">Email</label>
	        <input  name="email"  type="text"/>
	    </div>
	    <div>
	    	<label>Password</label>
	        <input name="pwd"  type="password"/>	                    
	    </div>
	    <div>
	    	<label>Remember me</label>
	    	<input type="checkbox" name="rememberme" />
	    	<input name="_rememberme" type="hidden" value="on"/>
	    </div>
	    <div>
	    	<input name="submit" type="submit" value="submit"/>	    	
	    </div>
	</form:form>
	</div>

</div> 
    <!-- /container -->    
  </body>
</html>
</c:when>
<c:otherwise>
	<c:redirect url="index.html"></c:redirect>
</c:otherwise>
</c:choose>	            
