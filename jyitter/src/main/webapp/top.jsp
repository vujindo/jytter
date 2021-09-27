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
	<p><a href="./Top"><img src="img/jyitter.png"></a></p>
	<h3>投稿一覧</h3>
	<table border="1">
		<tr>
			<th>ユーザ名</th>
			<th>つぶやき内容</th>
			<th>日時</th>
		</tr>
<%
for (Twit tmp:twits) {
	out.println("<tr>");
	out.println("<td>" + tmp.getName() + "</td>");
	out.println("<td>" + tmp.getContent() + "</td>");
	out.println("<td>" + tmp.getTwitTime() + "</td>");
	out.println("</tr>");
}
%>
	</table>
	
	<hr>
	<h3>新規</h3>
	<form method="POST" action="./Toukou">
		<p>
			新規投稿<input type="text" name="name" size="30">
		</p>
		<p>
			つぶやき内容<input type="text" name="content" size="100">
		</p>
		<input type="submit" value="投稿する">
		<input type="reset" value="クリア">
	</form>
	
	<hr>
	<h3>つぶやき検索</h3>
	<form method="POST" action="./Search">
		<p>
			検索語句を入力してください。<input type="text" name="word" size="30">
		</p>
		<input type="submit" value="検索する">
		<input type="reset" value="クリア">
		
	</form>
</body>
</html>