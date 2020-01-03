<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/HuskyEZCreator.js"></script>
<script>
	$(function() {
		var oEditors = [];
		// Editor Setting 
		nhn.husky.EZCreator.createInIFrame({ oAppRef : oEditors, // 전역변수 명과 동일해야 함. 
											elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함. 
											sSkinURI : "${pageContext.request.contextPath }/resources/SmartEditor2Skin.html", // Editor HTML 스킨
											fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X 
											htParams : { // 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseToolbar : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseVerticalResizer : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseModeChanger : true, 
											} 
		});
		
		$("#btnSave").click(function() {
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
			var contents = $.trim(oEditors[0].getContents());
			//alert(contents);
			if(contents == "<p>&nbsp;</p>"){ //입력 x일 때
				alert("내용을 입력하세요.");
				oEditors.getById["smarteditor"].exec("FOCUS"); //포커스
				return false;				
			}
			$("form").submit(); //강제 submit
		})
	})
</script>
<style>
	#main{
		width: 780px;
		margin: 0 auto;
	}
	h1{
		width: 780px;
		border-bottom: 3px solid #aaa;
	}
	form{
		width: 100%;
	}
	label{
		width: 70px;
		margin: 0 30px;
		display: inline-block;
		border-bottom: 1px solid #ddd;
		text-align: center;
		font-size: 15px;
	}
	form p{
		line-height: 30px;
	}
	input{
		width: 500px;
	}
	#smarteditor{
		width: 766px;
		height: 412px;
	}
	#btns_wrap{
		text-align: center;
	}
	#btns_wrap input{
		width: 100px;
		height: 30px;
		background: #fff;
		border: 1px solid #ccc;
		border-radius: 5px;	
		cursor: pointer;	
	}
</style>
</head>
<body>
	<div id="main">
		<form action="register" method="post" enctype="multipart/form-data">
			<h1>뉴스 등록</h1>
			<p>
				<label>제목</label>
				<input type="text" name="nTitle">
			</p>
			<p>
				<label>소제목</label>
				<input type="text" name="nSubtitle">
			</p>
			<p>
				<label>카테고리</label>
				<select name="cName">
					<c:forEach var="category" items="${categoryList}">
						<option>${category}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>장르</label>
				<select name="gName">
					<c:forEach var="genre" items="${genreList}">
						<option>${genre}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>출처</label>
				<input type="text" name="nSource">
			</p>
			<p>
				<label>이미지</label>
				<input type="file" name="mainFile">
			</p>
			<p id="smarteditor_wrap">
				<textarea id="smarteditor" name="dContent" rows="" cols=""></textarea>
			</p>
			<p id="btns_wrap">
				<input type="button" value="등록" id="btnSave">
				<input type="button" value="돌아가기" id="btnBack">
			</p>
		</form>
	</div>
</body>
</html>