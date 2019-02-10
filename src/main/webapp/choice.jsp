<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h2>QUIZ</h2>
<h4>Wybierz zakres</h4>
<form action="/quiz-app/questionnaire" method="post">
    <input type="radio" name="choice" value="english" checked> Angielski<br>
    <input type="radio" name="choice" value="multiplication"> Mnożenie<br>
    <input type="radio" name="choice" value="fractions"> Ułamki<br>
    <input type="submit" value="Wybierz">
</form>
</body>
</html>
