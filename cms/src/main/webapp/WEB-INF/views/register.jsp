<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<script src="<c:url value='/resources/js/customvalidator.js' />"></script>
	<link href="<c:url value='/resources/css/customvalidator.css' />" rel="stylesheet"> 
	<!--// jquery validate -->
	
	<script type="text/javascript">
		function ajaxupload(){	
		$("#fileUploadform").ajaxForm({
		 
		 data : {"subfolder":"icon"},
		 dataType: "json",
		 success:function(data) {		
			 $('#icon').val(data.hiddenpath);	
		     $('#imgicon').attr('src',data.imagepath);
		  }		  
		}).submit();
		}
	</script>
	
	<div class="col-lg-6">
		<form:form class="form-signin" id="registerForm" method="post" action="register"  modelAttribute="user" >
			<h2 class="form-signin-heading">Register</h2>
			 	<label for="inputEmail" class="sr-only">Email address</label>
			    <input type="email" name="email"  class="form-control" placeholder="Email address" />

			    <label for="username" class="sr-only">User Name</label>
			    <input type="text" name="username"  class="form-control" placeholder="User Name"  />

			    <label for="pwd" class="sr-only">Password</label>
			    <input type="password" name="pwd"  class="form-control" placeholder="Password"  />

			    <label for="pwd2" class="sr-only">Password Confirm</label>
			    <input type="password" name="pwd2"  class="form-control" placeholder="Password Confirm"  />

				<label for="random1" class="sr-only">${random}</label>
	     		<input name="random1" value='${random}' readonly="readonly" type="text" placeholder=""   class="form-control" placeholder="Password"   />

				<label for="random2" class="sr-only">Type above appears</label>
	        	<input name="random2" type="text"  class="form-control" placeholder="Type above appears"  />

	        	<input id="icon" name="icon" type="hidden" value="/resources/img/defaulticon.png" />			
			    <div>
					<button class="btn btn-lg btn-primary btn-block" type="submit" value="submit">Submit</button>
				</div>
		</form:form>
	</div>
	
	<div class="col-lg-6">				
		<form:form id="fileUploadform" method="post" action="iconupload" enctype="multipart/form-data">
			<div>
				<input type="file" name="file" class="form-control" />
			</div>
			<div>
				<img id="imgicon" src="<c:url value="/resources/img/defaulticon.png" />"  />
			</div>
			<div>
				<button name="upload" type="submit" value="upload" onclick="ajaxupload()" class="btn btn-lg btn-success" type="submit" value="submit">icon upload</button>				
			</div>
		</form:form>		
	</div>
	
	</tiles:putAttribute>		
</tiles:insertDefinition>
		
</c:otherwise>   
</c:choose>

