<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quiz Application</title>
<script src="${pageContext.request.contextPath}/js/Common.js"></script>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    .container {
        max-width: 800px;
        margin: 20px auto;
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        font-weight: bold;
    }
    .form-group input[type="text"], .form-group button {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .form-group button {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
    .form-group button:hover {
        background-color: #45a049;
    }
    .quiz-container {
        display: none;
    }
    .quiz-question {
        margin-bottom: 20px;
    }
    .quiz-question label {
        display: block;
        margin: 5px 0;
    }
    .quiz-submit-button {
        background-color: #008CBA;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    .quiz-submit-button:hover {
        background-color: #007B9A;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Quiz Application</h1>
    <div class="form-group" id="quiz-id-container">
        <label for="quizId">Enter Quiz ID:</label>
        <input type="text" id="quizId" name="quizId" required>
        <button onclick="getQuiz()">Get Quiz</button>
    </div>
    <div id="quiz-container" class="quiz-container"></div>
</div>
</body>
</html>