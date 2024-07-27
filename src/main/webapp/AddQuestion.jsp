<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <title>Question Form</title>
	<script src="${pageContext.request.contextPath}/js/Common.js"></script>
	 <meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"] {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #28a745;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="container">
<br>
<br>
    <h1>Question Form</h1>
   <!--  <form id="questionForm">--> 
        <div class="form-group">
        	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <label for="questionTitle">Question Title</label>
            <input type="text" id="questionTitle" name="questionTitle" required>
        </div>
        <div class="form-group">
            <label for="option1">Option 1</label>
            <input type="text" id="option1" name="option1" required>
        </div>
        <div class="form-group">
            <label for="option2">Option 2</label>
            <input type="text" id="option2" name="option2" required>
        </div>
        <div class="form-group">
            <label for="option3">Option 3</label>
            <input type="text" id="option3" name="option3" required>
        </div>
        <div class="form-group">
            <label for="option4">Option 4</label>
            <input type="text" id="option4" name="option4" required>
        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <input type="text" id="category" name="category" required>
        </div>
        <div class="form-group">
            <label for="rightAnswer">Right Answer</label>
            <input type="text" id="rightAnswer" name="rightAnswer" required>
        </div>
        <div class="form-group">
            <label for="difficultyLevel">Difficulty Level</label>
            <select id="difficultyLevel" name="difficultyLevel" required>
                <option value="EASY">Easy</option>
                <option value="MEDIUM">Medium</option>
                <option value="HARD">Hard</option>
            </select>
        </div>
        <button value="Add Question" onclick="AddQuestion()">Add Question</button>
    <!--  </form>-->
</div>

</body>
</html>