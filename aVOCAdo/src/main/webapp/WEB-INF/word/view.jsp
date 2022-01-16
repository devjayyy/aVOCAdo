<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>단어 관리 - 정보 조회</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<%@include file="/WEB-INF/navbar.jsp" %>

<div class="container">  
	<br>
	<h4>단어 정보 조회</h4>
	<br>
	<table class="table table-sm table-striped">
    	<tbody> 
	  	  <tr>
			<th>단어</th>
			<td>${word.wordsEng}</td>
		  </tr>
		  <tr>
			<th>뜻</th>
			<td>${word.wordsKor}</td>
		  </tr>
		</tbody>
	</table>
	<br> 		     
    <a class="btn btn-primary" 
    	href="<c:url value='/word/add'>
     		     <c:param name='wordId' value='${word.wordId}'/>
     		     <c:param name='wordsEng' value='${word.wordsEng}'/>
     		     <c:param name='wordsKor' value='${word.wordsKor}'/>
		 	  </c:url>">단어장에 추가</a>
 
    <a class="btn btn-success" href="<c:url value='/word/list' />">단어 목록</a> 	    
    <br>	   
	    
	<!-- 단어장에 추가가 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	<c:if test="${addFailed}">
		<h6 class="text-danger"><c:out value="${exception.getMessage()}"/></h6>
    </c:if>  
</div>  
</body>
</html>