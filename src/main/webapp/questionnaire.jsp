<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pytanie</title>
</head>
<body>
    <h2>Pytanie tu numer pytania</h2>
    <p>${question.question}</p>
    <form action="questionnaire.jsp" method="post">
        <c:forEach var="answer" items="${question.answers}">
            <input type="button" value="${question.answer.answer}" onclick=""><br>
        </c:forEach>
    </form>
</body>
</html>
