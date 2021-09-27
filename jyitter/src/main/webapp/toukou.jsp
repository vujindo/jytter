<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Twit,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃいったー</title>
<%
 	@SuppressWarnings("unchecked")
	ArrayList<Twit> twits = (ArrayList<Twit>)session.getAttribute("twitlist");
%>
</head>
<body>
	<p><img src="img/jyitter.png"></p>
	<h3>投稿完了</h3>
	<p>ツイットの投稿ありがとうございました！</p>
	<p><a href="./Top">トップページへ</a></p>
</body>
</html>