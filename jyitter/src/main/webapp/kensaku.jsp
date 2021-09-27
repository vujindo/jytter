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
	ArrayList<Twit> twits = (ArrayList<Twit>)session.getAttribute("searchList");
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
	if (twits.isEmpty()) {
		out.println("<tr>");
		out.println("<td colspan='3'>適当なツイットがありません</td>");
		out.println("</tr>");
	}else {
		for (Twit tmp:twits) {
			out.println("<tr>");
			out.println("<td>" + tmp.getName() + "</td>");
			out.println("<td>" + tmp.getContent() + "</td>");
			out.println("<td>" + tmp.getTwitTime() + "</td>");
			out.println("</tr>");
		}
	}
%>
	</table>
	<hr>
	<p><a href="./Top">トップページへ</a></p>
</body>
</html>