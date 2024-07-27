<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Question Submission</title>
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
        max-width: 600px;
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
    .form-group select, .form-group input[type="number"], .form-group input[type="text"] {
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
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    .form-group button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body onload="GetCategories()">
<div class="container">
    <h1>Question Submission</h1>
   <!--  <form id="CreateQuizForm"> action="/submit-question" method="post" -->
    
    	<div class="form-group" id="drop-container"></div>
        
	        <!--  <div class="form-group">
	            <label for="category">Category:</label>
	            <select id="category" name="category" required>
	                <option value="">- Select Category -</option>
	                <option value="java">Java</option>
	                <option value="python">Python</option>
	                <option value="javascript">JavaScript</option>
	                <option value="other">Other</option>
	            </select>
	        </div>-->
        
        <div class="form-group">
            <label for="numberOfQuestions">Number of Questions:</label>
            <input type="number" id="numberOfQuestions" name="numberOfQuestions" min="1" max="100" required>
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" maxlength="100" required>
        </div>
        <div class="form-group">
            <button type="submit" onclick=CreateQuiz()>Create Quiz</button>
        </div>
   <!-- </form>-->
</div>
</body>
</html>
