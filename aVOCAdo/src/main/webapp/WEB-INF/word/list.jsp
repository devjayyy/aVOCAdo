<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>단어 목록</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/WEB-INF/navbar.jsp" %>

<div class="container">   
	<br>
	<h4>단어 목록</h4>
	<br>
	<table class="table table-bordered">
      <thead class="thead-inverse">
      	<tr>
		  <td>단어</td>
		  <td>뜻</td>		  
		</tr>
      </thead>
      <tbody> 
		<c:forEach var="word" items="${wordList}">  			  	
	  	    <tr>
			  <td>
			  	<a href="<c:url value='/word/view'>
						   <c:param name='wordsEng' value='${word.wordsEng}'/>
				 		 </c:url>">
				  ${word.wordsEng} </a>     
			  </td>		
			  <td>
			    ${word.wordsKor} 
			  </td>			  
			</tr>
		 </c:forEach> 
	  </tbody>
	</table>		  	 
	<br>      		     
</div>
</body>
</html>