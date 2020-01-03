<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#main{
		width: 900px;
		margin: 0 auto;
	}
	#main p#btn{
		width: 900px;
		border-bottom: 3px solid #aaa;
		text-align: right;
		font-size: 20px;
		padding-bottom: 10px;
	}
	#btn a:hover{
		cursor: pointer;
		text-decoration: underline;
	}
	#wrap{
	}
	#wrap h2{
	}
	#wrap p#dateInfo{
		font-size: 14px;
	}
	#wrap p#dateInfo span{
		float: right;
	}
	#wrap h3{
		text-align: center;
	}
	#img_wrap{
		text-align: center;
		margin-bottom: 20px;
	}
	#content_wrap{
	
	}
	
</style>
</head>
<body>
	<div id="main">
		<p id="btn"><a href="list">기사 목록</a></p>
		<div id="wrap">
			<h2>${news.nTitle}</h2>
			<p id="dateInfo">
				기사등록 <fmt:formatDate value="${news.nRegdate}" pattern="yyyy.MM.dd HH:mm"/>
				<span>${news.cName} | ${news.gName}</span>
			</p>
			<hr>
			<h3>&ldquo; ${news.nSubtitle} &rdquo;</h3>
			<div id="img_wrap">
				<img src="${pageContext.request.contextPath}/upload/displayFile?filename=${news.nPath}">
			</div>
			<hr>
			<div id="content_wrap">${news.dContent}</div>
			<hr>
			<p>${news.nSource}</p>
			<p>${news.nLink}</p>
		</div>
	</div>
</body>
</html>