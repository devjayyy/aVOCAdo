<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-success navbar-dark">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/user/list' />" id="navbardrop" data-toggle="dropdown">
       	사용자 관리(aVOCAdo)
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/user/list' />">사용자 목록</a>
        <a class="dropdown-item" href="<c:url value='/user/register' />">사용자 추가</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/community/list' />" id="navbardrop" data-toggle="dropdown">
       	스터디 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/community/list' />">스터디 목록</a>
        <a class="dropdown-item" href="<c:url value='/community/create/form' />">스터디 생성</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/word/list' />" id="navbardrop" data-toggle="dropdown">
       	단어 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/word/list' />">단어 목록</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/wordBook/list' />" id="navbardrop" data-toggle="dropdown">
       	단어장 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/wordBook/list' />">단어 목록</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/wordBook/list' />" id="navbardrop" data-toggle="dropdown">
       	시험접수 바로가기
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='https://exam.toeic.co.kr/receipt/receiptStep1.php' />">TOEIC</a>
      </div>
    </li>
    <c:if test="${userId ne null}">
      <li class="nav-item">
	    <a class="nav-link btn-link" href="<c:url value='/user/logout'/>">${userId}(로그아웃)</a>
	  </li>
    </c:if>
  </ul>
</nav>
