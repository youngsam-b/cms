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
</head>

<body>
<div class="container">

<c:choose>
<c:when test="${not empty sessionScope.user}">
	<script>
	location.href='/index.html';
	</script>	
</c:when>
<c:otherwise>

  
 	<div class="page-header">
    	<h2>Sign Up Page</h2>
    </div>
        

    <div id="1">
	<form:form id="registerForm" method="post" action="register"  modelAttribute="user" >			
		<div>
	    	<label id="label_email">Email</label>
	        <input  name="email"  type="text"/>
	    </div>
		<div>
	    	<label id="label_email">Name</label>
	        <input  name="username"  type="text"/>
	    </div>	    
	    <div>
	    	<label>Password</label>
	        <input name="pwd"  type="password"/>	                    
	    </div>
	    <div>
	    	<label>Password Confirm</label>
			<input name="pwd2"  type="password"/>
	    </div>
		<div>
	     	<input name="random1" value="<%= RandomStringUtils.randomAlphanumeric(10) %>" readonly="readonly" type="text" placeholder="" style="color:Blue;font-weight:bold;font-style:italic;" />                    
	     </div>
		<div >
			<label>Type above appears</label>
	        <input name="random2" type="text"  />                    
		</div>
		<div >
	        <input id="icon" name="icon" type="hidden" value="/resources/img/defaulticon.png" />                    
		</div>	      
	<input name="submit" type="submit" value="submit"  />	                
	</form:form>
	</div>
	<hr>
    <div id="2">
	<form:form id="fileUploadform" method="post" action="iconupload" enctype="multipart/form-data">
		<div>
			<input type="file" name="file"  />
		</div>
		<div>
			<img id="imgicon" src="<c:url value="/resources/img/defaulticon.png" />"  />
		</div>
	</form:form>
	<input name="upload" type="submit" value="upload" onclick="ajaxupload()" />    
    </div>		 	                
</c:otherwise>   
</c:choose>

	 <hr>
	        <p class="lead">
        	no , autoincrement , seed 1 , primary key <br/>
        	email, nvarchar(50)<br/>
        	pwd, nvarchar(30)<br/>
        	icon , nvarchar(100)<br/>
        	activated , boolean<br/>
        	str , nvarchar(100)<br/>
        	warn , int<br/>
        	banned , boolean<br/> 
        </p>
	 
     
    </div> 
    <!-- /container -->
    
  </body>
</html>