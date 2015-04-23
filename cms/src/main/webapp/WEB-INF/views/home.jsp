<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="com.cms.app.util.CategoryUtil"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	  <div class="jumbotron">
        <h2>snsBridge.com</h2>
        <hr>
        <p class="lead">
        	Totally free bridge service to connect to 15 world famous social network service.
        	<br/>
        	Article you write here will be automatically posted to your social network. 
        </p>        
        <p><a class="btn btn-lg btn-success" href="/register" role="button">Register</a></p>
        <hr>             
      </div>
	</tiles:putAttribute>
</tiles:insertDefinition>

