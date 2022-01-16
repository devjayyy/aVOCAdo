<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>aVOCAdo! : 데일리 단어 암기 프로젝트</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script>
function login() {
   if (form.userId.value == "") {
      alert("사용자 ID를 입력하십시오.");
      form.userId.focus();
      return false;
   } 
   if (form.password.value == "") {
      alert("비밀번호를 입력하십시오.");
      form.password.focus();
      return false;
   }      
   form.submit();
}
</script>
<style>
    *{
        font-family: 'Sunflower', sans-serif;
    }
    h2 { text-align: left; }
   h3 { text-align: right; }
        
</style>
</head>
<body style="background-color:#71e08d">
 <table style="margin-left: auto; margin-right: auto;">

<div class="container"> 
   <br>
    <center>
   <div style="margin-top: 40px">
      <a href="loginForm.jsp">
      </a>      
   </div>
    <td bgcolor='#bbddbb' width=600>
   <br>
   <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
   <div class="col-lg-12">
      <c:if test="${loginFailed}">
         <h6 class="text-danger"><c:out value="${exception.getMessage()}"/></h6>
      </c:if>
   </div>     
    <h2>  LOGIN  </h2>
   <!-- login form  -->
   <form class="col-md-6 col-lg-6" name="form" method="POST" action="<c:url value='/user/login' />">
      <div class="form-group">   
           <input type="text" name="userId" class="form-control" placeholder="ID를 입력하세요"> 
       </div>       
       <div class="form-group">  
           <input type="password" name="password" class="form-control" placeholder="Password를 입력하세요"> 
       </div> 
      <div class="form-group">        
         <input type="button" class="btn btn-primary" value="Sign in" onClick="login()"> 
            <p></p>
         <a href="<c:url value='/user/register' />" class="btn btn-link">회원 가입 </a>
        </div>   
      
   </form> 
</td>
<td bgcolor='#bbddbb'>
   <div style="margin-top: 40px">
      <a href="loginForm.jsp">
      </a>      
   </div>
</td>
</div>
</table>  
<div align = "center">@made by.고노남신</div>
</body>
</html>