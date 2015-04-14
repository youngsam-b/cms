<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<title>Adsense Java</title>

<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="title" content="Adsense Java" />
<meta name="description" content="Google Adsense, SEO, ,Google Analytics, Java, Spring MVC3, Mysql, Singapore" />
<meta name="keywords" content="Google Adsense, SEO, ,Google Analytics, Java, Spring MVC3, Mysql, Singapore" />
<meta name="Robots" content="INDEX,FOLLOW" />

<meta name="og:title" content="AdsenseJava" />
<meta name="og:description" content="Google Adsense, SEO, ,Google Analytics, Java, Spring MVC3, Mysql, Singapore" />
<meta name="og:keywords" content="Google Adsense, SEO, ,Google Analytics, Java, Spring MVC3, Mysql, Singapore" />
<meta property="og:site_name" content="Adsense Java" />
<meta property="og:image" content="<c:url value="/resources/img/fl.jpg" />" />

<link rel="icon" type="image/jpg" href="<c:url value="/resources/img/fl.jpg" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/metro-bootstrap.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/docs.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/validator.css" />" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.widget.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/common.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/customvalidator.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.cookie.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/url.min.js" />" ></script>
 
 <script type="text/javascript">
$(document).ready(function(){
	
	 $('#wf').validate({
         onkeyup: false,
         onclick: false,

         rules: {
             title: { required: true
             },
             body: { required: true
             }             
         },
         messages: {
             title: { required: "Please enter title"
             },
             body: { required: "Please enter body"
             }             
         },
         submitHandler: function (form) {
         	 /* var tmp=oEditors[0].getIR(); */
         	oEditors[0].exec("UPDATE_CONTENTS_FIELD", []);         	
         	
        	 if(tmp=='<p><br></p>'){
        		 alert('Please enter body');
        	 	return false;
        	 } 
        	 else
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
<script type="text/javascript">
$(document).ready(function(){
	var flag=url();
	
	if( flag.indexOf('signin')<0 &&	flag.indexOf('signout')<0 )
	{
		
			if($.cookie('snsBridge') &&	
		     <%=request.getSession().getAttribute("user")==null?true:false%> )
			{
				$('#hiddenform').submit();
			}
			
	}
	
	  $("input").keypress(function (e) {
	      var k = e.keyCode || e.which;
	      if (k == 13) {
	          return false; // !!!
	      }
	  });
});
</script>
</head>