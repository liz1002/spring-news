<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#main{
		width: 780px;
		margin: 0 auto;
	}
	#main p{
		width: 780px;
		border-bottom: 3px solid #aaa;
		text-align: right;
		font-size: 20px;
		padding-bottom: 10px;
	}
	#main p a:hover{
		cursor: pointer;
		text-decoration: underline;
	}
	ul{
		list-style: none;
		width: 760px;
		overflow: hidden;
		border-bottom: 3px solid #aaa;
		padding: 0px 10px 20px;
	}
	ul li{
		width: 70px;
		float: left;
		text-align: center;
	}
	ul li.selec{
		text-decoration: underline;
		font-weight: bold;
	}
	ul li:hover{
		text-decoration: underline;
		font-weight: bold;
	}
	a{
		text-decoration: none;
		color: black;
	}
	table{
		width: 780px;
		margin: 0 auto;
		border: 2px solid #ccc;
		border-collapse: collapse;
	}
	td{
		border: 1px solid #ccc;
		padding: 2px 10px;
		font-size: 15px;
		text-align: center;
	}
	td.left{
		text-align: left;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$("#main ul li").click(function() {
			$("#main ul li").removeClass("selec");
			$(this).addClass("selec");
		})
	})
</script>
</head>
<body>
	<div id="main">
		<p><a href="register">기사 등록</a></p>
		<ul>
			<li class="${cName==null?'selec':''}"><a href="list">전체보기</a></li>
			<c:forEach var="category" items="${categoryList}">
			<li class="${cName==category?'selec':''}"><a href="list?cName=${category}">${category}</a></li>
			</c:forEach>
		</ul>
		<table>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>카테고리</td>
				<td>출처</td>
				<td>작성날짜</td>
			</tr>
			<c:forEach var="news" items="${newsList}">
			<tr>
				<td>${news.nNo}</td>
				<td class="left"><a href="detail?nNo=${news.nNo}">${news.nTitle}</a></td>
				<td>${news.cName}</td>
				<td class="left">${news.nSource}</td>
				<td>
					<fmt:formatDate value="${news.nRegdate}" pattern="yyyy.MM.dd HH:mm"/>  
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>