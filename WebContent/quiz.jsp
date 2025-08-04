<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Take Quiz</title>
</head>
<body>
    <h2>Java Quiz</h2>
    <form action="QuizServlet" method="post">
        <p>1. What is the size of int in Java?</p>
        <input type="radio" name="q1" value="16">16<br>
        <input type="radio" name="q1" value="32">32<br>
        <input type="radio" name="q1" value="64">64<br>

        <p>2. Which keyword is used for inheritance in Java?</p>
        <input type="radio" name="q2" value="implements">implements<br>
        <input type="radio" name="q2" value="extends">extends<br>
        <input type="radio" name="q2" value="inherits">inherits<br>

        <p>3. Which method is the entry point in Java?</p>
        <input type="radio" name="q3" value="start()">start()<br>
        <input type="radio" name="q3" value="main()">main()<br>
        <input type="radio" name="q3" value="run()">run()<br>

        <input type="submit" value="Submit Quiz">
    </form>
</body>
</html>
