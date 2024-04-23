<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>${boardVO.boardTitle }</title>
</head>
<body>
   <h2>글 보기</h2>
   <div>
      <p>글 번호 : ${boardVO.boardId }</p>
   </div>
   <div>
      <p>제목 : </p>
      <p>${boardVO.boardTitle }</p>
   </div>
   <div>
      <p>작성자 : ${boardVO.memberId }</p>
      <!-- boardDateCreated 데이터 포멧 변경 -->
      <fmt:formatDate value="${boardVO.boardDateCreated }"
               pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
      <p>작성일 : ${boardDateCreated }</p>
   </div>
   <div>
      <textarea rows="20" cols="120" readonly>${boardVO.boardContent }</textarea>
   </div>
   <button onclick="location.href='list'">글 목록</button>
   <button onclick="location.href='modify?boardId=${boardVO.boardId }'">글 수정</button>
   <button id="deleteBoard">글 삭제</button>
   <form id="deleteForm" action="delete" method="POST">
   		<input type="hidden" name="boardId" value="${boardVO.boardId }">
   </form>
   
   <script type="text/javascript">
   		$(document).ready(function(){
   			$('#deleteBoard').click(function(){
   				let res = confirm("정말 삭제하시겠습니까?");
   				console.log(res);
   				if(res){
   					$('#deleteForm').submit(); // form 데이터 전송
   				}
   			}); // end deleteBoard.click
   		}); // end document.ready
   		
   
   </script>
</body>
</html>
