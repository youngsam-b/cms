<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="true" %>

<c:choose>
	<c:when test="${not empty sessionScope.user}">
		<c:redirect url="index.html"></c:redirect>
	</c:when>
	<c:otherwise>
		<tiles:insertDefinition name="defaultTemplate">
			<tiles:putAttribute name="body">
			
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
			<div align="center">				
				<form class="form-signin" id="signinForm" method="post" action="signin">
			        <h2 class="form-signin-heading">Sign in</h2>
			        <label for="inputEmail" class="sr-only">Email address</label>
			        <input type="email" name="email"  class="form-control" placeholder="Email address" required="" autofocus="">
			        <label for="inputPassword" class="sr-only">Password</label>
			        <input type="password" name="pwd"  class="form-control" placeholder="Password" required="">
			        <div class="checkbox">
			          <label>
			            <input type="checkbox" name="rememberme"> Remember me
			            <input name="_rememberme" type="hidden" value="on"/>
			          </label>
			        </div>
			        <button class="btn btn-lg btn-primary btn-block" type="submit" value="submit">Submit</button>
			      </form>
			</div>			      
		</tiles:putAttribute>
		</tiles:insertDefinition>
	</c:otherwise>      
</c:choose>	            
	